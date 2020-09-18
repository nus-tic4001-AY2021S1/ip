package Duke; /**
 * Storage: deals with loading tasks from the file and saving tasks in the file
 */


import Duke.Tasks.Deadline;
import Duke.Tasks.Event;
import Duke.Tasks.Task;
import Duke.Tasks.Todo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Storage {

    // An array list of task objects
    private ArrayList<Task> taskList;

    /**
     * creating an TodoList object
     */
    public Storage() {
        taskList = TaskList.getList();
    }


    /* readFromFile
     * This method will read the data file from disk which will contain the data of previously saved tasks
     * It can handle the case that data folder is not exist. this method can auto create data folder and data file
     * @param filename A String that contains the file path
     *
     * */
    public void readFromFile(String filename) {
        try {
            if (!Files.isReadable(Paths.get(filename))) {
                Ui.showMessage("The data file i.e.: " + filename + " does not exists!");

                String folderPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "data";

                File folder = new File(folderPath);
                File myObj = new File(filename);

                if (!folder.exists() && !folder.isDirectory()) {
                    folder.mkdirs();
                    Ui.showMessage("Folder created:" + folder);
                } else {
                    Ui.showMessage("Folder exist");
                }
                Ui.showMessage("Now, New file created: " + myObj.getName());
                return;
            }




            BufferedReader reader = null;
            String tempString = null;
            int line = 1; //// the line number is started from 1st

            try {
                Ui.showMessage("Read tasks from txt file, line by line:" + filename);
                reader = new BufferedReader(new FileReader(filename));
                while ((tempString = reader.readLine()) != null) {
                    Ui.showMessage("Line" + line + ":" + tempString);
                    createTaskFromFile(tempString);
                    line++;
                }
                reader.close();
            } catch (FileNotFoundException | ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method will auto create relevant task from the data file
     * the task could be event task, deadline task, todo task
     *
     * @param line get the task content from txt file, which contains task type, task description, task status
     */
    private void createTaskFromFile(String line) throws ParseException {

        String taskDescription;
        String taskSchedule = null;

        String[] line_arr = line.split("\\|");
        /* get the value of TaskDetail & TaskDeadlineDetail */
        taskDescription = line_arr[2].trim();
        if (line_arr.length > 3) {
            taskSchedule = line_arr[3].trim();
        }

        Task task = new Task("default");
        DateTimeFormatter formatterEventSchedule = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        /* pass the value to Task:  todo / deadline /event, and lable the task status */
        if (line_arr[0].equals("D ") & line_arr[1].equals(" 1 ")) {
            task = new Deadline(taskDescription, LocalDate.parse(taskSchedule));
            task.setDone();
            taskList.add(task);
        } else if (line_arr[0].equals("D ") & line_arr[1].equals(" 0 ")) {
            taskList.add((new Deadline(taskDescription, LocalDate.parse(taskSchedule))));
        } else if (line_arr[0].equals("E ") & line_arr[1].equals(" 1 ")) {
            task = new Event(taskDescription, LocalDateTime.parse(taskSchedule, formatterEventSchedule));
            task.setDone();
            taskList.add(task);
        } else if (line_arr[0].equals("E ") & line_arr[1].equals(" 0 ")) {
            taskList.add(new Event(taskDescription, LocalDateTime.parse(taskSchedule, formatterEventSchedule)));
        } else if (line_arr[0].equals("T ") & line_arr[1].equals(" 1 ")) {
            task = new Todo(taskDescription);
            task.setDone();
            taskList.add(task);
        } else if (line_arr[0].equals("T ") & line_arr[1].equals(" 0 ")) {
            taskList.add(new Todo(taskDescription));
        }


    }


    /**
     * This method will write the data of Tasks from ArrayList to data file on disk
     *
     * @param filename a string specifying the full path and extension of data file
     */
    public void saveToFile(String filename) {


        File out = new File(filename);
        if (out.exists()) {
            out.delete();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
            for (int i = 0; i < taskList.size(); i++) {
                //  System.out.println(taskList);
                if (taskList.get(i) instanceof Deadline) {
                    bw.append("D ");
                    bw.append("| ").append(taskList.get(i).isDone() ? "1" : "0").append(" | ").append(taskList.get(i).getDescription()).append(" | ").append(((Deadline) taskList.get(i)).getDueDate().toString());
                } else if (taskList.get(i) instanceof Event) {
                    bw.append("E ");
                    bw.append("| ").append(taskList.get(i).isDone() ? "1" : "0").append(" | ").append(taskList.get(i).getDescription()).append(" | ").append(((Event) taskList.get(i)).getDueDateTime().toString());

                } else if (taskList.get(i) instanceof Todo) {
                    bw.append("T ");
                    bw.append("| ").append(taskList.get(i).isDone() ? "1" : "0").append(" | ").append(taskList.get(i).getDescription());

                }

                bw.append("\n");
            }
        } catch (IOException ex) {
            Ui.showMessage(ex.getMessage());
        }
        Ui.showMessage("Task save to disk txt file--->:" + filename);


    }


}

import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;

//// Pending to add the Java Doc into the system
public class TodoList {

    // An array list of task objects
    private ArrayList<Task> taskList;

    /**
     * creating an TodoList object
     */
    public TodoList() {
        taskList = new ArrayList<>();
    }


    /**
     * A method to list done all the tasks from the list and show the list to user.
     * Show the message to user and notify the user that "Here are the tasks in your list"
     */
    public void listAllTasks() {
        Ui.showMessage("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            Ui.showMessage((i + 1) + "." + taskList.get(i).toString());
        }
    }

    /**
     * Adding a Task object in ArrayList
     * The Task is in "Todo"
     *
     * @param toAddTaskDetails A String that holds the details of a task and it cannot be empty or null.
     */
    public void addToDoType(String toAddTaskDetails) {
        taskList.add(new Todo(toAddTaskDetails));
    }

    /**
     * Adding a Task object in ArrayList
     * The Task is in "Deadline"
     *
     * @param toAddTaskDetails A String that holds the details of a task and it cannot be empty or null.
     */
    public void addDeadlineType(String toAddTaskDetails) throws DukeException {
        if (!toAddTaskDetails.toLowerCase().contains(" /by")) {
            throw new DukeException("Cannot find '/by' in command.Please enter valid task details.");
        }

        if (toAddTaskDetails.split("(?i)/by").length < 2) {
            throw new DukeException("No deadline time found after keyword /by.Please enter valid task details.");
        }

        String taskDescription = (toAddTaskDetails.split("(?i)/by")[0]).trim();// splits case insensitive
        String taskDeadline = (toAddTaskDetails.split("(?i)/by")[1]).trim();// splits case insensitive
        taskList.add(new Deadline(taskDescription, taskDeadline));
    }

    /**
     * Adding a Task object in ArrayList
     * The Task is in "Event"
     *
     * @param toAddTaskDetails A String that holds the details of a task and it cannot be empty or null.
     */
    public void addEventType(String toAddTaskDetails) throws DukeException {
        if (!toAddTaskDetails.toLowerCase().contains(" /at")) {
            throw new DukeException("Cannot find '/at' in command.Please enter valid task details.");
        }

        if (toAddTaskDetails.split("(?i)/at ").length < 2) {
            throw new DukeException("No deadline time found after keyword /at.Please enter valid task details.");
        }

        String taskDescription = (toAddTaskDetails.split("(?i)/at")[0]).trim();// splits case insensitive
        String taskEventDate = (toAddTaskDetails.split("(?i)/at")[1]).trim();// splits case insensitive
        taskList.add(new Event(taskDescription, taskEventDate));
    }

    /**
     * A method to read the value from user.
     * Show the message to user and notify the user that a current task is added in the list
     *
     * @param input A String that holds the user input from the terminal
     */
    public void readTaskFromUser(String input) {
        Ui.showMessage("Got it. I've added this task:");
        int currentNewAddedTaskIndex = (taskList.size() - 1);
        Ui.showMessage("  " + taskList.get(currentNewAddedTaskIndex).toString());
        Ui.showMessage("Now you have " + taskList.size() + " tasks in the list.");
    }



    /* Level 6. Delete */

    public void markSelectedTaskDelete(String selectedTask) {
        try {
            // checking if the task number is given and empty string or null
            if (selectedTask.trim().equals("")) {
                throw new NullPointerException("TASK NUM is Empty/Null: Returning to Main Menu");
            }

            int taskIndex = Integer.parseInt(selectedTask) - 1;
            if (taskIndex < 0 || taskIndex > taskList.size()) {
                throw new ArrayIndexOutOfBoundsException("TASK NUM cannot be found in the task list: Returning to Main Menu");
            }


            for (int i = 0; i < taskList.size(); i++) {
                if (i == taskIndex) {

                    Ui.showMessage("Noted. I've removed this task: ");
                    Ui.showMessage("  " + taskList.get(i).toString());
                    taskList.remove(i);

                }

            }
            Ui.showMessage("Now you have " + taskList.size() + " tasks in the list.");


        } catch (Exception e) {
            Ui.showMessage(e.getMessage());
        }
    }


    /**
     * A method to mark the selected task as completed
     * update value of the task field:isDone = true
     *
     * @param selectedTask A String that holds the ID (number) of a task
     * @throws NullPointerException           If TASK NUM is Empty/Null: Returning to Main Menu
     * @throws ArrayIndexOutOfBoundsException If TASK NUM is invalid, TASK NUM cannot be found in the task list: Returning to Main Menu
     */
    public void markSelectedTaskDone(String selectedTask) {

        try {
            // checking if the task number is given and empty string or null
            if (selectedTask.trim().equals("")) {
                throw new NullPointerException("TASK NUM is Empty/Null: Returning to Main Menu");
            }

            int taskIndex = Integer.parseInt(selectedTask) - 1;
            if (taskIndex < 0 || taskIndex > taskList.size()) {
                throw new ArrayIndexOutOfBoundsException("TASK NUM cannot be found in the task list: Returning to Main Menu");
            }


            for (int i = 0; i < taskList.size(); i++) {
                if (i == taskIndex) {
                    Ui.showMessage("Nice! I've marked this task as done: ");
                    taskList.get(i).setDone();

                    Ui.showMessage("[" + taskList.get(i).getStatusIcon() + "] " + taskList.get(i).getDescription());
                }

            }


        } catch (Exception e) {
            Ui.showMessage(e.getMessage());
        }
    }

//
//    /*  Level 7:  readFromFile
//     * This method will read the data file from disk which will contain the data of previously saved tasks
//     *
//     *
//     * */
//    public void readFromFile(String filename) {
//        try {
//            if (!Files.isReadable(Paths.get(filename))) {
//                Ui.showMessage("The data file i.e.: " + filename + " does not exists!");
//                return;
//            }
//
//            BufferedReader reader = null;
//            String tempString = null;
//            int line = 1; //// the line number is started from 1st
//
//            try {
//                Ui.showMessage("Read tasks from txt file, line by line:"+filename);
//                reader = new BufferedReader(new FileReader(filename));
//                while ((tempString = reader.readLine()) != null) {
//                    System.out.println("Line" + line + ":" + tempString);
//                    createTaskFromFile(tempString);
//                    line++;
//                }
//                reader.close();
//            } catch (FileNotFoundException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//
//            } finally {
//                if (reader != null) {
//                    try {
//                        reader.close();
//                    } catch (IOException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//
//                }
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * @param line get the task content from txt file
//     */
//    private void createTaskFromFile(String line) {
//
//        String taskDescription;
//        String taskSchedule = null;
//
//        String[] line_arr = line.split("\\|");
//        /* get the value of TaskDetail & TaskDeadlineDetail */
//        taskDescription = line_arr[2].trim();
//        if (line_arr.length > 3) {
//            taskSchedule = line_arr[3].trim();
//        }
//
//        Task task = new Task("default");
//        /* pass the value to Task:  todo / deadline /event, and lable the task status */
//        if (line_arr[0].equals("D ") & line_arr[1].equals(" 1 ")) {
//            task = new Deadline(taskDescription, taskSchedule);
//            task.setDone();
//            taskList.add(task);
//        } else if (line_arr[0].equals("D ") & line_arr[1].equals(" 0 ")) {
//            taskList.add((new Deadline(taskDescription, taskSchedule)));
//        } else if (line_arr[0].equals("E ") & line_arr[1].equals(" 1 ")) {
//            task = new Event(taskDescription, taskSchedule);
//            task.setDone();
//            taskList.add(task);
//        } else if (line_arr[0].equals("E ") & line_arr[1].equals(" 0 ")) {
//            taskList.add(new Event(taskDescription, taskSchedule));
//        } else if (line_arr[0].equals("T ") & line_arr[1].equals(" 1 ")) {
//            task = new Todo(taskDescription);
//            task.setDone();
//            taskList.add(task);
//        } else if (line_arr[0].equals("T ") & line_arr[1].equals(" 0 ")) {
//            taskList.add(new Todo(taskDescription));
//        }
//
//
//    }
//
//
//    /**
//     * This method will write the data of Tasks from ArrayList to data file on disk, i.e., tasks.obj
//     *
//     * @param filename a string specifying the full path and extension of data file, for example,  "resources/tasks.obj"
//     */
//    public void saveToFile(String filename) {
//
//
//        File out = new File(filename);
//        if (out.exists()) {
//            out.delete();
//        }
//
//
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
//            for (int i = 0; i < taskList.size(); i++) {
//                if (taskList.get(i) instanceof Deadline) {
//                    bw.append("D ");
//                    bw.append("| ").append(taskList.get(i).isDone() ? "1" : "0").append(" | ").append(taskList.get(i).getDescription()).append(" | ").append(((Deadline) taskList.get(i)).getBy());
//                } else if (taskList.get(i) instanceof Event) {
//                    bw.append("E ");
//                    bw.append("| ").append(taskList.get(i).isDone() ? "1" : "0").append(" | ").append(taskList.get(i).getDescription()).append(" | ").append(((Event) taskList.get(i)).getAt());
//
//                } else if (taskList.get(i) instanceof Todo) {
//                    bw.append("T ");
//                    bw.append("| ").append(taskList.get(i).isDone() ? "1" : "0").append(" | ").append(taskList.get(i).getDescription());
//
//                }
//
//
//                bw.append("\n");
//            }
//        } catch (IOException ex) {
//            Ui.showMessage(ex.getMessage());
//        }
//        Ui.showMessage("Task save to disk txt file--->:" + filename);
//
//
//    }


}











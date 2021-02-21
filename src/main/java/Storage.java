import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import exceptions.DukeException;
import task.Deadlines;
import task.Events;
import task.Tasks;
import task.ToDos;




public class Storage {

    static final String CURRENTWORKINGDIR = System.getProperty("user.dir");
    private String path;
    private File f;

    /**
     * @param path Duke.txt file path
     */
    public Storage(String path) {
        this.path = CURRENTWORKINGDIR + path;
        this.f = new File(this.path);
    }

    /**
     * @param tasks List of tasks read from the file
     * @throws IOException any exception related to IO
     * @throws DukeException defined exception
     */
    public void load(TaskList tasks) throws IOException, DukeException {
        if (f.exists()) {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String line = s.nextLine();
                String[] taskDetail = line.split("\\|");
                String taskDate = "unknown date";
                String taskType = taskDetail[0];
                boolean taskStatus = checkStatus(taskDetail[1]);
                String taskDescription = taskDetail[2];
                if (taskDetail.length == 4) {
                    taskDate = taskDetail[3];
                }
                try {
                    switch (taskType) {
                    case "T":
                        tasks.add(createToDoTask(taskDescription, taskStatus));
                        break;
                    case "D":
                        tasks.add(createDeadlineTask(taskDescription, taskDate, taskStatus));
                        break;
                    case "E":
                        tasks.add(createEventTask(taskDescription, taskStatus, taskDate));
                        break;
                    default:
                        throw new DukeException("☹ OOPS!!!There are undefined task type in the file.");
                    }
                } catch (Exception e) {
                    throw new DukeException("☹ OOPS!!!"
                            + "I am unable to read from the file,please make sure the file is in the correct format.");
                }
            }
        } else {
            createDataFile(path);
        }
    }

    private static ToDos createToDoTask(String taskDescription, boolean tasStatus) {
        ToDos todo = new ToDos(taskDescription);
        todo.setTaskStatus(tasStatus);
        return todo;
    }

    private static Events createEventTask(String taskDescription, boolean tasStatus, String taskDate) {
        Events event = new Events(taskDescription, taskDate);
        event.setTaskStatus(tasStatus);
        return event;
    }

    private static Deadlines createDeadlineTask(String taskDescription, String taskDate, boolean tasStatus) {
        Deadlines ddl = new Deadlines(taskDescription, taskDate);
        ddl.setTaskStatus(tasStatus);
        return ddl;
    }


    private static boolean checkStatus(String content) {
        return content.equalsIgnoreCase("1");
    }


    /**
     * @param tasks list of tasks that are going to be saved to the data file
     * @throws IOException defined exception
     */
    public void save(TaskList tasks) throws IOException {
        FileWriter fw = new FileWriter(path);
        Iterator<Tasks> i = tasks.iterator();
        while (i.hasNext()) {
            fw.write(i.next().saveToString());
            fw.write("\n");
        }
        fw.close();
    }

    private static void createDataFile(String path) throws IOException {
        String folderPath = CURRENTWORKINGDIR + "/data";
        File folder = new File(folderPath);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
        }
        FileWriter fw = new FileWriter(path);
        fw.close();
    }
}

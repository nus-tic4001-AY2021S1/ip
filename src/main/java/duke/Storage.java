package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import duke.exceptions.DukeException;
import duke.tasks.Deadlines;
import duke.tasks.Events;
import duke.tasks.Task;
import duke.tasks.ToDos;

public class Storage {
    static final String CURRENTWORKINGDIR = System.getProperty("user.dir");
    private String path;
    private File f;

    /**
     * @param path constructor for storage class
     */
    public Storage(String path) {
        this.path = CURRENTWORKINGDIR + path;
        this.f = new File(path);
    }

    /**
     * @param tasks the current stored task list
     * @throws IOException any exception related to IO
     * @throws DukeException any defined exception
     */
    public void load(TaskList tasks) throws IOException, DukeException {
        if (f.exists()) {
            Scanner s = new Scanner(f);

            while (s.hasNext()) {
                String line = s.nextLine();
                String[] contents = line.split("\\|");

                String taskDate = "unknown date";
                String taskType = contents[0];
                boolean taskDoneStatus = checkDoneStatus(contents[1]);
                String taskDescription = contents[2];
                if (contents.length == 4) {
                    taskDate = contents[3];
                }

                try {
                    switch (taskType) {
                    case "T":
                        tasks.add(createToDos(taskDescription, taskDoneStatus));
                        break;
                    case "D":
                        tasks.add(createDeadlines(taskDescription, taskDate, taskDoneStatus));
                        break;
                    case "E":
                        tasks.add(createEvents(taskDescription, taskDate, taskDoneStatus));
                        break;
                    default:
                        throw new DukeException("☹ OOPS!!!There's unknown tasks type in the file.");
                    }
                } catch (Exception e) {
                    throw new DukeException("☹ OOPS!!!There is error in the file,please check the format.");
                }
            }
        } else {
            createDukeTxt(path);
        }
    }

    /**
     * @param tasks the current task list
     * @throws IOException any exception related to IO
     */
    public void save(TaskList tasks) throws IOException {
        FileWriter fw = new FileWriter(path);

        Iterator<Task> i = tasks.iterator();
        while (i.hasNext()) {
            fw.write(i.next().toSavingString());
            fw.write("\n");
        }

        fw.close();
    }

    private static void createDukeTxt(String path) throws IOException {
        String folderPath = CURRENTWORKINGDIR + "/data";
        File folder = new File(folderPath);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
        }
        FileWriter fw = new FileWriter(path);
        fw.close();
    }

    private static Events createEvents(String taskDescription, String taskDate, boolean taskDoneStatus) {
        Events e = new Events(taskDescription, taskDate);
        e.setDone(taskDoneStatus);
        return e;
    }

    private static Deadlines createDeadlines(String taskDescription, String taskDate, boolean taskDoneStatus) {
        Deadlines d = new Deadlines(taskDescription, taskDate);
        d.setDone(taskDoneStatus);
        return d;
    }

    private static ToDos createToDos(String taskDescription, boolean taskDoneStatus) {
        ToDos t = new ToDos(taskDescription);
        t.setDone(taskDoneStatus);
        return t;
    }

    private static boolean checkDoneStatus(String content) {
        return content.equalsIgnoreCase("1");
    }

}

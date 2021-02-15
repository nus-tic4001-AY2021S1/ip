package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import duke.exceptions.DukeException;
import duke.tasks.Deadlines;
import duke.tasks.Events;
import duke.tasks.Tag;
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
        this.f = new File(this.path);
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
                String[] tags = null;
                boolean taskDoneStatus = checkDoneStatus(contents[1]);
                String taskDescription = contents[2];
                if (contents.length == 4) {
                    if (contents[3].contains(Tag.getTagDiv())) {
                        tags = contents[3].split(Tag.getTagDiv());
                    } else {
                        taskDate = contents[3];
                    }
                } else if (contents.length == 5) {
                    taskDate = contents[3];
                    tags = contents[4].split(Tag.getTagDiv());
                }

                try {
                    switch (taskType) {
                    case "T":
                        Task t = createToDos(taskDescription, taskDoneStatus);
                        if (tags != null) {
                            addTags(t, tags);
                        }
                        tasks.add(t);
                        break;
                    case "D":
                        Task d = createDeadlines(taskDescription, taskDate, taskDoneStatus);
                        if (tags != null) {
                            addTags(d, tags);
                        }
                        tasks.add(d);
                        break;
                    case "E":
                        Task e = createEvents(taskDescription, taskDate, taskDoneStatus);
                        if (tags != null) {
                            addTags(e, tags);
                        }
                        tasks.add(e);
                        break;
                    default:
                        throw new DukeException("\u2639 OOPS!!!There's unknown tasks type in the file.");
                    }
                } catch (Exception e) {
                    throw new DukeException("\u2639 OOPS!!!There is error in the file,please check the format.");
                }
            }
        } else {
            createDukeTxt(path);
        }
    }

    private void addTags(Task t, String[] tags) {
        for (String tag : tags) {
            t.addTag(tag);
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
            Task t = i.next();
            if (t.existTags()) {
                fw.write(t.toSavingStringWithTag());
            } else {
                fw.write(t.toSavingString());
            }

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

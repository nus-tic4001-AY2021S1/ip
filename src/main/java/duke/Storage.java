package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A <code>Storage</code> class contains methods that load Tasks
 * from the hard disk and save tasks to the hard disk.
 */
public class Storage {
    private final String filePath;

    /**
     *  Instantiate a <code>Storage</code> object.
     *
     * @param filePath Path of the text file used for storing app data.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     *  Load list of tasks from text file.
     *
     * @throws DukeException If file folder is unable to be created.
     */
    public ArrayList<Task> loadTasks(String filePath) throws DukeException {
        try {
            Path path = Paths.get("data/");
            if (!(Files.exists(path))) {
                Files.createDirectory(path);
            }
        } catch (IOException e) {
            throw new DukeException("I've problem creating the save directory!");
        }

        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<String> lines;

        lines = getLines(filePath);
        for (String line : lines) {
            if (!(line.trim().isEmpty())) {
                tasks.add(createTask(line));
            }
        }
        return tasks;
    }

    /**
     *  Save information of all <code>Tasks</code> objects to text file.
     *
     * @throws IOException If text file is not found or inaccessible.
     */
    public void saveTasks(TaskList tasks) throws DukeException {
        FileWriter fw;

        try {
            fw = new FileWriter(filePath);

            for (int i = 0; i < tasks.getSize(); i++) {
                String isDone;
                if (tasks.getTask(i).getIsDone()) {
                    isDone = "1";
                }
                else {
                    isDone = "0";
                }

                String description = tasks.getTask(i).getDescription();
                String lineToSave = null;
                if (tasks.getTask(i) instanceof Todo) {
                    lineToSave = "T" + " | " + isDone + " | " + description + System.lineSeparator();
                } else if (tasks.getTask(i) instanceof Deadline) {
                    String by = ((Deadline) tasks.getTask(i)).getBy();
                    lineToSave = "D" + " | " + isDone + " | " + description + " | " + by + System.lineSeparator();
                } else if (tasks.getTask(i) instanceof Event) {
                    String at = ((Event) tasks.getTask(i)).getAt();
                    lineToSave = "E" + " | " + isDone + " | " + description + " | " + at + System.lineSeparator();
                }
                fw.write(lineToSave);
            }
            fw.close();
        } catch (IOException e) {
            throw new DukeException("I've problem reading the save file.");
        }
    }

    private Task createTask(String line) {
        String taskType = line.split("\\|")[0].trim();
        String isDoneString = line.split("\\|")[1].trim();
        String description = line.split("\\|")[2].trim();

        boolean isDone;
        if (isDoneString.equals("1")) {
            isDone = true;
        } else {
            isDone = false;
        }

        if (taskType.equals("D")) {
            String by = line.split("\\|")[3].trim();
            return new Deadline(description, by, isDone);
        } else if (taskType.equals("E")) {
            String at = line.split("\\|")[3].trim();
            return new Event(description, at, isDone);
        } else {
            return new Todo(description, isDone);
        }
    }

    private ArrayList<String> getLines(String filePath) throws DukeException {
        File f = new File(filePath);
        ArrayList<String> result = new ArrayList<>();
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                result.add(s.nextLine());
            }
        } catch (IOException e) {
            throw new DukeException("I've problem reading the save file. Let's start with an empty task list instead.");
        }
        return result;
    }
}
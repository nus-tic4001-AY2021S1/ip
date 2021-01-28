package storage;

import data.Deadline;
import data.Event;
import data.Task;
import data.Todo;
import exception.DukeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {

    private String filePath = "";

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    /**
     * load() extracts values from each line and creates tasks to be loaded for Duke.
     * @return loadedTasks
     * @throws FileNotFoundException
     * @throws DukeException
     * @throws NoSuchFileException
     */
    public List<Task> load() throws FileNotFoundException, DukeException, NoSuchFileException {
        List<Task> loadedTasks = new ArrayList<>();

        List<String> lines = getLines(this.filePath);
        for (String line : lines) {
            if (line.trim().isEmpty()) { //ignore empty lines
                continue;
            }
            loadedTasks.add(createTask(line)); //convert the line to a task and add to the list
        }
        return loadedTasks;
    }

    /**
     * Creates a task based on the line read in from the tasks.txt file.
     * If it is a T then todo is created,
     * If it is a D then deadline is created.
     * If it is a E then a event is created.
     *
     * @param line
     * @return Task
     */
    private Task createTask(String line) throws DukeException {
        Task task = null;
        String[] s = line.split("\\|");
        if (s[0].trim().equals("T")) {
            task = new Todo(s[2].trim());
            if ((1 == Integer.parseInt(s[1].trim()))) {
                task.setDone(true);
            }
        } else if (s[0].trim().equals("D")) {
            task = new Deadline(s[2], s[3]);
            if ((1 == Integer.parseInt(s[1].trim()))) {
                task.setDone(true);
            }
        } else if (s[0].trim().equals("E")) {
            task = new Event(s[2], s[3]);
            if ((1 == Integer.parseInt(s[1].trim()))) {
                task.setDone(true);
            }
        } else {
            throw new DukeException("Error in creating a task from save file");
        }
        return task;
    }

    /**
     * Returns the lines in the form of a List<String> variable.
     *
     * @param filePath
     * @return List<String> lines
     * @throws IOException
     */
    private List<String> getLines(String filePath) throws DukeException {
        List<String> lines = new ArrayList<String>();

        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (Exception e) {
            throw new DukeException("Error in creating a task from save file");
        }
        return lines;
    }

    public void save(List<Task> tasks) {
        Path newDirectory;
        try {
            Path path = Path.of("data").resolve("tasks.txt");

            boolean exists = Files.exists(path);

            if (!exists) {
                newDirectory = Files.createDirectories(Path.of("data"));
                path = Files.createFile(newDirectory.resolve("tasks.txt"));
            }
            Files.writeString(path, "", StandardCharsets.ISO_8859_1);
            for (Task task : tasks) {
                Files.writeString(path, task.save(), StandardCharsets.ISO_8859_1, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {

        }
    }

    public void saveBackup(List<Task> tasks) {

        try {


            FileWriter fw = new FileWriter(this.filePath);

            // create a File for the given file path
            File f = new File(this.filePath);

            // create a Scanner using the File as the source
            Scanner s = new Scanner(f);

            for (Task task : tasks) {
                if (s.hasNext()) {
                    fw.write("\r\n");
                }
                fw.write(task.save());
            }
            fw.close();
        } catch (IOException e) {

        }
    }
}

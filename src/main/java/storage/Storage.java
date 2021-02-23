package storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import data.Deadline;
import data.Event;
import data.Task;
import data.TaskList;
import data.Todo;
import exception.DukeException;
import ui.Ui;

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
     *
     * @return loadedTasks
     * @throws FileNotFoundException
     * @throws DukeException
     * @throws NoSuchFileException
     */
    public String load(TaskList list) {
        List<String> lines = getLines(this.filePath);

        if (lines.size() < 1) {
            return String.format("No tasks found in " + filePath + "\n" + "Add some Tasks~");
        } else {
            for (String line : lines) {
                if (line.trim().isEmpty()) { //ignore empty lines
                    continue;
                }
                list.addTask(createTask(line)); //convert the line to a task and add to the list
            }
        }
        return String.format("Successfully loaded tasks from " + filePath);
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
    private Task createTask(String line) {
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
            Ui.printError("Error in creating a task from save file");
        }
        return task;
    }

    /**
     * Returns the lines in the form of a list with String type variable.
     *
     * @param filePath
     * @return ListString lines
     * @throws IOException
     */
    private List<String> getLines(String filePath) {
        List<String> lines = new ArrayList<String>();

        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            Ui.printError(e.getMessage());
        }
        return lines;
    }

    /**
     * Save the current list of tasks.
     *
     * @param tasks
     * @throws DukeException
     */
    public void save(List<Task> tasks) throws DukeException {
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
            Ui.printError(e.getMessage());
        }
    }
}

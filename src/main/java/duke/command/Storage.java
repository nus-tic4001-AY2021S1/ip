package duke.command;


import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Storage {


    private static String filePath;
    static Ui ui = new Ui();

    /**
     * This constructs duke tasks with string filepath.
     *
     * @param filePath task save file path.
     */
    public Storage(String filePath) {
        Storage.filePath = filePath;
    }

    /**
     * This function is to save tasks in storage file.
     *
     */
    public static String writeTaskToFile(List<Task> tasks) {
        File out = new File(filePath);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
            for (Task task : tasks) {
                if (task instanceof Deadline) {
                    bw.append("D ");
                    bw.append("| ").append(task.isDone() ? "1" : "0").append(" | ")
                            .append(task.getDescription()).append(" | ").append(((Deadline) task).getBy());
                } else if (task instanceof Event) {
                    bw.append("E ");
                    bw.append(" | ").append(task.isDone() ? "1" : "0").append(" | ")
                            .append(task.getDescription()).append(" | ").append(((Event) task).getAt());
                } else if (task instanceof Todo) {
                    bw.append("T ");
                    bw.append(" | ").append(task.isDone() ? "1" : "0").append(" | ")
                            .append(task.getDescription());
                }
                bw.append(System.lineSeparator());
            }
        } catch (IOException ex) {
            ui.showToUser(ex.getMessage());
        }
        return "Tasks save to disk " + filePath;
    }

    /**
     * This function is to read task from storage file line by line.
     *
     * @param filePath tasks' save filepath.
     * @return tasks line by line.
     */
    public List<String> getLines(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            for (String line; (line = br.readLine()) != null; ) {
                lines.add(line);
            }
        } catch (IOException ex) {
            ui.showToUser(ex.getMessage());
        }
        ui.showToUser(lines);
        return lines;
    }

    /**
     * his function is to convert the line to a task and add to the list.
     *
     * @param line storage tasks line by line
     * @return task array list
     */
    @SuppressWarnings("checkstyle:Indentation")
    public static Task createTask(String line) throws TaskException {
        Task task = null;
        String type = line.split("\\|")[0].trim();
        boolean isDone = line.split("\\|")[1].trim().equals("1");
        String desc = line.split("\\|")[2].trim();
        switch (type) {
            case "T":
                task = new Todo(desc);
                task.setDone(isDone);
                break;
            case "D":
                String by = line.split("\\|")[3].trim();
                task = new Deadline(desc, getDate(by));
                task.setDone(isDone);
                break;
            case "E":
                String at = line.split("\\|")[3].trim();
                task = new Event(desc, at);
                task.setDone(isDone);
                break;
            default:
                break;
        }
        return task;
    }

    /**
     * This function is to convert MMM d yyyy string to yyyy-MM-dd.
     *
     * @param startDate input date string MMM d yyyy
     * @return output date string yyyy-MM-dd
     */
    public static String getDate(String startDate) {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MMM d yyyy");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return LocalDate.parse(startDate, inputFormat).format(outputFormat);
    }

    /**
     * This function is to load tasks from storage file.
     *
     * @return loaded tasks
     * @throws TaskException if problem reading file can throw this exception.
     */
    public List<Task> readTaskFromFile() throws TaskException {
        List<Task> loadedTasks = new ArrayList<>();
        List<String> lines = getLines(filePath);
        for (String line : lines) {
            if (line.trim().isEmpty()) { //ignore empty lines
                throw new TaskException("OOPS!!!folder does not exist yet!");
            }
            loadedTasks.add(createTask(line)); //convert the line to a task and add to the list
        }
        return loadedTasks;
    }
}

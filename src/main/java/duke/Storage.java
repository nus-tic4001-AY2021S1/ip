package duke;

import duke.tasks.Task;
import duke.tasks.Todo;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.TaskList;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

/**
 * Storage class handles List of task as tempStorage.
 */

public class Storage {
    private static final String home = "data";
    private static java.nio.file.Path storageFilePath = java.nio.file.Paths.get(home, "duke.txt");
    private static boolean directoryExists = java.nio.file.Files.exists(storageFilePath);

    private boolean isExit;

    public Storage(TaskList taskList) {
        isExit = false;
        try {
            loadFromFile(taskList);
        } catch (IOException e) {
            System.out.println(e);
        } catch (DukeException a) {
            System.out.println(a);
        }
    }

    public void loadFromFile(TaskList tempStorage) throws IOException, DukeException {
        File directory = new File(home);
        if (!directoryExists) {
            directory.mkdir();
        }
        File storage = storageFilePath.toFile();
        BufferedReader fileReader = new BufferedReader(new FileReader(storage));
        String savedTask;
        while ((savedTask = fileReader.readLine()) != null) {
            String taskType = savedTask.split(" \\| ",4)[0];
            String isDone = savedTask.split(" \\| ",4)[1];
            String taskDescription = savedTask.split(" \\| ",4)[2];
            switch (taskType) {
            case "T":
                tempStorage.addTask(new Todo(taskDescription));
                if (isDone.matches("1")) {
                    tempStorage.setDoneAt(tempStorage.getSize() - 1);
                }
                break;
            case "D":
                String taskDeadline = savedTask.split(" \\| ",4)[3];
                tempStorage.addTask(new Deadline(taskDescription,taskDeadline));
                if (isDone.matches("1")) {
                    tempStorage.setDoneAt(tempStorage.getSize() - 1);
                }
                break;
            case "E":
                String taskEventTime = savedTask.split(" \\| ",4)[3];
                tempStorage.addTask(new Event(taskDescription,taskEventTime));
                if (isDone.matches("1")) {
                    tempStorage.setDoneAt(tempStorage.getSize() - 1);
                }
                break;
            default:
                break;
            }
        }
        fileReader.close();
    }

    public void saveToFile(TaskList tempStorage) throws IOException {
        File storage = storageFilePath.toFile();
        BufferedWriter toSaveTask = new BufferedWriter(new FileWriter(storage));
        for (int i = 0;i < tempStorage.getSize();i++) {
            toSaveTask.write(outputTaskForSave(tempStorage.getTask(i)));
            if (i != tempStorage.getSize() - 1) {
                toSaveTask.newLine();
            }
        }
        toSaveTask.close();
    }

    public String outputTaskForSave(Task toSave) {
        int isDone = 0;
        if (toSave.getIsDone()) {
            isDone = 1;
        }
        if (toSave instanceof Deadline) {
            return "D | " + isDone + " | " + toSave.getDescription() + " | " + ((Deadline) toSave).getByForFile();
        } else if (toSave instanceof Event) {
            return "E | " + isDone + " | " + toSave.getDescription() + " | " + ((Event) toSave).getAtForFile();
        } else if (toSave instanceof Todo) {
            return "T | " + isDone + " | " + toSave.getDescription();
        } else {
            return "";
        }
    }

    public void toExit() {
        isExit = true;
    }

    public boolean getIsExit() {
        return isExit;
    }
}

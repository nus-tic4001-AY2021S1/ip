package duke.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import duke.commands.ListCommand;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.TaskList;
import duke.task.Todo;
import duke.ui.Ui;

/**
 * Responsible for all interactions between the in-memory tasks and the tasks file.
 */

public class Database {
    String fileName;

    public Database(String fileName, TaskList tasks, Ui ui) {
        this.fileName = fileName;
    }

    public void updateDatabase(TaskList tasks) throws IOException {
        FileWriter fw = new FileWriter("./" + fileName, false);
        for (int i = 0; i < tasks.size(); i++) {
            String line = (i + 1) + ". " + tasks.get(i).getDescription() + System.lineSeparator();
            fw.write(line);
        }
        fw.close();
    }

    public String readDatabase(TaskList tasks, Ui ui, Database database) {
        try {
            ArrayList<String> lines = getLines(fileName);
            tasks = extractTasks(lines, tasks, ui, database);
            return ui.printFileExists() + new ListCommand(tasks, ui).execute();

        } catch (FileNotFoundException e) {
            return ui.printNoFileFound();
        } catch (IOException e) {
            return ui.printRed("IOException encountered: " + e.getMessage());
        }
    }

    private ArrayList<String> getLines(String fileName) throws FileNotFoundException {
        Scanner s = new Scanner(new File(fileName));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        s.close();
        return list;
    }

    public TaskList extractTasks(ArrayList<String> lines, TaskList tasks, Ui ui, Database database) throws IOException {
        for (String line : lines) {
            FileWriter fw = new FileWriter(fileName, true);
            String taskStatus = line.split("]")[0].substring(line.indexOf("[") + 1);
            String taskType = line.split("]")[1].substring(line.indexOf("[") - 1);
            String taskDescription = line.split("]")[2].trim();

            switch (taskType) {
            case "Todo":
                tasks.add(new Todo("[Todo]     " + taskDescription));
                break;
            case "Deadline":
                tasks.add(new Deadline("[Deadline] " + taskDescription));
                break;
            case "Event":
                tasks.add(new Event("[Event]    " + taskDescription));
                break;
            default:
                ui.printInvalidTask();
                break;
            }
            if (taskStatus.equals("D")) {
                tasks.get(tasks.size() - 1).setDone();
            }
        }
        return tasks;
    }
}

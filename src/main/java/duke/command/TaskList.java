package duke.command;

import duke.Tasks.Deadline;
import duke.Tasks.Event;
import duke.Tasks.Task;
import duke.Tasks.Todo;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    static Ui ui = new Ui();
    private List<Task> tasks = new ArrayList<>(); //  Use Java Collections classes ArrayList<Task>


    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {

    }

    public void addTodo(String fullCommand) throws TaskException {
        Todo t = Parser.createTodo(fullCommand);
        tasks.add(t);
        ui.printLine();
        ui.showToUser("Got it. I've added this task: ");
        ui.showToUser("  " + tasks.get(tasks.size() - 1).toString());
        ui.showToUser("Now you have " + tasks.size() + " tasks in the list.");
        ui.printLine();
    }

    public void addDeadline(String fullCommand) throws TaskException {
        Deadline t = Parser.createDeadline(fullCommand);
        tasks.add(t);
        ui.printLine();
        ui.showToUser("Got it. I've added this task: ");
        ui.showToUser("  " + tasks.get(tasks.size() - 1).toString());
        ui.showToUser("Now you have " + tasks.size() + " tasks in the list.");
        ui.printLine();
    }

    public void addEvent(String toAdd) {
        String description = toAdd.split(" /at ")[0];
        String at = toAdd.split(" /at ")[1];
        tasks.add(new Event(description, at));
        ui.printLine();
        ui.showToUser("Got it. I've added this task: ");
        ui.showToUser("  " + tasks.get(tasks.size() - 1).toString());
        ui.showToUser("Now you have " + tasks.size() + " tasks in the list.");
        ui.printLine();
    }

    public void showTasks(String fullCommand) {
        ui.printLine();
        ui.showToUser("Here are the tasks in your list:");
        String description = fullCommand.trim().substring("list".length()).trim();
        if (description.isEmpty()) {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        } else try {
            int index = Integer.parseInt(description);
            if (index <= tasks.size() && index > 0) {
                ui.showToUser("[" + (index) + "] " + tasks.get(index - 1));
            } else System.out.println("☹ OOPS!!!Printing range should be 1 to " + tasks.size());
        } catch (NumberFormatException e) {
            ui.showToUser("☹ OOPS!!!Print command should be ‘print' or 'print INTEGER'");
        }
        ui.printLine();
    }

    public void markAsDone(String fullCommand) {
        try {
            int index = Integer.parseInt(fullCommand.substring("done".length()).trim());
            assert index <= tasks.size() : "☹ OOPS!!!Command number is invalid"; //assert error when index bigger than tasks size.
            if (index <= tasks.size() && index > 0) {
                tasks.get(index - 1).setDone(true);
                ui.showToUser("duke.Tasks: " + index + " has marked as DONE.");
                ui.printLine();
            } else ui.showToUser("☹ OOPS!!!Marking as done range should be 1 to " + tasks.size());
        } catch (NumberFormatException e) {
            ui.showToUser("☹ OOPS!!!markAsDone command not Integer!");
        }
    }

    public void deleteTasks(String fullCommand) {
        try {
            int index = Integer.parseInt(fullCommand.substring("delete".length()).trim());
            if (index <= tasks.size() && index > 0) {
                ui.showToUser("Noted. I've removed this task: \n" + "  " + tasks.get(index-1));
                tasks.remove(index - 1);
                ui.showToUser("Now you have " + tasks.size() + " tasks in the list.");
                ui.printLine();
            } else ui.showToUser("☹ OOPS!!!:Deleting range should be 1 to " + tasks.size());
        } catch (NumberFormatException e) {
            ui.showToUser("☹ OOPS!!!:Deleted command not Integer!");
        }
    }

    public void saveTasks() { Save.writeTaskToFile(tasks); }
}
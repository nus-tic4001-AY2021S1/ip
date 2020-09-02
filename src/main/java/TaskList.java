import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

import java.util.ArrayList;

public class TaskList {
    static Ui ui = new Ui();
    private final ArrayList<Task> tasks;
    private boolean isExit;


    public TaskList() {
        tasks = new ArrayList<>(100);
        isExit = false;
    }

    public void addTodo(String fullCommand) throws TaskManagerException {
        Todo t = Parser.createTodo(fullCommand);
        tasks.add(t);
        ui.printLine();
        ui.printWord("Got it. I've added this task: ");
        ui.printWord("  " + tasks.get(tasks.size() - 1).toString());
        ui.printWord("Now you have " + tasks.size() + " tasks in the list.");
        ui.printLine();
    }

    public void addDeadline(String fullCommand) throws TaskManagerException {
        Deadline t = Parser.createDeadline(fullCommand);
        tasks.add(t);
        ui.printLine();
        ui.printWord("Got it. I've added this task: ");
        ui.printWord("  " + tasks.get(tasks.size() - 1).toString());
        ui.printWord("Now you have " + tasks.size() + " tasks in the list.");
        ui.printLine();
    }

    public void addEvent(String toAdd) {
        String description = toAdd.split(" /at ")[0];
        String at = toAdd.split(" /at ")[1];
        tasks.add(new Event(description, at));
        ui.printLine();
        ui.printWord("Got it. I've added this task: ");
        ui.printWord("  " + tasks.get(tasks.size() - 1).toString());
        ui.printWord("Now you have " + tasks.size() + " tasks in the list.");
        ui.printLine();
    }

    public void showTasks(String fullCommand) {
        ui.printLine();
        ui.printWord("Here are the tasks in your list:");
        String description = fullCommand.trim().substring("list".length()).trim();
        if (description.isEmpty()) {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        } else try {
            int index = Integer.parseInt(description);
            if (index <= tasks.size() && index > 0) {
                System.out.println("[" + (index) + "] " + tasks.get(index - 1));
            } else System.out.println("☹ OOPS!!!Printing range should be 1 to " + tasks.size());
        } catch (NumberFormatException e) {
            System.out.println("☹ OOPS!!!Print command should be ‘print' or 'print INTEGER'");
        }
        ui.printLine();
    }

    public void markAsDone(String fullCommand) {
        try {
            int index = Integer.parseInt(fullCommand.substring("done".length()).trim());
            assert index <= tasks.size() : "☹ OOPS!!!Command number is invalid"; //assert error when index bigger than tasks size.
            if (index <= tasks.size() && index > 0) {
                tasks.get(index - 1).setDone(true);
                System.out.println("Tasks: " + index + " has marked as DONE.");
            } else System.out.println("☹ OOPS!!!Marking as done range should be 1 to " + tasks.size());
        } catch (NumberFormatException e) {
            System.out.println("☹ OOPS!!!markAsDone command not Integer!");
        }
    }


    public int getSize() {
        return tasks.size();
    }

    public Task getTask(int i) {
        return tasks.get(i);
    }

    public void toExit() {
        isExit = true;
    }

    public boolean getIsExit() {
        return isExit;
    }

}
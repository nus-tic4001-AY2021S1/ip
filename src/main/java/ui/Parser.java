package ui;

import duke.DukeException;
import duke.Task;
import duke.Global;
import duke.Action;

import java.util.ArrayList;

/**
 * This class is to understand User input and ensure all request are handled by different classes.
 *
 */
public class Parser {

    protected static String input;

    public Parser(String input) {
        this.input = input;
    }

    /**
     * This method is to take action from validateCommand and then process the action accordingly.
     */
    public static String processInput(String input, ArrayList<Task> tasks) {

        String command = input.toLowerCase();
        Action action;
        int count = tasks.size();

        try {
            action = validateCommand(command);
        } catch (Exception g) {
            return Ui.errInvalidInput(g);
            //return "Error";
        }

        try {
            switch (action) {
            case List:
                return Ui.printList(tasks);

            case Done:
                markDone(command, tasks);
                Storage.updateStatusToFile(tasks);
                int index = Integer.parseInt(input.substring(input.indexOf(" ") + 1));
                return Ui.replyMarkedDone(tasks, index);

            case AddTodo:
                if (!(TaskList.isDuplicates(tasks, input))) {
                    return TaskList.addTodo(tasks, input, count);
                } else {
                    return Ui.duplicatedMsg();
                }

            case AddDeadlines:
                if (!(TaskList.isDuplicates(tasks, input))) {
                    return TaskList.addDeadlines(tasks, input, count);
                } else {
                    return Ui.duplicatedMsg();
                }

            case AddEvents:
                if (!(TaskList.isDuplicates(tasks, input))) {
                    return TaskList.addEvents(tasks, input, count);
                } else {
                    return Ui.duplicatedMsg();
                }

            case AddRecurringTasks:
                if (!(TaskList.isDuplicates(tasks, input))) {
                    return TaskList.addRecurringTasks(tasks, input, count);
                } else {
                    return Ui.duplicatedMsg();
                }

            case Delete:
                TaskList.deleteTask(tasks, command);
                return Global.PATTERNLINE + "\nTask Deleted\n" + Global.PATTERNLINE;

            case Find:
                return Ui.findTask(command, tasks);

            case Bye:
                Storage.writeToFile(tasks);
                return Ui.greetNote("bye");

            default:
                return Global.PATTERNLINE + "\nYou have entered invalid input. Please re-input or \n"
                        + "Enter bye to terminate the program.\n" + Global.PATTERNLINE;

            }
        } catch (Exception m) {
            return m + Global.PATTERNLINE;
        }
    }

    /**
     * This method analysed and classified the user input to Process input accordingly.
     * Any unknown command will be throw.
     */
    private static Action validateCommand(String command) throws DukeException {
        if (command.startsWith("list")) {
            return  Action.List;
        } else if (command.startsWith("weekly") || command.startsWith("monthly")) {
            return Action.AddRecurringTasks;
        } else if (command.startsWith("find")) {
            return Action.Find;
        } else if (command.startsWith("delete")) {
            return Action.Delete;
        } else if (command.startsWith("bye")) {
            return Action.Bye;
        } else if (command.length() > 4 && command.startsWith("done")) {
            return Action.Done;
        } else if (command.length() > 3 && command.startsWith("todo")) {
            return Action.AddTodo;
        } else if (command.length() > 7 && command.startsWith("deadline")) {
            return Action.AddDeadlines;
        } else if (command.length() > 4 && command.startsWith("event")) {
            return Action.AddEvents;
        } else {
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n"
                    + "Please re-input or enter bye to terminate the program");
        }
    }

    private static void markDone(String command, ArrayList<Task> tasks) throws DukeException {
        int index;

        // If user input done1 instead of done 1
        if (command.contains(" ")) {
            index = Integer.parseInt(command.substring(5));
        } else {
            index = Integer.parseInt(command.substring(4));
        }

        try {
            tasks.get(index - 1).markAsDone();
            //Ui.replyMarkedDone(tasks, index);
        } catch (IndexOutOfBoundsException e) {
            String indexOutErrMsg = Global.PATTERNLINE + "\nFriend, You do not have so much task in the list\n";
            throw new DukeException(indexOutErrMsg);
        }

    }

}

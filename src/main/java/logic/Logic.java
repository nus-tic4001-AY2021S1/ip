package logic;

import data.TaskList;
import parser.Parser;
import ui.Constants;
import ui.Ui;

public class Logic {

    /**
     * Processes the user input and returns an appropriate response in String format.
     * @param fullCommand
     * @param commandWord
     * @param list
     * @return
     */
    public String processUserInput(String fullCommand, String commandWord, TaskList list) {
        String response = "";

        switch (commandWord.toUpperCase()) {
        case "":
            response = Ui.printError("No command input! Please enter a command "
                    + "or type \"help\" to view a list of commands.");
            break;

        case "EXIT":
            //Save tasklist in Duke.
            response = Constants.FAREWELL;
            System.exit(0);
            break;

        case "HELP":
            response = Constants.HELP_MESSAGE;
            break;

        case "TODO":
            list.addTask(Parser.createTodo(fullCommand));
            response = String.format(Ui.printTask(list.getTasks().get(TaskList.getNumberOfTasks() - 1),
                    Constants.TaskDisplayType.ADD) + "\n" + Ui.printNumberOfTasks(TaskList.getNumberOfTasks()));
            break;

        case "DEADLINE":
            list.addTask(Parser.createDeadLine(fullCommand));

            response = String.format(Ui.printTask(list.getTasks().get(TaskList.getNumberOfTasks() - 1),
                    Constants.TaskDisplayType.ADD) + "\n" + Ui.printNumberOfTasks(TaskList.getNumberOfTasks()));
            break;

        case "EVENT":
            list.addTask(Parser.createEvent(fullCommand));

            response = String.format(Ui.printTask(list.getTasks().get(TaskList.getNumberOfTasks() - 1),
                    Constants.TaskDisplayType.ADD) + "\n" + Ui.printNumberOfTasks(TaskList.getNumberOfTasks()));
            break;

        case "VIEW":
            if (TaskList.getNumberOfTasks() > 0) {
                response = Ui.printTasks(list.getTasks());
            } else {
                response = Constants.NO_TASKS + "\n";
            }
            break;

        case "FIND":
            if (list.findTasks(Parser.getKeyword(fullCommand)).size() > 0) {
                response = Constants.FOUND_MATCHING_TASKS
                        + "\n" + Ui.printTasks(list.findTasks(Parser.getKeyword(fullCommand)));
            } else {
                response = Constants.NO_MATCHING_TASKS + "\n";
            }
            break;

        case "DONE":
            try {
                list.markAsDone(Parser.parseTaskNum(fullCommand));
                response = Ui.printTask(list.getTasks().get(Parser.parseTaskNum(fullCommand) - 1),
                        Constants.TaskDisplayType.DONE);

            } catch (IndexOutOfBoundsException idxE) {
                response = Constants.INVALIDIDXINPUT + "\n";
            }
            break;

        case "UNDONE":
            try {
                list.markAsNotDone(Parser.parseTaskNum(fullCommand));
                response = Ui.printTask(list.getTasks().get(Parser.parseTaskNum(fullCommand) - 1),
                        Constants.TaskDisplayType.UNDONE);

            } catch (IndexOutOfBoundsException idxE) {
                response = Constants.INVALIDIDXINPUT;
            }
            break;

        case "REMOVE":
            try {
                list.removeTask(fullCommand);
                response = Ui.printNumberOfTasks(TaskList.getNumberOfTasks());

            } catch (IndexOutOfBoundsException idxE) {
                response = Constants.INVALIDIDXINPUT;
            }
            break;

        case "TAG":

            try {
                int index = fullCommand.indexOf("#");
                boolean moreThanOnce = index != -1 && index != fullCommand.lastIndexOf("#");

                if (!moreThanOnce) {

                    list.setTaskTag(Parser.parseTagTaskDescription(fullCommand), Parser.parseTagTaskNum(fullCommand));

                    response = Ui.printTask(list.getTasks().get(Parser.parseTagTaskNum(fullCommand) - 1),
                            Constants.TaskDisplayType.TAGGED);
                } else {

                    response = Constants.INVALID_TAG_COMMAND_FORMAT;
                }
            } catch (IndexOutOfBoundsException idxE) {
                response = Constants.INVALIDIDXINPUT + "\n";
            }
            break;

        case "UNTAG":
            try {
                list.removeTaskTag(Parser.parseTagTaskNum(fullCommand));

                response = Ui.printTask(list.getTasks().get(Parser.parseTagTaskNum(fullCommand) - 1),
                        Constants.TaskDisplayType.UNTAGGED);

            } catch (IndexOutOfBoundsException idxE) {

                response = Constants.INVALIDIDXINPUT + "\n";
            }
            break;

        case "SAVE":
            response = Ui.printNumberOfTasks(TaskList.getNumberOfTasks());
            break;

        default:
            response = Ui.printError("Unknown command! Please try again. Type \"help\" to view a list of commands.");
            break;
        }

        return response;
    }

}

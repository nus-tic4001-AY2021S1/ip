package duke;

import duke.commands.FindCommand;
import duke.commands.ListCommand;
import duke.exceptions.DukeException;
import duke.programexit.ProgramExit;

/** .
 * Parser: deals with making sense of the user command
 */
public class Parser {

    /**
     * A method to parser a String.
     * Assume that the Task Details start from the second words. This method can filter out the first words.
     *
     * @param line A String that holds the user input.
     * @throws DukeException If Task Detail is Empty/Null:
     *          Returning to Main MenuShow the message to user and notify the user.
     * */
    public static String filterTaskDetails(String line) throws DukeException {
        String taskDetail;
        int len = line.split(" ").length; // to check who many words
        String[] lineArr = line.split(" ", 2);
        String commandFirstWord = line.split(" ")[0].toLowerCase();

        if (len > 1) {
            taskDetail = lineArr[1].trim();  // filter out the first words
        } else {
            throw new DukeException("OOPS!!! The description of a " + commandFirstWord + " cannot be empty.");
        }
        return taskDetail;
    }

    /**
     * A method to parser a String and get the second word from the string.
     *
     * @param input A String that holds the user input.
     */

    public String getSecondWord(String input) {
        String commandSecondWord = input.split(" ")[1];
        return commandSecondWord;
    }


    /**
     * A method to parser a String and process necessary steps and tasks based on the user inputs.
     * Assume that the Task Details start from the second words. This method can filter out the first words.
     *  @param input       A String that holds the user input.
     * @param ui          A Ui that show message to user.
     * @param programExit A ProgramExit  to check if it is needed to exit the program.
     * @param taskList    A Task TodoList contains the ArrayList of Task objects,
     *                    contains the task list e.g., it has operations to add/delete tasks in the list
     */

    public void getCommand(String input, Ui ui, ProgramExit programExit, TaskList taskList) {

        String commandFirstWord = input.split(" ")[0].toLowerCase();
        //extract the first word of the user input, and lowercase it.

        try {
            switch (commandFirstWord) {
            case "bye":
                ui.sayBye();
                programExit.toExit();
                break;
            case "list":
                Ui.printLine();
                new ListCommand().executeCommand();
                Ui.printLine();
                break;
            case "done":
                Ui.printLine();
                taskList.markSelectedTaskDone(getSecondWord(input));
                Ui.printLine();
                break;
            case "delete":
                Ui.printLine();
                taskList.markSelectedTaskDelete(getSecondWord(input));
                Ui.printLine();
                break;
            case "todo":
                Ui.printLine();
                taskList.addToDoType(filterTaskDetails(input));
                taskList.readTaskFromUser(filterTaskDetails(input));
                Ui.printLine();
                break;
            case "deadline":
                Ui.printLine();
                taskList.addDeadlineType(filterTaskDetails(input));
                taskList.readTaskFromUser(filterTaskDetails(input));
                Ui.printLine();
                break;
            case "event":
                Ui.printLine();
                taskList.addEventType(filterTaskDetails(input));
                taskList.readTaskFromUser(filterTaskDetails(input));
                Ui.printLine();
                break;
            case "find":
                Ui.printLine();
                new FindCommand().executeCommand(filterTaskDetails(input));
                Ui.printLine();
                break;
            case "clear":
                Ui.printLine();
                TaskList.clearAllTasks();
                Ui.printLine();
                break;
            case "view":
                Ui.printLine();
                taskList.viewSelectedTask(getSecondWord(input));
                Ui.printLine();
                break;
            default:
                Ui.printLine();
                Ui.showMessage("OOPS!!! I'm sorry, but I don't know what that means :-(");
                Ui.printLine();
            }

        } catch (Exception e) {
            Ui.showMessage(e.getMessage());
        }


    }


}

















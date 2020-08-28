import Tasks.Deadline;
import Tasks.Todo;

public class Parser {

    static Ui ui = new Ui();
    static TaskList tasks = new TaskList();


    private static String commandWord;

    public Parser(String commandWord) {
        Parser.commandWord = commandWord;
    }

    public static String getCommand(String fullCommand) {
        commandWord = fullCommand.trim().split(" ")[0];
        return commandWord;
    }

    public static Todo createTodo(String line) throws TaskManagerException {
        String substring = line.trim().substring("todo".length());
        String description = substring.trim();
        if (description.isEmpty()) {
            throw new TaskManagerException("Error: Empty description for TODO");
        }
        return new Todo(substring.trim());
    }

    public static Deadline createDeadline(String line) throws TaskManagerException {
        String description = line.substring("deadline".trim().length());

        if (description.isEmpty()) {
            throw new TaskManagerException("Error: Empty description for DEADLINE");
        }
        if (!description.contains("/by")) {
            throw new TaskManagerException("Error: need '/by' for DEADLINE");
        }
        return new Deadline(line.trim().substring("deadline".length()).trim().split(" /by")[0],
                line.trim().split("/by ")[1]);  //[bB][yY] ignore /by or /BY
    }

    public static void run() throws TaskManagerException {
        ui.printLogo();
        ui.greetUser();
        boolean isExit = false;
        while (!isExit) {
                String fullCommand = ui.readCommand();
                String commandWord = Parser.getCommand(fullCommand);//convert command word to lowercase
                switch (commandWord) {
                    case "bye":
                        ui.farewellUser();
                    case "":
                        isExit = true;
                        break;
                    case "todo":
                        tasks.addTodo(fullCommand);
                        break;
                    case "deadline":
                        tasks.addDeadline(fullCommand);
                        break;
                    case "done":
                        tasks.markAsDone(fullCommand);
                        break;
                    case "list":
                        tasks.showTasks(fullCommand);
                        break;
                    case "event":
                        tasks.addEvent(fullCommand);
                        break;
                    default:
                        ui.printError();
                }
        }
    }
}



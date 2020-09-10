package Duke;

import ui.Parser;
import ui.Ui;

public class Duke {

    private TaskList tasks;
    private Ui ui;

    public Duke() {
        ui = new Ui();
        tasks = new TaskList();
    }


    public void run() {
        ui.printWelcome();

        boolean isExit = false;
        while (!isExit) {

            try {

                String fullCommand = ui.readUserCommand();
                String commandWord = Parser.getCommandWord(fullCommand);

                switch (commandWord) {
                    case "":
                        ui.printError("No command input! Please enter a command or type \"help\" to view a list of commands.");
                        break;

                    case "exit":
                        isExit = true;
//                        if (tasks.getNumberOfTasks() > 0) {
//
//                        } else {
//                        }
                        ui.endInputFeed();
                        ui.printGoodBye();
                        break;

                    case "help":
                        ui.helpMessage();
                        break;

                    case "todo":
                        tasks.addTask(Parser.createTodo(fullCommand));
                        ui.printTaskAddAck(tasks.getTasks().get(TaskList.getNumberOfTasks() - 1), TaskList.getNumberOfTasks());
                        break;

                    case "deadline":
                        tasks.addTask(Parser.createDeadLine(fullCommand));
                        ui.printTaskAddAck(tasks.getTasks().get(TaskList.getNumberOfTasks() - 1), TaskList.getNumberOfTasks());
                        break;

                    case "event":
                        tasks.addTask(Parser.createEvent(fullCommand));
                        ui.printTaskAddAck(tasks.getTasks().get(TaskList.getNumberOfTasks() - 1), TaskList.getNumberOfTasks());
                        break;

                    case "print":
                        ui.printTasks(tasks.getTasks());
                        break;

                    case "done":
                        tasks.markAsDone(Parser.parseTaskNum(fullCommand));
                        ui.printTaskMarkedAsDone(tasks.getTasks().get(Parser.parseTaskNum(fullCommand) - 1));
                        break;

//                    case "save":
////                        storage.save(tasks.getTasks());
//                        break;

                    case "remove":
                        tasks.removeTask(fullCommand);
                        ui.printNumberOfTasks(TaskList.getNumberOfTasks());
                        break;

                    default:
                        ui.printError("Unknown command! please try again. Please type \"help\" to view a list of commands.");
                        break;
                }
            } catch (Exception e) {
                ui.printError(e.getMessage());
            }
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        new Duke().run();
    }

}
    
package duke;


import data.TaskList;
//import exception.DukeException;

import storage.Storage;
//import ui.Constants;
//import ui.Ui;

public class Duke {
    private Storage storage;
    private TaskList tasks;
//    private Ui ui;

    /**
     * Duke Main.
     * @param filePath
     */
//    public Duke(String filePath) {
//        ui = new Ui();
//        storage = new Storage(filePath);
//        try {
//            tasks = new TaskList(storage.load());
//        } catch (NoSuchFileException | FileNotFoundException | DukeException e) {
//
//            if (e.toString().contains("FileNotFoundException") || e.toString().contains("NoSuchFileException")) {
//
//            } else if (e.toString().contains("DukeException")) {
//                ui.showToUser(Constants.FILE_NOT_READABLE_EXCEPTION);
//            }
//            tasks = new TaskList(new ArrayList<>());
//        }
//
//    }

    /**
     * Begin running main processing loop
     */
//    public void run() {
//        ui.printWelcome();
//
//        boolean isExit = false;
//        while (!isExit) {
//
//            try {
//                String fullCommand = ui.readUserCommand();
//                String commandWord = Parser.getCommandWord(fullCommand);
//
//                switch (commandWord.toUpperCase()) {
//                case "":
//                    ui.printError("No command input! Please enter a command "
//                            + "or type \"help\" to view a list of commands.");
//                    break;
//
//                case "EXIT":
//                    isExit = true;
//                    if (tasks.getNumberOfTasks() > 0) {
//                        storage.save(tasks.getTasks());
//                    }
//                    ui.endInputFeed();
//                    ui.printGoodBye();
//                    break;
//
//                case "HELP":
//                    ui.helpMessage();
//                    Ui.showToUser(Constants.H_LINE);
//                    break;
//
//                case "TODO":
//                    tasks.addTask(Parser.createTodo(fullCommand));
//                    ui.printTask(tasks.getTasks().get(TaskList.getNumberOfTasks() - 1), Constants.TaskDisplayType.ADD);
//                    Ui.printNumberOfTasks(TaskList.getNumberOfTasks());
//                    Ui.showToUser(Constants.H_LINE);
//                    storage.save(tasks.getTasks());
//                    break;
//
//                case "DEADLINE":
//                    tasks.addTask(Parser.createDeadLine(fullCommand));
//                    ui.printTask(tasks.getTasks().get(TaskList.getNumberOfTasks() - 1), Constants.TaskDisplayType.ADD);
//                    Ui.printNumberOfTasks(TaskList.getNumberOfTasks());
//                    Ui.showToUser(Constants.H_LINE);
//                    storage.save(tasks.getTasks());
//                    break;
//
//                case "EVENT":
//                    tasks.addTask(Parser.createEvent(fullCommand));
//                    ui.printTask(tasks.getTasks().get(TaskList.getNumberOfTasks() - 1), Constants.TaskDisplayType.ADD);
//                    Ui.printNumberOfTasks(TaskList.getNumberOfTasks());
//                    Ui.showToUser(Constants.H_LINE);
//                    storage.save(tasks.getTasks());
//                    break;
//
//                case "VIEW":
//                    if (TaskList.getNumberOfTasks() > 0) {
//
//                        ui.printTasks(tasks.getTasks());
//                    } else {
//                        Ui.showToUser(Constants.NO_TASKS + "\n" + Constants.H_LINE);
//                    }
//
//                    break;
//
//                case "FIND":
//                    if (tasks.findTasks(Parser.getKeyword(fullCommand)).size() > 0) {
//                        ui.printFoundTasks(tasks.findTasks(Parser.getKeyword(fullCommand)));
//                    } else {
//                        Ui.showToUser(Constants.NO_MATCHING_TASKS);
//                    }
//                    break;
//
//                case "DONE":
//                    try {
//                        tasks.markAsDone(Parser.parseTaskNum(fullCommand));
//                        ui.printTask(tasks.getTasks().get(Parser.parseTaskNum(fullCommand) - 1),
//                                Constants.TaskDisplayType.DONE);
//                        Ui.showToUser(Constants.H_LINE);
//                        storage.save(tasks.getTasks());
//                    } catch (IndexOutOfBoundsException idxE) {
//                        Ui.showToUser(Constants.INVALIDIDXINPUT + "\n" + Constants.H_LINE);
//                    }
//                    break;
//
//                case "UNDONE":
//                    try {
//                        tasks.markAsNotDone(Parser.parseTaskNum(fullCommand));
//                        ui.printTask(tasks.getTasks().get(Parser.parseTaskNum(fullCommand) - 1),
//                                Constants.TaskDisplayType.UNDONE);
//                        Ui.showToUser(Constants.H_LINE);
//                        storage.save(tasks.getTasks());
//                    } catch (IndexOutOfBoundsException idxE) {
//                        Ui.showToUser(Constants.INVALIDIDXINPUT + "\n" + Constants.H_LINE);
//                    }
//                    break;
//
//                case "REMOVE":
//                    try {
//                        tasks.removeTask(fullCommand);
//                        Ui.printNumberOfTasks(TaskList.getNumberOfTasks());
//                        Ui.showToUser(Constants.H_LINE);
//                        storage.save(tasks.getTasks());
//                    } catch (IndexOutOfBoundsException idxE) {
//                        Ui.showToUser(Constants.INVALIDIDXINPUT + "\n" + Constants.H_LINE);
//                    }
//                    break;
//
//                case "SAVE":
//                    Ui.printNumberOfTasks(TaskList.getNumberOfTasks());
//                    storage.save(tasks.getTasks());
//                    Ui.showToUser(Constants.SAVE_TASKS_ACKNOWLEGEMENT);
//                    break;
//
//                default:
//                    ui.printError("Unknown command! Please try again. Type \"help\" to view a list of commands.");
//                    break;
//                }
//            } catch (Exception e) {
//                ui.printError(e.getMessage());
//            }
//        }
//        System.exit(0);
//    }
//
//    public static void main(String[] args) {
//        new Duke("data/tasks.txt").run();
//    }

}

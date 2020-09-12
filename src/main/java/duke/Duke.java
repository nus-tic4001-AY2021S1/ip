package duke;

/**
 * The <code>Duke</code> class implements an application that allows users to manage tasks.
 * It contains methods that allow the creation, modification and storage of tasks.
 */
public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadTasks(filePath));
        } catch (DukeException e) {
            ui.printError(e.getMessage());
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.printWelcome();

        boolean isBye = false;
        while (!isBye) {
            String fullCommand = ui.readUserInput();
            String command = Parser.getCommand(fullCommand);

            ui.printLine();

            try {
                switch(command) {
                case "bye":
                    isBye = true;
                    break;
                case "todo":
                    addTodo(fullCommand);
                    break;
                case "deadline":
                    addDeadline(fullCommand);
                    break;
                case "event":
                    addEvent(fullCommand);
                    break;
                case "done":
                    markTaskAsDone(fullCommand);
                    break;
                case "delete":
                    deleteTask(fullCommand);
                    break;
                case "list":
                    listTasks();
                    break;
                default:
                    ui.printError("I'm sorry, I don't know what that means.");
                }
            } catch (DukeException e) {
                ui.printError(e.getMessage());
            }
        }

        ui.printGoodbye();
    }

    private void addTodo(String fullCommand) throws DukeException {
        tasks.addTask(Parser.createTodo(fullCommand));

        storage.saveTasks(tasks);

        ui.printAddedTask(tasks);
    }

    private void addDeadline(String fullCommand) throws DukeException {
        tasks.addTask(Parser.createDeadline(fullCommand));

        storage.saveTasks(tasks);

        ui.printAddedTask(tasks);
    }

    private void addEvent(String fullCommand) throws DukeException {
        tasks.addTask(Parser.createEvent(fullCommand));

        storage.saveTasks(tasks);

        ui.printAddedTask(tasks);
    }

    private void listTasks() {
        System.out.println("Duke: Here are the tasks in your list:");
        for (int i = 0; i < tasks.getSize(); i++) {
            ui.printIndentation();
            System.out.println((i + 1) + ". " + tasks.getTask(i).toString());
        }
        ui.printLine();
    }

    private void markTaskAsDone(String fullCommand) throws DukeException {
        int taskIndex = Parser.getTaskIndex(fullCommand);
        try {
            tasks.getTask(taskIndex).setDone(true);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("The task index is invalid.");
        }

        storage.saveTasks(tasks);

        ui.printDoneTask(tasks.getTask(taskIndex));
    }

    private void deleteTask(String fullCommand) throws DukeException {
        int taskIndex = Parser.getTaskIndex(fullCommand);
        String taskDescription;
        try {
            taskDescription =  tasks.getTask(taskIndex).toString();
            tasks.removeTask(taskIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("The task index is invalid.");
        }

        storage.saveTasks(tasks);

        ui.printRemovedTask(tasks.getSize(), taskDescription);
    }

    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
}
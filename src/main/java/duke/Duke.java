package duke;

import duke.commands.Command;
import duke.commands.ExitCommand;
import duke.ui.Ui;
import duke.parser.Parser;
import duke.task.TaskList;
import duke.database.Database;
import java.util.Scanner;
/**
 * A Personal Assistant Chatbot that helps a person to keep track of various things.
 *
 * @author Wang Zhenquan
 * @version A-MoreOOP
 * @since 20/08/2020
 */
class Duke {
    private final Ui ui = new Ui();
    private final Parser parser = new Parser();
    private final Scanner in = new Scanner(System.in);
    private final TaskList tasks = new TaskList();
    private final Database database = new Database("duke.txt", tasks, ui);

    public static void main(String[] args) {
        new Duke().run();
    }

    private void run() {
        System.setProperty("file.encoding", "utf-8");
        ui.printDukeLogo();
        ui.printGreeting();
        database.readDatabase(tasks, ui, database);
        repeatedUserInput();
    }

    private void repeatedUserInput() {
        while (true) {
            Command command = parser.parseInput(in.nextLine(), ui, tasks, database);
            command.execute();
            if (ExitCommand.class.isAssignableFrom(command.getClass())) return;
        }
    }
}
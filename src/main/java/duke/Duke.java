package duke;

import java.util.Scanner;
import duke.commands.Command;
import duke.database.Database;
import duke.parser.Parser;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * A Personal Assistant Chatbot that helps a person to keep track of various things.
 *
 * @author Wang Zhenquan
 * @version Level-10
 * @since 20/08/2020
 */

public class Duke {
    private final Ui ui = new Ui();
    private final Parser parser = new Parser();
    private final Scanner in = new Scanner(System.in);
    private final TaskList tasks = new TaskList();
    private final Database database = new Database("duke.txt", tasks, ui);

    String getGreetingsAndTasks() {
        System.setProperty("file.encoding", "utf-8");
        return ui.printDukeLogo()
            + ui.printGreeting()
            + database.readDatabase(tasks, ui, database);
    }

    String getResponse(String input) {
        Command command = parser.parseInput(input, ui, tasks, database);
        return command.execute();
    }

}
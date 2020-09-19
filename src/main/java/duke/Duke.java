package duke;

import duke.ui.Ui;
import duke.parser.Parser;
import duke.task.TaskList;
import duke.database.Database;

import java.util.Scanner;

/**
 * A Personal Assistant Chatbot that helps a person to keep track of various things.
 *
 * @author Wang Zhenquan
 * @version Level 7
 * @since 20/08/2020
 */

class Duke {
    private final Ui ui = new Ui();
    private final Parser parser = new Parser();
    private final Scanner in = new Scanner(System.in);
    private final TaskList tasks = new TaskList();
    private final Database database = new Database("duke.txt", tasks, ui);
    private boolean isRepeating = true;

    public static void main(String[] args) {
        new Duke().run();
    }

    private void run() {
        ui.printDukeLogo();
        ui.printGreeting();
        database.readDatabase(tasks, ui, database);
        repeatedUserInput();
    }

    private void repeatedUserInput() {
        while (isRepeating) {
            isRepeating = parser.parseInput(in.nextLine(), ui, tasks, database);
        }
    }
}

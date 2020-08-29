import java.util.Scanner;

/**
 * A Personal Assistant Chatbot that helps a person to keep track of various things.
 *
 * @author Wang Zhenquan
 * @version Level 3
 * @since 20/08/2020
 */

class Duke {
    private UI ui = new UI();
    private Parser parser = new Parser();
    private Scanner in = new Scanner(System.in);
    private boolean repeat = true;

    private void run() {
        TaskList tasks = new TaskList();
        ui.greet();
        while (repeat) {
            repeat = parser.parseInput(in.nextLine(), ui, tasks);
        }
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        new Duke().run();
    }
}

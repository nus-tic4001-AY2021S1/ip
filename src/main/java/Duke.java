import java.util.Scanner;

class Duke {
    private UI ui = new UI();
    private Parser parser = new Parser();
    private Scanner in = new Scanner(System.in);
    private boolean repeat = true;

    private void run() {
        ui.greet();
        while (repeat) {
            repeat = parser.parseInput(in.nextLine(), ui);
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

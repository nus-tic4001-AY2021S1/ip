public class Duke {
    public static final String LINE = "____________________________________________________________";
    public static void main(String[] args) {
        printWelcome();
        printGoodbye();
    }

    public static void printWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println(LINE);
        System.out.println(logo);
        System.out.println("Duke: Hello! I'm Duke, your personal chatbot.");
        System.out.println("Duke: What can I do for you?");
        System.out.println(LINE);
    }

    public static void printGoodbye() {
        System.out.println("Duke: Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }
}
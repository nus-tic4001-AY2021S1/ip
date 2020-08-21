import java.util.Scanner;

public class Duke {
    public static final String LINE = "____________________________________________________________";
    public static void main(String[] args) {
        printWelcome();

        boolean isExit = false;
        while (!isExit) {
            String fullCommand = readUserCommand();
            System.out.println(LINE);
            System.out.println("Duke: Your input is \"" + fullCommand + "\".");
            System.out.println(LINE);
            switch(fullCommand) {
            case "bye":
                isExit = true;
                break;
            default:
                //Do nothing
            }
        }
        
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

    public static String readUserCommand() {
        Scanner in = new Scanner(System.in);
        System.out.print("You: ");
        return in.nextLine().trim();
    }

    public static void printGoodbye() {
        System.out.println("Duke: Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }
}
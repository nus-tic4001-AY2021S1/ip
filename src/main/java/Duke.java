import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printWelcome();
        //Declare the object and initialize with
        //predefined standard input object
        Scanner in = new Scanner(System.in);

        //String input
        String input = in. nextLine();

        while(!input.equals("bye")){
            System.out.println("     " + input);
            input =in.nextLine();
        }

        showExit();
    }
    public static void printWelcome() {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?\n");
    }
    public static void showExit() {
        System.out.println("   Bye. Hope to see you again soon!");
    }

}

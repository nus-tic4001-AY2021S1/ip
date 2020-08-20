import java.util.Scanner;
import java.util.ArrayList;

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
        String input = in.nextLine();
        ArrayList<String> tasks = new ArrayList<>();

        while (!input.equals("bye")) {
            if (!input.equals("list")) {
                tasks.add(input);
                System.out.println("    added: " + input);
            } else{
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println("    " + (i + 1)+ ". "+ tasks.get(i));
                }
                if(tasks.size() == 0){
                    System.out.println("   Your list is empty");
                }
            }
            in = new Scanner(System.in);
            input = in.nextLine();

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



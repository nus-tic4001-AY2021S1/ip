import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Duke {

    public static List<TaskDTO> taskList = new ArrayList<>();
    public static int taskId = 0;
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");
        Scanner scanner = new Scanner(System.in);

        processCommand(scanner);

    }

    public static void processCommand (Scanner scanner){
        String command = scanner.nextLine();
        System.out.println("____________________________________________________________");
        if (command.equalsIgnoreCase("bye")){

            System.out.println("Bye. Hope to see you again soon!");

        }else {

            System.out.println(command);
        }
        System.out.println("____________________________________________________________\n");
        processCommand(scanner);
    }


}

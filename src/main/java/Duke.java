import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        String hLine = "____________________________________________________________";

        String greeting = "Hello I'm Duke\nWhat can I do for you ?\n";

        String farewell = "\nBye. Hope to see you again soon!\n";
        String line;


        Scanner in = new Scanner(System.in);

        System.out.println(hLine + "\n" + greeting + hLine);

        line = in.nextLine();

        while (!(line.contentEquals("bye") || line.contentEquals("bye"))) {

            System.out.println(hLine + "\n" + line + "\n" + hLine);

            line = in.nextLine();
        }
        
        System.out.println(hLine + farewell + hLine);

    }
}
    
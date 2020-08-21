import Task.Task;

import java.util.ArrayList;
import java.util.List;
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

        List<Task> tasks = new ArrayList<>();


        Scanner in = new Scanner(System.in);

        System.out.println(hLine + "\n" + greeting + hLine);

        line = in.nextLine();

        while (!(line.contentEquals("bye") || line.contentEquals("Bye"))) {

            if ((line.equals("list") || line.equals("List")) ) {
                if(!tasks.isEmpty()){
                    int counter = 1;
                    for (Task t : tasks) {

                        System.out.println(counter + "." + t.getDescription());
                        counter++;
                    }
                }else{
                    System.out.println("The List is empty, please add some Tasks/Todos");
                }
            } else {
                if (!line.isBlank()) {
                    System.out.println(hLine + "\n" + "Added: " + line + "\n" + hLine);
                    tasks.add(new Task(line));
                }
            }
            line = in.nextLine();
        }

        System.out.println(hLine + farewell + hLine);

    }
}
    
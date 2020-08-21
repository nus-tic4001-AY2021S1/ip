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

            if ((line.equals("list") || line.equals("List"))) {
                if (!tasks.isEmpty()) {
                    int counter = 1;
                    for (Task t : tasks) {

                        System.out.print(counter + ".");
                        if (t.isDone()) {
                            System.out.print("[\u2713]");
                        } else {
                            System.out.print("[\u2717]");
                        }
                        System.out.print(" " + t.getDescription() + "\n");
                        counter++;
                    }
                } else {
                    System.out.println("The List is empty, please add some Tasks/Todos");
                }
            } else if ((line.contains("done") || line.contains("Done"))) {

                String taskNum[] = line.split(" ");
                tasks.get(Integer.parseInt(taskNum[1]) - 1).setDone(true);

                System.out.println(hLine);

                System.out.println("Nice! I've marked this task as done:");
                System.out.print("[\u2713]");
                System.out.print(" " + tasks.get(Integer.parseInt(taskNum[1]) - 1).getDescription()+"\n");

                System.out.println(hLine);

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
    
import Tasks.Deadlines;
import Tasks.Events;
import Tasks.Task;
import Tasks.ToDos;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String hello = " Hello! I'm Duke\n" +
                " What can I do for you?";

        String bye = " Bye. Hope to see you again soon!";
        System.out.println("________________________________________________________");
        System.out.println(hello);
        System.out.println("________________________________________________________");

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            String[] cmd = input.split("\\s+");

            if (cmd[0].equalsIgnoreCase("bye")) {
                break;
            }

            try {
                switch (cmd[0]) {
                    case "list":
                        System.out.println("Here are the tasks in your list:");
                        int i = 1;
                        for (Task s : tasks) {
                            System.out.println(i + "." + s.toString());
                            i++;
                        }
                        break;
                    case "done":
                        int index = Integer.parseInt(input.split(" ")[1]);
                        tasks.get(index - 1).setDone(true);
                        System.out.println("Nice! I've marked this task as done: ");
                        System.out.println(tasks.get(index - 1).toString());
                        break;
                    case "todo":
                        ToDos t = new ToDos(input.substring(5, input.length()));
                        tasks.add(t);
                        printTask(t, tasks);
                        break;
                    case "deadline":
                        String[] deadlineContent = input.split(" /by ");
                        Deadlines d = new Deadlines(deadlineContent[0].substring(9, deadlineContent[0].length()), deadlineContent[1]);
                        tasks.add(d);
                        printTask(d, tasks);
                        break;
                    case "event":
                        String[] eventContent = input.split(" /at ");
                        Events e = new Events(eventContent[0].substring(6, eventContent[0].length()), eventContent[1]);
                        tasks.add(e);
                        printTask(e, tasks);
                        break;
                    default:
                        System.out.println("Command is unknown,please re-try.");
                }
            } catch (Exception e) {
                System.out.println("Internal error occurs,please re-enter the command.");
                continue;
            }
            System.out.println("________________________________________________________");
        }
        System.out.println(bye);
        System.out.println("________________________________________________________");

    }

    private static void printTask(Task t, ArrayList<Task> tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println(t.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}

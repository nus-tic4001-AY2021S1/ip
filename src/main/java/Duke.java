import Duke.Exceptions.DukeException;
import Duke.Tasks.Deadlines;
import Duke.Tasks.Events;
import Duke.Tasks.Task;
import Duke.Tasks.ToDos;

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
            String userInput = scanner.nextLine();
            String[] cmd = userInput.split("\\s+");

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
                        try {
                            int index = Integer.parseInt(userInput.split(" ")[1]);
                            tasks.get(index - 1).setDone(true);
                            System.out.println("Nice! I've marked this task as done: ");
                            System.out.println(tasks.get(index - 1).toString());
                        }catch(IndexOutOfBoundsException e){
                            throw new DukeException("☹ OOPS!!! The task does not exist.");
                        }catch (NumberFormatException e) {
                            throw new DukeException("☹ OOPS!!! Please specify the task need to be done.");
                        }
                        break;
                    case "todo":
                        try {
                            ToDos t = new ToDos(userInput.substring(5, userInput.length()));
                            tasks.add(t);
                            printTask(t, tasks);
                        }catch(StringIndexOutOfBoundsException e){
                            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                        }
                        break;
                    case "deadline":
                        try {
                            String[] deadlineContent = userInput.split(" /by ");
                            Deadlines d = new Deadlines(deadlineContent[0].substring(9, deadlineContent[0].length()), deadlineContent[1]);
                            tasks.add(d);
                            printTask(d, tasks);
                        }catch(StringIndexOutOfBoundsException e){
                            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                        }catch(ArrayIndexOutOfBoundsException e){
                            throw new DukeException("☹ OOPS!!! The keyword /by is missing.");
                        }
                        break;
                    case "event":
                        try {
                            String[] eventContent = userInput.split(" /at ");
                            Events e = new Events(eventContent[0].substring(6, eventContent[0].length()), eventContent[1]);
                            tasks.add(e);
                            printTask(e, tasks);
                        }catch(StringIndexOutOfBoundsException e){
                            throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
                        }catch(ArrayIndexOutOfBoundsException e){
                            throw new DukeException("☹ OOPS!!! The keyword /at is missing.");
                        }
                        break;
                    default:
                        throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }catch (DukeException e) {
                System.out.println(e.getMessage());
                continue;
            }catch (Exception e) {
                System.out.println("☹ OOPS!!! Unknown internal error occurs.");
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

import java.util.ArrayList;
import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
        String logo = "  __          __ \n"
                + "  | | ____    | | ____\n"
                + "  | |/ __ \\   | |/ __ \\\n"
                + "__/ | |__| |__/ | |__| |\n"
                + "\\__/ \\____/ \\__/ \\____/\n";
        System.out.println("Hello from\n" + logo);

        String LINE = "____________________________________________________________";

        System.out.println(LINE
                + "\nHi! I'm Jojo, your personal assistant:)\n"
                + "What can I do for you?\n"
                + LINE);

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();

            try {
                if (input.equalsIgnoreCase("bye")) {
                    System.out.println("Bye, have a nice day!\n" + LINE);
                    break;
                } else if (input.trim().split(" ")[0].equalsIgnoreCase("list")) {
                    System.out.println("  Here are the tasks in your list:");
                    int i = 1;
                    for (Task task : tasks) {
                        System.out.println("  " + i + ".[" + task.getStatusIcon() + "] " + task.getDescription());
                        i++;
                    }
                    System.out.println(LINE);
                } else if (input.trim().split(" ")[0].equalsIgnoreCase("done")) {
                    int index = Integer.parseInt(input.split(" ")[1]);
                    tasks.get(index - 1).setDone(true);
                    System.out.println("  Nice! I've marked this task as done: ");
                    System.out.println("    [" + tasks.get(index - 1).getStatusIcon() + "] " + tasks.get(index - 1).getDescription()+"\n"+ LINE);
                } else {
                    tasks.add(new Task(input));
                    System.out.println("  added: " + input + "\n" + LINE);
                }

            } catch (Exception e) {
                System.out.println("Sorry,i cannot understand it. Please re-enter your command.\n"+LINE);
            }
        }
    }
}

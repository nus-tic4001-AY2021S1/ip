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
        System.out.println("____________________________________________________________\n"
                + "Hi! I'm Jojo, your personal assistant:)\n"
                + "What can I do for you?\n"
                + "____________________________________________________________");

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();

        while(true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                for (String line : lines) {
                    System.out.println("  " + line);
                }
                System.out.println("____________________________________________________________");
            } else {
                lines.add(lines.size() + 1 + ". " + input);
                System.out.println("  added: " + input
                        + "\n____________________________________________________________");
            }
        }

        System.out.println("Bye, have a nice day!\n"
                + "____________________________________________________________");
    }
}

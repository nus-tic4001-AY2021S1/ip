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
                + "Hi! I'm Jojo\n"
                + "What can I do for you?\n"
                + "____________________________________________________________");

        Scanner scanner = new Scanner(System.in);

        while(true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("bye")) {
                break;
            } else {
                System.out.println(input);
            }
        }

        System.out.println("Bye, have a nice day!\n"
                + "____________________________________________________________");
    }
}

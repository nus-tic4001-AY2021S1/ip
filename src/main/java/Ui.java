import java.util.Scanner;

public class Ui {
    public static String readUserCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine().trim();
    }

    public static void printLine() {
        System.out.println("_________________________________________");

    }

    public static void sayWelcome() {
        printLine();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        printLine();
    }


    public void sayBye() {
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }


    public static void showMessage(String message) {
        System.out.println(message);
    }


}

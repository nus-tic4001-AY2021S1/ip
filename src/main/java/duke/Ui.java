package duke;

import java.util.Scanner;
/**
 * Ui class handles all the print out to users, and read input from users.
 */

public class Ui {
    protected Scanner in = new Scanner(System.in);

    public String indentPrint(String toPrint) {
        return " " + toPrint + "" + "\n";
    }

    public String greetUser() {
        return indentPrint("Hello! I'm Duke") +
            indentPrint("What can I do for you?");
    }

    public String byeToUser() {
        return indentPrint("Bye. Hope to see you again soon!");
    }

    public String readCommand() {
        return in.nextLine();
    }
}

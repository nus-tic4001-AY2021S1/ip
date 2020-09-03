package Dukes;

import java.util.Scanner;

public class Ui {
    public Scanner in = new Scanner(System.in);

    public Ui() {
    }

    public String getInput() {
        return in.nextLine();
    }


    public static void printWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\nWhat can I do for you?\n");
    }

    public static void showExit() {
        System.out.println("   Bye. Hope to see you again soon!");
    }
}

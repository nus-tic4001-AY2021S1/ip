package duke;

import java.util.Scanner;
/**
 * Ui class handles all the print out to users, and read input from users.
 */
public class Ui {
    protected Scanner in = new Scanner(System.in);
    public void printLine(){
        System.out.println("____________________________________________________________");
    }
    public void indentPrint(String toPrint){
        System.out.println(" "+toPrint);
    }
    public void greetUser(){
        printLine();
        indentPrint("Hello! I'm Duke");
        indentPrint("What can I do for you?");
        printLine();
    }
    public void byeToUser(){
        indentPrint("Bye. Hope to see you again soon!");
    }
    public String readCommand(){
        return in.nextLine();
    }
}

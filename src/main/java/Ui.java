import java.util.Scanner;

public class Ui {
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
    public String taskToString(Task toPrint){
        return "["+toPrint.getStatusIcon()+"]"+" "+toPrint.getDescription();
    }
    public void byeToUser(){
        printLine();
        indentPrint("Bye. Hope to see you again soon!");
        printLine();
    }
    public String readCommand(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}

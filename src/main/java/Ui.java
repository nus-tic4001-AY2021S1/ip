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
    public void byeToUser(){
        indentPrint("Bye. Hope to see you again soon!");
        printLine();
    }
}

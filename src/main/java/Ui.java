import java.util.Scanner;

//deals with interactions with the user
class Ui {
    private Scanner sc = new Scanner(System.in);
    private boolean isExit;

    public Ui(){
        this.isExit = false;
    }
    public void indent(){
        System.out.print("\t");
    }
    public void printLine(){
        indent();
        System.out.println("____________________________________________________________");
    }
    public void printLogo(){
        String logo = "\t ____        _        \n"
                + "\t|  _ \\ _   _| | _____ \n"
                + "\t| | | | | | | |/ / _ \\\n"
                + "\t| |_| | |_| |   <  __/\n"
                + "\t|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
    }
    public void printGreetings(){
        printLine();
        printLogo();
        indent(); System.out.println("Hello! I'm Duke");
        indent(); System.out.println("What can I do for you?");
        printLine();
    }
    public void printClosing(){
        indent(); System.out.println("Bye. Hope to see you again soon!");
    }
    public void printNoRecords(){
        indent(); System.out.println("No record added");
    }
    public void printList(){
        indent(); System.out.println("Here are the tasks in your list:");
    }
    public void indentPrintString(String toPrint){
        indent(); indent(); System.out.println(toPrint);
    }
    public void printDoneMsg(){
        indent(); System.out.println("Nice! I've marked this task as done:");
    }
    public void printDeleteMsg(){
        indent(); System.out.println("Noted. I've removed this task:");
    }
    public void printTotalListSize(int size){
        indent(); System.out.println("Now you have " + size + " tasks in the list.");
    }
    public void printAddMsg(){
        indent(); System.out.println("Got it. I've added this task:");
    }
    public void printNoMatchesMsg(){
        indent(); System.out.println("No matching task found");
    }
    public void printMatchesMsg(){
        indent(); System.out.println("Here are the matching tasks in your list:");
    }
    public String readCommand(){
        return sc.nextLine();
    }
    public boolean getIsExit(){
        return this.isExit;
    }
    public void setIsExit(){
        this.isExit = true;
    }
    public void showError(String error){
        System.out.println(error);
    }
}


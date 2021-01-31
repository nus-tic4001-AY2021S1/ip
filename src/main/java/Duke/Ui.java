package Duke;

import java.util.Scanner;

//deals with interactions with the user
class Ui {
    private Scanner sc = new Scanner(System.in);
    private boolean isExit;

    public Ui(){
        this.isExit = false;
    }
    public String indent(){
        return ("\t");
    }
    public String printLine(){
        indent();
        return ("____________________________________________________________");
    }
    public String printLogo(){
        String logo = "\t ____        _        \n"
                + "\t|  _ \\ _   _| | _____ \n"
                + "\t| | | | | | | |/ / _ \\\n"
                + "\t| |_| | |_| |   <  __/\n"
                + "\t|____/ \\__,_|_|\\_\\___|\n";
        return (logo);
    }
    public String printGreetings(){
        //printLine();
        //printLogo();
        //indent();
         return ("Hello! I'm Duke, What can I do for you");
        //indent(); System.out.println("What can I do for you?");
        //printLine();
    }
    public String printClosing(){
        indent();
        return ("Bye. Hope to see you again soon!");
    }
    public String printNoRecords(){
        indent();
        return ("No record added");
    }
    public String printList(){
        indent();
        return ("Here are the tasks in your list:");

    }
    public String indentPrintString(String toPrint){
        indent(); indent();
        return (toPrint);
    }
    public String printDoneMsg(){
        indent();
        return ("Nice! I've marked this task as done:");
    }
    public String printDeleteMsg(){
        indent();
        return ("Noted. I've removed this task:");
    }
    public String printTotalListSize(int size){
        indent();
        return ("Now you have " + size + " tasks in the list.");
    }
    public String printAddMsg(){
        indent();
        return ("Got it. I've added this task:");
    }
    public String printNoMatchesMsg(){
        indent();
        return ("No matching task found");
    }
    public String printMatchesMsg(){
        indent();
        return ("Here are the matching tasks in your list:");
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
    public String showError(String error){
        return (error);
    }
}


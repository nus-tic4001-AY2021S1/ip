import java.util.Scanner;

public class Ui {
    private Scanner in = new Scanner(System.in);
    public void printlogo(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }
    public void greetInfo() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }
    public void exitInfo(){
        System.out.println("----------------\n"+"Bye. Hope to see you again soon!");
    }
    public String getInput(Scanner in) {
        return in.nextLine().trim();
    }
    public void printMsg(Task [] tasks,int size){
        System.out.println("-----------");
        for (int i = 0;i<size;i++){
            System.out.println((i+1)+"."+ "["+tasks[i].getStatusIcon()+"] "+
                    tasks[i].description);
        }
        System.out.println("-----------");
    }
    public void printMsg(String str){
        System.out.println("-----------\nadded: " + str + "\n-----------");
    }
    public void printMsg(Task t){
        System.out.println( "-----------------\n"+"Nice! I've marked this task as done:\n"+"["+t.getStatusIcon()+"] "+
                t.description);
    }
}

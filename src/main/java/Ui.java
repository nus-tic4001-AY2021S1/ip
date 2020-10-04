import Task.Tasks;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    private final String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    private final String greetMsg = " Hello! I'm Duke\n" + logo +"\n"+
            " What can I do for you?";

    private final String exitMsg = " Bye. Hope to see you again soon!";


    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String getCommand(){

        return scanner.nextLine();
    }

    public void print(String s){
        System.out.println(s);
    }

    public void printLine(){
        print("________________________________________________________");
    }

    public void printTask(Tasks t, TaskList tasks) {
        print("Got it. I've added this task:");
        print(t.toString());
        print("Now you have " + tasks.size() + " tasks in the list.");
    }

    public void printTaskList(TaskList tasks) {
        int index = 1;
        for (Tasks task : tasks.getAllTaskList()) {
            print(index + "." + task.toString());
            index++;
        }
    }

    public void printGreetMsg(){
        print(greetMsg);
    }

    public void printExitMsg(){
        print(exitMsg);
    }

}

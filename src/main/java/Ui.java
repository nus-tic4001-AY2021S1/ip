import Task.Tasks;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;

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
        System.out.println("Got it. I've added this task:");
        System.out.println(t.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}

package Duke;

import Duke.Tasks.Task;

import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String getCommand(){
        return scanner.nextLine();
    }

    public void show(String s){
        System.out.println(s);
    }

    public void showLine(){
        show("________________________________________________________");
    }

    public void printTask(Task t, TaskList tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println(t.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}

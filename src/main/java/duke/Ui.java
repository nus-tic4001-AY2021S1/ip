package duke;

import java.util.Scanner;

import duke.tasks.Task;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String getCommand() {
        return scanner.nextLine();
    }

    public void show(String s) {
        System.out.println(s);
    }

    public void showLine() {
        show("________________________________________________________");
    }

    /**
     * @param t A normal task
     * @param tasks the stored task list
     */
    public void printTask(Task t, TaskList tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println(t.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}

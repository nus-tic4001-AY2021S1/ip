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
    public String printTask(Task t, TaskList tasks) {
        return "Got it. I've added this task:" + System.lineSeparator() + t.toString() + System.lineSeparator()
                + "Now you have " + tasks.size() + " tasks in the list.";
    }
}

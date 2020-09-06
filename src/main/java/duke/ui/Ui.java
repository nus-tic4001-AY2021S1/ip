package duke.ui;

import duke.task.TaskList;

public class Ui {

    public void printDukeLogo() {
        System.out.println(Style.LOGO.getString());
    }

    public void printGreeting() {
        String greeting = "Hello! I'm Duke.\n"
                + "I can help you manage a list of tasks!\n"
                + "What you can tell me to do is listed below:\n"
                + "  ⬡  Create a Todo task     | " + colorGreen("todo <your task>\n")
                + "  ⬢  Create a Deadline task | " + colorGreen("deadline <your task> /by <when>\n")
                + "  ⬡  Create an Event task   | " + colorGreen("event <your task> /at <when to when>\n")
                + "  ⬢  Complete a task        | " + colorGreen("done <task index number>\n")
                + "  ⬡  Delete a task          | " + colorGreen("delete <task index number>\n")
                + "  ⬡  List down all tasks    | " + colorGreen("list\n")
                + "  ⬢  Exit my program        | " + colorGreen("bye or hit Enter\n")
                + "So, what would you like to start with?";
        printBorderlines(greeting);
    }

    public void printFarewell() {
        String farewell = "Bye. Hope to see you again soon!";
        printBorderlines(farewell);
    }

    public void printTaskAdded(TaskList tasks) {
        String added = "Great! You have entered a proper task as shown below:\n"
                + colorGreen(tasks.get(tasks.size() - 1).getDescription()
                + "\nWe now have " + tasks.size() + " task(s) in your list!");
        printBorderlines(added);
    }

    public void printTaskRemoved(TaskList tasks) {
        String added = "Okay! We have removed the task as shown below:\n"
                + colorRed(tasks.get(tasks.size() - 1).getDescription()
                + colorGreen("\nWe now have " + (tasks.size() - 1) + " task(s) in your list!"));
        printBorderlines(added);
    }

    public void printTaskCompleted(int index, TaskList tasks) {
        String done = "Good work there! Now we have:\n"
                + "\033[33mTask [" + index + "] "
                + tasks.get(index - 1).getDescription() + " set as completed!\033[0m";
        printBorderlines(done);
    }

    public void printAllTasks(TaskList tasks) {
        String total = "Here are the tasks that you currently have!\n";
        for (int i = 0; i < tasks.size(); i++) {
            total = total.concat((i + 1) + ". " + tasks.get(i).getDescription()) + "\n";
        }
        printBorderlines(total);
    }

    public void printBorderlines(String input) {
        System.out.println(Style.BORDERLINE.getString()
                + input
                + Style.BORDERLINE.getString());
    }

    public String redBorderlines(String input) {
        return colorRed(Style.BORDERLINE.getString())
                + input
                + colorRed(Style.BORDERLINE.getString());
    }

    public void printRedBorderlines(String input) {
        System.out.println(redBorderlines(input));
    }

    public void printInvalidCommand() {
        System.out.println(redBorderlines("It seems that you have typed something out of my unfortunately\n"
                + "limited vocabulary. Can you try again?"));
    }

    public String colorRed(String input) {
        return "\033[31m" + input + "\033[0m";
    }

    public String colorGreen(String input) {
        return "\033[33m" + input + "\033[0m";
    }
}

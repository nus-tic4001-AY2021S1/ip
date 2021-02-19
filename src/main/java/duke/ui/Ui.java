package duke.ui;

import java.util.Scanner;

public class Ui {


    public Ui() {

    }

    // welcome come msg for the UI
    public String welcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String output = logo + "\rHello! I'm Duke\nWhat can I do for you?\n";
        return output;

    }

    // divider for each line
    public void divider() {
        System.out.println("-----------------------------------------------------------------");
    }

    // options to choose the feature
    public String tasks() {
        String help = "\n--help             -Check the user manual\n"
                + "--todo             -Add a to do task\n"
                + "--event            -Add an event\n"
                + "--deadline       -Add a deadline task\n"
                + "--list                 -List all task\n"
                + "--done             -Mark a task to be done\n"
                + "--delete           -Delete a task\n"
                + "--find             -Find a task contain the key word\n"
                + "--send               -send a email to user\n"
                + "--save               -Save the task\n";


        return help;
    }

    // add time msg
    public void time() {
        System.out.println("please add date: dd/mm/yyyy hhmm eg: 2/12/2019 1800");
    }

    // good bye msg
    public String saveMsg() {

        return "Your recent changed has been save!";
    }

    public void showLoadingError() {
        System.out.println("file not exist");

    }

    public String description(String input) {
        String[] obj = input.split("--");
        String output = "";
        for (Object data : obj) {
            String[] temp;
            if (data.toString().contains("todo")) {
                output = output.concat("This is a todo Task has been added.\n");
            }
            if (data.toString().contains("event")) {
                output = output.concat("This is a event Task has been added.\n");
            }
            if (data.toString().contains("deadline")) {
                output = output.concat("This is a deadline Task has been added.\n");
            }
            if (data.toString().contains("description")) {
                temp = data.toString().split(" ");
                output = output.concat("Description: " + temp[1]);
            }
            if (data.toString().contains("date")) {
                temp = data.toString().split(" ", 2);
                output = output.concat("\nDate: " + temp[1]);
            }
            if (data.toString().contains("email")) {
                temp = data.toString().split(" ");
                output = output.concat("\nEmail: " + temp[1]);
            }
        }
        return output;
    }

    public String dataConverter(String input) {
        String[] obj = input.split(" \\| ", 3);
        String output = "";
        String[] firstObj = obj[0].toString().split(" ", 2);
        if (firstObj[0].contains("T")) {
            output = output.concat("This is a Todo task.");
        } else if (firstObj[0].contains("E")) {
            output = output.concat("This is a Event task.");
        } else {
            output = output.concat("This is a Deadline task.");
        }
        if (firstObj[0].contains("c")) {
            output = output.concat("\nStatus: Done");
        } else {
            output = output.concat("\nStatus: Undone");
        }
        output = output.concat("\nDescription: " + firstObj[1]);
        output = output.concat("\nDate: " + obj[1]);
        output = output.concat("\nEmail " + obj[2]);
        return output;

    }
}

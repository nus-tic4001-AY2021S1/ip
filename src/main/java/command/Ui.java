package command;

import java.util.Scanner;

public class Ui {


    public Ui(){

    }
    // welcome come msg for the UI
    public void welcome(){
            String logo = " ____        _        \n"
                    + "|  _ \\ _   _| | _____ \n"
                    + "| | | | | | | |/ / _ \\\n"
                    + "| |_| | |_| |   <  __/\n"
                    + "|____/ \\__,_|_|\\_\\___|\n";
            System.out.println("Hello from\n" + logo);

            System.out.println("Hello! I'm Duke\nWhat can I do for you?\n");
    }

    // divider for each line
    public void divider(){
        System.out.println("-----------------------------------------------------------------");
    }

    // options to choose the feature
    public void tasks() {
        divider();
        System.out.println("Press 1: Add a to do task");
        System.out.println("Press 2: Add an event ");
        System.out.println("Press 3: Add a deadline task");
        System.out.println("Press 4: List all task");
        System.out.println("Press 5: Mark a task to be done");
        System.out.println("Press 6: Delete a task");
        System.out.println("Press 7: Exit");
        divider();

    }

    // add time msg
    public void time(){
        System.out.println("please add time");
    }


    // user input
    public String input(){

        Scanner myObj = new Scanner(System.in);

        return myObj.nextLine();
    }
    // good bye msg
    public void goodBye(){
        divider();
        System.out.println("Bye. Hope to see you again soon!");
    }

}

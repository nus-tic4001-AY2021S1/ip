package ui;

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
        System.out.println("help       -Check the user manual");
        System.out.println("todo       -Add a to do task");
        System.out.println("event      -Add an event ");
        System.out.println("deadline   -Add a deadline task");
        System.out.println("list       -List all task");
        System.out.println("done       -Mark a task to be done");
        System.out.println("delete     -Delete a task");
        System.out.println("load       -Load task from the file");
        System.out.println("bye        -Exit the task");
        divider();

    }

    // add time msg
    public void time(){
        System.out.println("please add time");
    }

    public void addTask(){
        System.out.println("Task has been added");

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

    public void showLoadingError(){
        System.out.println("file not exsit");

    }

}

package command;

import java.util.Scanner;

public class Ui {


    public Ui(){

    }

    public void welcome(){
            String logo = " ____        _        \n"
                    + "|  _ \\ _   _| | _____ \n"
                    + "| | | | | | | |/ / _ \\\n"
                    + "| |_| | |_| |   <  __/\n"
                    + "|____/ \\__,_|_|\\_\\___|\n";
            System.out.println("Hello from\n" + logo);

            System.out.println("Hello! I'm Duke\nWhat can I do for you?\n");
    }

    public void divider(){
        System.out.println("-----------------------------------------------------------------");
    }

    public void tasks() {
        divider();
        System.out.println("Press 1: Add a to do task");
        System.out.println("Press 2: Add an event ");
        System.out.println("Press 3: Add a deadline task");
        System.out.println("Press 4: List all task");
        System.out.println("Press 5: Mark a task to be done");
        System.out.println("Press 6: Exit");
        divider();

    }

    public void addTask(String obj){
        System.out.println("added " + obj);
    }

    public void time(){
        System.out.println("please add time");

    }

    public String input(){

        Scanner myObj = new Scanner(System.in);

        return myObj.nextLine();
    }

    public void goodBye(){
        divider();
        System.out.println("Bye. Hope to see you again soon!");
    }

}

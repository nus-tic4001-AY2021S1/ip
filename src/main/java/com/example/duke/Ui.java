package com.example.duke;

import java.util.Scanner;

public class Ui {
    private Scanner in;

    public Ui(){
        in=new Scanner (System.in);
    }
    public void showToUser(String myMessage){
        System.out.println(myMessage);
    }

    public void printWelcome(){

        System.out.println("Hello, I'm Duke\nWhat can I do for you?\n");

    }

    public void printError(String errorMessage){

        System.out.println("There seems to be an error." + errorMessage);
    }

    public String readCommand(){
        return in.nextLine();
    }

    public void showLoadingError(){
        System.out.println("There seems to be a file loading error. No tasks are preloaded\nStarting a new list...");
    }

}

package com.example.duke;

public class Parser {
    public static Command parse (String userInput) {

        String[] arrayOfStr = userInput.split(" ", 2);

        switch (arrayOfStr[0]) {

            case "todo":

                return new AddTodoCommand(arrayOfStr[1]);

            default:
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                return new AddTodoCommand(arrayOfStr[1]);
        }
    }




}

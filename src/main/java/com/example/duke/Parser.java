package com.example.duke;

public class Parser {
    public static Command parse(String userInput) {

        String[] arrayOfStr = userInput.split(" ", 2);

        switch (arrayOfStr[0]) {

            case "todo":
                return new AddTodoCommand(arrayOfStr[1]);
            case "deadline":
                String[] arrayOfDeadlineDetails = arrayOfStr[1].split("by ", 2);
                return new AddDeadlineCommand(arrayOfDeadlineDetails[0], arrayOfDeadlineDetails[1]);
            case "event":
                String[] arrayOfEventDetails = arrayOfStr[1].split("at ", 2);
                return new AddEventCommand(arrayOfEventDetails[0], arrayOfEventDetails[1]);
            case "delete":
                return new DeleteCommand(arrayOfStr[1]);
            case "list":
                //System.out.println("list command");
                return new ListCommand();
            case "done":
                return new DoneCommand(arrayOfStr[1]);
            case "bye":
                return new ExitCommand();
            case "find":
                return new FindCommand(arrayOfStr[1]);

            default:
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                return new Command();
        }
    }


}

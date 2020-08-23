import static javafx.application.Platform.exit;

public class Parser {

    public static String filterTaskDetails(String line) {
        String task_detail = "";
        int len = line.split(" ").length; //// to check who many words
        String[] line_arr = line.split(" ", 2);
        if (len > 1) {
            task_detail = line_arr[1];  // filter out the first words
        } else {
            throw new NullPointerException("TASK is Empty/Null: Returning to Main Menu");
        }
        return task_detail;
    }

    public String getSecondWord(String input) {
        String commandSecondWord = input.split(" ")[1];
        return commandSecondWord;
    }

    public void getCommand(String input, Ui ui, ProgramExit programExit, TodoList todoList) {

        String commandFirstWord = input.split(" ")[0];//extract the first word of the user input


        try {

            switch (commandFirstWord) {


                case "bye":
                    ui.sayBye();
                    programExit.toExit();
                    break;
                case "list":
                    Ui.printLine();
                    todoList.listAllTasks();
                    Ui.printLine();
                    break;
                case "done":
                    Ui.printLine();
                    todoList.markSelectedTaskDone(getSecondWord(input));
                    Ui.printLine();
                    break;
                case "todo":
                    Ui.printLine();
                    todoList.addToDoType(filterTaskDetails(input));
                    todoList.readTaskFromUser(filterTaskDetails(input));
                    Ui.printLine();
                    break;
                case "deadline":
                    Ui.printLine();
                    todoList.addDeadlineType(filterTaskDetails(input));
                    todoList.readTaskFromUser(filterTaskDetails(input));
                    Ui.printLine();
                    break;
                case "event":
                    Ui.printLine();
                    todoList.addEventType(filterTaskDetails(input));
                    todoList.readTaskFromUser(filterTaskDetails(input));
                    Ui.printLine();
                    break;
                default:
                    Ui.printLine();
                    Ui.showMessage("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    Ui.printLine();

            }

        } catch (Exception e) {
            Ui.showMessage(e.getMessage());
        }


    }


}

















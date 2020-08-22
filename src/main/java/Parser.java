public class Parser {

    public String getSecondWord(String input) {
        String commandSecondWord = input.split(" ")[1];
        return commandSecondWord;
    }

    public void getCommand(String input, Ui ui, Storage store, TodoList todoList) {

        String commandFirstWord = input.split(" ")[0];//extract the first word of the user input
        try {

            switch (commandFirstWord) {
                case "bye":
                    ui.sayBye();
                    store.toExit();
                    break;
                case "list":
                    todoList.listAllTasks();
                    break;
                case "done":
                    todoList.markSelectedTaskDone(getSecondWord(input));
                    break;
                default:
                    Ui.printLine();
                    todoList.readTaskFromUser(input);
                    Ui.printLine();

            }

        } catch (Exception e) {
            Ui.showMessage(e.getMessage());
        }

    }


}

















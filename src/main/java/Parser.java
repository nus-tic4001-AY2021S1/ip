public class Parser {

    public void getCommand(String input, Ui ui, Storage store, TodoList todoList) {
        try {

            switch (input) {
                case "bye":
                    ui.sayBye();
                    store.toExit();
                    break;
                case "list":
                    todoList.listAllTasks();
                    break;
                default:
                    Ui.printLine();
//                ui.echosCommands(input);
                    todoList.readTaskFromUser(input);
                    Ui.printLine();

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }


}

















public class Duke {
    public static void main(String[] args) {

        Ui ui = new Ui();
        Storage store = new Storage();
        Parser parser = new Parser();
        TodoList todoList = new TodoList();

        Ui.sayWelcome();
        while (!store.getIsExit()) {
            parser.getCommand(Ui.readUserCommand(), ui, store, todoList);
        }


    }
}

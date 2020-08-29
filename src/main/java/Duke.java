public class Duke {
    public static void main(String[] args) {

        Ui ui = new Ui();
        ProgramExit programExit = new ProgramExit();
        Parser parser = new Parser();
        TodoList todoList = new TodoList();

        Ui.sayWelcome();
        while (!programExit.getIsExit()) {
            parser.getCommand(Ui.readUserCommand(), ui, programExit, todoList);
        }


    }
}



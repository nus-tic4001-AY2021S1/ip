public class Duke {
    public static void main(String[] args) {

        Ui ui = new Ui();
        Storage store = new Storage();
        Parser parser = new Parser();
        Ui.sayWelcome();
        while (!store.getIsExit()) {
            parser.getCommand(Ui.readUserCommand(), ui, store);
        }


    }
}

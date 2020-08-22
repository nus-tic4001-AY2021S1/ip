public class Parser {

    public void getCommand(String input, Ui ui, Storage store) {

        if ("bye".equals(input)) {
            ui.sayBye();
            store.toExit();
        } else {
            Ui.printLine();
            ui.echosCommands(input);
            Ui.printLine();
        }
    }


}













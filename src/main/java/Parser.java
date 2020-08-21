public class Parser {
    public void getCommand(String input,Storage store, Ui ui){
        switch (input) {
            case "bye":
                store.toExit();
                ui.byeToUser();
                break;
            default:
                ui.printLine();
                ui.indentPrint(input);
                ui.printLine();
        }
    }
}

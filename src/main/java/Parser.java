public class Parser {
    public void getCommand(String input,Storage store, Ui ui){
        switch (input) {
            case "bye":
                store.toExit();
                ui.byeToUser();
                break;
            case "list":
                ui.printLine();
                for(int i=0;i<store.getSize();i++){
                    ui.indentPrint((i+1)+". "+store.getTask(i));
                }
                ui.printLine();
                break;
            default:
                ui.printLine();
                store.addToTemp(input);
                ui.indentPrint("added: "+input);
                ui.printLine();
        }
    }
}

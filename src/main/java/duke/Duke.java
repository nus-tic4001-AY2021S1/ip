package duke;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        Ui ui = new Ui();
        Storage store = new Storage();
        Parser parser = new Parser();
        ui.greetUser();
        while(!store.getIsExit()){
            try {
                parser.getCommand(ui.readCommand(), store, ui);
            } catch (Exception e) {
                ui.indentPrint("☹ OOPS!!! " +e.getMessage());
            }
            ui.printLine();
        }
    }
}

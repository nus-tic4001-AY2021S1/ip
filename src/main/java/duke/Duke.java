package duke;

import duke.tasks.TaskList;

public class Duke {
    public static void run(){

    }
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        Ui ui = new Ui();
        TaskList taskList = new TaskList();
        Storage store = new Storage(taskList);
        Parser parser = new Parser();
        ui.greetUser();
        while(!store.getIsExit()){
            try {
                parser.getCommand(ui.readCommand(), store, ui, taskList);
            } catch (Exception e) {
                ui.indentPrint("☹ OOPS!!! " +e.getMessage());
            }
            ui.printLine();
        }
    }
}

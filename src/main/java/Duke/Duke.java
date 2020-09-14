package Duke;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private TaskList tasks;
    public Parser paser;
    public Ui ui;
    private Storage storage;
    public Duke(String path){
        ui = new Ui();
        storage = new Storage(path);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (DukeException e) {
            ui.printError(e);
            tasks = new TaskList();
        }
    }
    public void run(){
        paser = new Parser(ui,tasks);
        ui.printLogo();
        ui.greetMessage();
        Scanner in = new Scanner(System.in);
        String str = "";


        while (!str.equals("bye") ) {
            try {
                str = ui.getInput(in);
                paser.handleCommands(str);
            }catch (DukeException e){
                ui.printError(e);
            }

            try {
                storage.saveToFile(tasks);
            }catch (DukeException e){
                ui.printError(e);
            }
        }
    }
    public static void main(String[] args) {
        new Duke("/Users/chenduo/Desktop/ip/Duke.txt").run();
    }
}

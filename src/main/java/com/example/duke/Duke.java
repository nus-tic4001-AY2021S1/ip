package com.example.duke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Duke {

    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    public Duke (String filePath) {
        ui=new Ui();
        storage=new Storage(filePath);
        try {
            tasks= new TaskList(storage.load());
        } catch (DukeException e) {
           ui.showLoadingError();
           tasks=new TaskList();
        }

    }
    public void run (){
        ui.printWelcome();
        boolean isExit=false;
        while(!isExit) {
            String fullCommand = ui.readCommand();
            Command c = Parser.parse(fullCommand);
            c.execute(tasks,ui,storage);
            isExit=c.isExit();
        }
    }

    public static void main(String[] args) {
        new Duke("/Users/januariusjang/Downloads/iP/data/tasks.txt").run();
    }


}

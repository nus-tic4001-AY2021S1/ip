package duke;

import ui.FileHandling;
import ui.processCommand;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) throws IOException, DukeException {

        //private ui ui;
        ArrayList<Task> tasks = new ArrayList<>();

        try {
            FileHandling.readFileToTask(tasks);
        } catch (FileNotFoundException e) {
            FileHandling.createFile();
            FileHandling.readFileToTask(tasks);
        }

        ui.ui.welcomeLogo();

        Scanner in = new Scanner(System.in);

        while(in.hasNextLine()){
            String input = in.nextLine();

            if(!(input.toLowerCase()).equals("bye")) {
                processCommand.processInput(input, tasks);
            } else {
                ui.ui.greetNote("bye");
                return;
            }
        }
    }

}

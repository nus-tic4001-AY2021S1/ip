package duke;

import ui.processCommand;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {

        ArrayList<Task> tasks = new ArrayList<>();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        ui.ui.greetNote("welcome");

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

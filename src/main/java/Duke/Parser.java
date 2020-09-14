package Duke;

import java.io.*;
import java.util.*;

public class Parser {
    private Ui ui;
    private TaskList tasks;

    public Parser(Ui ui,TaskList tasks){
        this.ui = ui;
        this.tasks = tasks;
    }

    public void handleCommands(String str){
        Task singleTask;
        int selectedIn;

        if (!str.equals("") & !str.equals("bye")) {
            if (str.equals("list")) {
                ui.printList(tasks.getTasks());
            } else if (str.contains("done")) {
                selectedIn = Integer.parseInt(str.split(" ")[1]) - 1;
                tasks.getTasks().get(selectedIn).markAsDone();
                ui.printMarkAsDone(tasks.getTasks().get(selectedIn));
            } else {
                if (str.split(" ")[0].equals("todo")) {
                    singleTask = new Todo(str.substring(5), 'T');
                    tasks.storeInArray(singleTask);

                    ui.printTask(singleTask.toString(), tasks.getSize());
                } else if (str.split(" ")[0].equals("deadline")) {
                    String[] deadline = str.substring(9).split(" /by ");
                    if (deadline.length == 2) {
                        singleTask = new Deadline(deadline[0], 'D', deadline[1]);
                        tasks.storeInArray(singleTask);
                        ui.printTask(singleTask.toString(), tasks.getSize());
                    }
                } else if (str.split(" ")[0].equals("event")) {
                    String[] event = str.substring(6).split(" /at ");
                    if (event.length == 2) {
                        singleTask = new Event(event[0], 'E', event[1]);
                        tasks.storeInArray(singleTask);
                        ui.printTask(singleTask.toString(), tasks.getSize());

                    }
                } else if (str.contains("delete")) {
                    selectedIn = Integer.parseInt(str.split(" ")[1]) - 1;
                    System.out.println("selectedIn:" + selectedIn);
                    singleTask = tasks.getTasks().get(selectedIn);
                    tasks.deleteFromList(selectedIn);
                    ui.printDeleteMsg(singleTask, tasks.getSize());
                }
            }
        }
        if(str.equals("bye")) {
            ui.exitMessage();
        }
    }


}
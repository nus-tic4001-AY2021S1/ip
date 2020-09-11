package Duke;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static int size=100;
    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.printLogo();
        ui.greetMessage();

        ArrayList<Task> tasks = new  ArrayList<Task>();
        Parser paser = new Parser(tasks, size);
        Scanner in = new Scanner(System.in);
        String str = "";
        Task singleTask;
        int selectedIn,count=0;
        try {
            count = paser.loadTasks(tasks);
        }catch (DukeException e){
            ui.printError(e);
        }
        while (!str.equals("bye") & count<size) {
            try {
                str = ui.getInput(in);
                if (!str.equals("") & !str.equals("bye")) {
                    if (str.equals("list")) {
                        ui.printList(tasks, count);
                    } else if (str.contains("done")) {
                        selectedIn = Integer.parseInt(str.split(" ")[1]) - 1;
                        tasks.get(selectedIn).markAsDone();
                        ui.printMarkAsDone(tasks.get(selectedIn));
                    } else {
                        if (str.split(" ")[0].equals("todo")) {
                            singleTask = new Todo(str.substring(5),'T');
                            paser.storeInArray(singleTask);
                            count++;
                            ui.printTask(singleTask.toString(), count);
                        } else if (str.split(" ")[0].equals("deadline")) {
                            String[] deadline = str.substring(9).split(" /by ");
                            if (deadline.length == 2) {
                                singleTask = new Deadline(deadline[0], 'D',deadline[1]);
                                paser.storeInArray(singleTask);
                                count++;
                                ui.printTask(singleTask.toString(), count);
                            }
                        } else if (str.split(" ")[0].equals("event")) {
                            String[] event = str.substring(6).split(" /at ");
                            if (event.length == 2) {
                                singleTask = new Event(event[0], 'E',event[1]);
                                paser.storeInArray(singleTask);
                                count++;
                                ui.printTask(singleTask.toString(), count);

                            }
                        }else if (str.contains("delete")) {
                            selectedIn = Integer.parseInt(str.split(" ")[1]) - 1;
                            System.out.println("selectedIn:"+selectedIn);
                            singleTask=tasks.get(selectedIn);
                            paser.deleteFromList(selectedIn);
                            count--;
                            ui.printDeleteMsg(singleTask,count);
                        }
                    }
                }
            }catch (DukeException e){
                ui.printError(e);
            }

           if(str.equals("bye")) {
                ui.exitMessage();
            }
           try {
               paser.saveToFile(tasks);
           }catch (DukeException e){
               ui.printError(e);
           }

        }

    }
}

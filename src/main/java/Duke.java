import java.util.Scanner;

public class Duke {
    public static int size=100;
    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.printlogo();
        ui.greetInfo();

        Task[] tasks = new Task[size];
        Paser paser = new Paser(tasks, size);
        Scanner in = new Scanner(System.in);
        String str = "";
        Task singleTask;
        int selectedIn,count=0;
        while (!str.equals("bye") & count<size) {
            str = ui.getInput(in);
            if(!str.equals("") & !str.equals("bye")) {
                if (str.equals("list")) {
                    ui.printList(tasks, count);
                } else if (str.contains("done")) {
                    selectedIn = Integer.parseInt(str.split(" ")[1]) - 1;
                    tasks[selectedIn].markAsDone();
                    ui.printMsg(tasks[selectedIn]);
                } else {

                    if (str.split(" ")[0].equals("todo")) {
                        singleTask = new Todo(str.substring(5));
                        paser.storeInArray(singleTask, count);
                        count++;
                        ui.printTask(singleTask.toString(), count);
                    } else if (str.split(" ")[0].equals("deadline")) {
                        String[] dl = str.substring(9).split(" /by ");
                        if (dl.length == 2) {
                            singleTask = new Deadline(dl[0], dl[1]);
                            paser.storeInArray(singleTask, count);
                            count++;
                            ui.printTask(singleTask.toString(), count);
                        }
                    } else if (str.split(" ")[0].equals("event")) {
                        String[] ev = str.substring(6).split(" /at ");
                        if (ev.length == 2) {
                            singleTask = new Event(ev[0], ev[1]);
                            paser.storeInArray(singleTask, count);
                            count++;
                            ui.printTask(singleTask.toString(), count);

                        }
                    }
                }
            }
           if(str.equals("bye")) {
                ui.exitInfo();
            }

        }

    }
}

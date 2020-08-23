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
            if(!str.equals("") & !str.equals("bye")){
                if(str.equals("list")){
                    ui.printMsg(tasks,count);
                }
                else if (str.contains("done")){
                    selectedIn=Integer.parseInt(str.split(" ")[1])-1;
                    tasks[selectedIn].markAsDone();
                    ui.printMsg(tasks[selectedIn]);
                }else {
                    singleTask=new Task(str);
                    ui.printMsg(str);

                    paser.storeInArray(singleTask,count);
                    count++;
                }
            }
           else if (str.equals("bye")) {
                ui.exitInfo();
            }

        }

    }
}
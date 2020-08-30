import java.util.ArrayList;
import java.util.Scanner;

public class SwitchTasks {


    private boolean task;

    public static String obj;

    AddTasks addTasks = new AddTasks();
    Ui ui = new Ui();


    public SwitchTasks(){
        this.task=true;
    }

    public void option(){

        ui.welcome();

        while (task == true) {


            ui.tasks();
            obj = ui.input();

            switch(obj){
                case "1":
                      obj = ui.input();
                      addTasks.toDoTask(obj);
                      ui.time();
                      obj = ui.input();
                      addTasks.addTime(obj);
                      break;

                case "2":
                    System.out.println("Event");
                    obj = ui.input();
                    addTasks.eventTask(obj);
                    break;

                case "3":
                    System.out.println("deadline");
                    obj = ui.input();
                    addTasks.deadLineTask(obj);
                    break;


                case "4":
                    System.out.println("list");
                    addTasks.showTask();
                    break;


                case "5":
                    System.out.println("mark done");
                    obj = ui.input();
                    addTasks.makeDone(obj);
                    break;

                case "bye":
                    task = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }

    }
}

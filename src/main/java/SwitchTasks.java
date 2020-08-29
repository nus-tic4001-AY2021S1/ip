import java.util.ArrayList;
import java.util.Scanner;

public class SwitchTasks {


    //System.out.println(tick);
    //System.out.println(cross);

    public SwitchTasks(){

    }

    public void option(){

        ShowTasks showTasks= new ShowTasks();
        TodoTasks todoTasks= new TodoTasks();
        EventTasks eventTasks=new EventTasks();
        DeadlineTasks deadlineTasks=new DeadlineTasks();
        MakeDoneTasks makeDoneTasks=new MakeDoneTasks();

        Scanner myObj = new Scanner(System.in);



        while (myObj.hasNext()) {

            // System.out.println("Added task press 1");
            // System.out.println("Show current task press 2");

            

            String obj1 = myObj.nextLine();

            switch(obj1){
                case "1":
                      System.out.println("todo");
                      //Scanner myObj1 = new Scanner(System.in);
                      String todo = myObj.nextLine();
                      todoTasks.toDoTask(todo);

                case "2":
                    System.out.println("Event");
                    //Scanner myObj1 = new Scanner(System.in);
                    String event = myObj.nextLine();
                    eventTasks.eventTask(event);
                case "3":
                    System.out.println("deadline");
                    //Scanner myObj1 = new Scanner(System.in);
                    String deadLine = myObj.nextLine();
                    deadlineTasks.deadLineTask(deadLine);

                case "4":
                    System.out.println("list");
                    //Scanner myObj1 = new Scanner(System.in);
                    //String deadLine = myObj.nextLine();
                    showTasks.showTasks();

                case "5":
                    System.out.println("deadline");
                    //Scanner myObj1 = new Scanner(System.in);
                    String markDone = myObj.nextLine();
                    makeDoneTasks.makeDone(markDone);
                default:

            }

        }


    }

}

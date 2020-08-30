
public class SwitchTasks {


    private boolean task;
    private static String obj;

    AddTasks addTasks = new AddTasks();
    Ui ui = new Ui();


    public SwitchTasks(){
        this.task=true;
        this.obj=obj;
    }

    public void option(){

        ui.welcome();

        while (task == true) {

            ui.tasks();
            obj = ui.input();

            switch(obj){
                case "1":
                    System.out.println("Please add a to do task");
                      obj = ui.input();
                      addTasks.toDoTask(obj);
                      ui.time();
                      obj = ui.input();
                      addTasks.addTime(obj);
                      break;

                case "2":
                    System.out.println("Please add a event task");
                    obj = ui.input();
                    addTasks.eventTask(obj);
                    obj = ui.input();
                    addTasks.addTime(obj);
                    break;

                case "3":
                    System.out.println("Please add a deadline task");
                    obj = ui.input();
                    addTasks.deadLineTask(obj);
                    obj = ui.input();
                    addTasks.addTime(obj);
                    break;

                case "4":
                    System.out.println("list");
                    addTasks.showTask();
                    break;

                case "5":
                    System.out.println("Please mark done a task");
                    obj = ui.input();
                    addTasks.makeDone(obj);
                    obj = ui.input();
                    addTasks.addTime(obj);
                    break;

                case "6":
                    task = false;
                    break;
                default:
                    System.out.println("Invalid Input please enter again");
                    break;
            }
        }

        ui.goodBye();
    }
}

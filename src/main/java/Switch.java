public class Switch {

    private boolean task;
    private static String obj;
    private static String obj1;

    Storage storage = new Storage();
  //  AddTasks addTasks = new AddTasks();
    Ui ui = new Ui();


    public Switch(){
        this.task=true;
    }

    public void option(){

        ui.welcome();

        while (task == true || obj.equalsIgnoreCase("bye")) {

            ui.tasks();
            obj = ui.input();

            switch(obj){
                case "1":
                    System.out.println("Please add a to do task");
                    obj = ui.input();
                    ui.time();
                    obj1 = ui.input();
                    storage.setCommandName(new Todo(obj , obj1));
                    break;

                case "2":
                    System.out.println("Please add a event task");
                    obj = ui.input();
                    ui.time();
                    obj1 = ui.input();
                    storage.setCommandName(new Event(obj , obj1));
                    break;

                case "3":
                    System.out.println("Please add a deadline task");
                    obj = ui.input();
                    ui.time();
                    obj1 = ui.input();
                    storage.setCommandName(new Deadline(obj , obj1));
                    break;

                case "4":
                    System.out.println("list");
                    storage.getCommandName();
                    break;

                case "5":
                    System.out.println("Please mark done a task");
                    obj = ui.input();
                    storage.setCommandName(obj);
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

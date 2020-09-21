package command;


import ui.Ui;

/**
 * This is a switch class, all the choices will be make by here.
 */

public class Switch {

    private boolean task;
    private static String description;
    private static String time;

    Converter converter = new Converter();
    Ui ui = new Ui();


    public Switch(){
        this.task=true;
    }


    public void option() throws DukeException {


        // print out welcome msg
        ui.welcome();
        // While loop will be exit once the task become false.
        while (task) {

            // print the choices we have
            descriptionCheck();

            // redirect by using switch loop
            switch(description.toLowerCase().replace(" ","")){
                case "todo":
                    System.out.println("Please add a to do task");
                    converter.saveToDo(descriptionCheck(),timeCheck());
                    ui.addTask();
                    break;

                case "event":
                    System.out.println("Please add a event task");
                    converter.saveEvent(descriptionCheck(),timeCheck());
                    break;

                case "deadline":
                    System.out.println("Please add a deadline task");
                    converter.saveDeadLine(descriptionCheck(),timeCheck());
                    break;

                case "list":
                    System.out.println("list");
                    if(converter.checkDataSize()){
                        System.out.println("No data in the database");
                    }
                    else {
                        converter.printData();
                    }
                    break;

                case "done":
                    System.out.println("Please mark done a task");
                    if(converter.checkDataSize()){
                        System.out.println("No data in the database");
                    }
                    else {
                        converter.printData();
                        converter.makeDone(descriptionCheck());
                    }
                    break;

                case "delete":
                    System.out.println("Please delete a task");
                    if(converter.checkDataSize()){
                        System.out.println("No data in the database");
                    }
                    else {
                        converter.printData();
                        converter.makeDelete(descriptionCheck());
                    }
                    break;

                case "help":
                    ui.tasks();
                    break;

                case "load":
                    // load the task from the txt file
                    converter.fileLoader();
                    if(converter.checkDataSize()){
                        System.out.println("No data in the database");
                    }
                    else {
                        System.out.println("This is current tasks");
                        converter.printData();
                    }
                    break;

                case "bye":
                    task = false;
                    break;
                default:
                    System.out.println("Invalid Input. Please enter help");
                    break;
            }
        }
        // save the tasks into txt file.
        converter.fileWriter();
        ui.goodBye();
    }

    private String descriptionCheck(){
        description = ui.input();
        if(description.isEmpty()){
           descriptionCheck();
        }
        return description;
    }

    private String timeCheck(){
        ui.time();
        time = ui.input();
        if(time.isEmpty()){
            System.out.println("No Time has been set");
        }
        return time;
    }

}

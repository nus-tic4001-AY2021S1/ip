package command;

import command.Converter;

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

        ui.welcome();

        while (task) {

            ui.tasks();
            descriptionCheck();

            switch(description){
                case "1":
                    System.out.println("Please add a to do task");
                    converter.saveToDo(descriptionCheck(),timeCheck());
                    break;

                case "2":
                    System.out.println("Please add a event task");
                    converter.saveEvent(descriptionCheck(),timeCheck());
                    break;

                case "3":
                    System.out.println("Please add a deadline task");
                    converter.saveDeadLine(descriptionCheck(),timeCheck());
                    break;

                case "4":
                    System.out.println("list");
                    converter.printData();
                    break;

                case "5":
                    System.out.println("Please mark done a task");
                    converter.makeDone(descriptionCheck());
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

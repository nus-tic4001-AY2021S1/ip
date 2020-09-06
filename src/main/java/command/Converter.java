package command;

import tasks.Deadline;
import tasks.Event;
import tasks.Todo;

public class Converter {


    Storage storage = new Storage();

    public Converter(){

    }

    public void saveToDo(String description, String time){
        storage.setCommandName(new Todo(description,time));
    }


    public void saveEvent(String description, String time) {

        storage.setCommandName(new Event(description,time));

    }

    public void saveDeadLine(String description, String time){

        storage.setCommandName(new Deadline(description,time));

    }

    public void makeDone(String description) throws DukeException {
        if(checkDataSize()){
            System.out.println("Not data in the database");
        }
        else {
            printData();
            String clean = description.replaceAll("\\D+", "");
            int num = Integer.parseInt(clean);
            changeToDone(num);
        }
    }

    private void changeToDone(int num){
        if (num < storage.getCommandName().size()){
            int num1=num - 1;
            String makeDone = storage.getCommandName().get(num1).toString();

            storage.getCommandName().set(num1,makeDone.replace("x","c"));
        }
        else {
           System.out.println("Invalid Input");
        }
    }


    public void printData() throws DukeException {
       printArray();
    }

    private void printArray(){

        if(checkDataSize()){
            System.out.println("Not data in the database");
        }
        else {
            int number = 1;
            for (Object task : storage.getCommandName()) {
                System.out.println(number + ". " + task.toString());
                number ++;
            }
        }
    }
    private boolean checkDataSize(){
        if(storage.getCommandName().isEmpty()){
            return true;
        }
        return false;
    }

}

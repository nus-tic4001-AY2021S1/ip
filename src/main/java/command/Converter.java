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




   // make done method
    public void makeDone(String description) throws DukeException {


            String clean = description.replaceAll("\\D+", "");
            int num = Integer.parseInt(clean);
            changeToDone(num);


    }


    private void changeToDone(int num){
        if (num <= storage.getCommandName().size()){
            int num1=num - 1;
            String makeDone = storage.getCommandName().get(num1).toString();
            System.out.println(makeDone.replace("x","c") + "has been set to done");
            storage.getCommandName().set(num1,makeDone.replace("x","c"));

        }
        else {
            System.out.println("Invalid Input");
        }
    }


    // make delete method
    public void makeDelete(String description) throws DukeException {

            String clean = description.replaceAll("\\D+", "");
            int num = Integer.parseInt(clean);
            deleting(num);

    }

    private void deleting(int num){

        if (num <= storage.getCommandName().size()){
            int num1=num - 1;
            System.out.println(storage.getCommandName().get(num1) + "has been deleted");
            storage.getCommandName().remove(num1);
            System.out.println("there are " +storage.getCommandName().size()+ " tasks in the lists");

        }
        else {
            System.out.println("Invalid Input");
        }

    }



    // print array list method
    public void printData() throws DukeException {
       printArray();
    }

    private void printArray(){


            int number = 1;
            for (Object task : storage.getCommandName()) {
                System.out.println(number + ". " + task.toString());
                number ++;
            }

    }

    public boolean checkDataSize(){
        if(storage.getCommandName().isEmpty()){
            return true;
        }
        return false;
    }

}

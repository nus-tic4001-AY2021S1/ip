package tasks;

import tasks.Tasks;

public class Todo extends Tasks {

  public Todo(String description, String time){

      super(description, time);

      super.type= "[T]";

  }


  public String toString(){

         if (time.isEmpty()){
             return type + status +" "+description;
         }
         else {
             return type + status + " " + description + " (" + time +")";
         }
  }
}

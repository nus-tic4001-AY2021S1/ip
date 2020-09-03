
public class Todo extends Tasks{

  public Todo(String description, String time){

      super(description, time);
      super.type= "[T]";

  }


  public String toString(){

        return type + status +" "+description + time;
  }
}

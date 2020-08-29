public class EventTasks extends ShowTasks {


    ShowTasks showTasks = new ShowTasks();

    public EventTasks(){

    }

    public void eventTask(String event){

        //job = "[" + cross + "]" + obj1;
        System.out.println("added: " + event);
        showTasks.type.add("E");
        showTasks.commandName.add(event);
        showTasks.check.add(showTasks.cross);

    }

}

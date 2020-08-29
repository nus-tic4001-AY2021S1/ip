public class DeadlineTasks extends ShowTasks{

    ShowTasks showTasks = new ShowTasks();

    public DeadlineTasks(){

    }


    public void deadLineTask(String deadLine){

        //job = "[" + cross + "]" + obj1;
        System.out.println("added: " + deadLine);
        showTasks.type.add("E");
        showTasks.commandName.add(deadLine);
        showTasks.check.add(showTasks.cross);

    }
}

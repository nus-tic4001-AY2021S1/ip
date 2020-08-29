public class TodoTasks extends SwitchTasks {


    //SwitchTasks switchTasks = new SwitchTasks();

    ShowTasks showTasks = new ShowTasks();

    public TodoTasks(){

    }



    public void toDoTask(String todo){

        //job = "[" + cross + "]" + obj1;
        System.out.println("added: " + todo);
        showTasks.type.add("T");
        showTasks.commandName.add(todo);
        showTasks.check.add(showTasks.cross);


    }


}

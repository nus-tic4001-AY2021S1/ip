
public class AddTasks {


    private int i;
    private int number;

    ShowTasks showTasks = new ShowTasks();

    public AddTasks(){

        this.i=i;
        this.number=number;
    }

    public void makeDone(String makeDone){

        String clean = makeDone.replaceAll("\\D+","");
        i = Integer.parseInt(clean);
        showTasks.setCheck(i);
    }

    public void toDoTask(String todo){

        System.out.println("added: " + todo);
        showTasks.setType("T");
        showTasks.setCommandName(todo);
        showTasks.setCheck();
    }

    public void eventTask(String event){

        //job = "[" + cross + "]" + obj1;
        System.out.println("added: " + event);
        showTasks.setType("E");
        showTasks.setCommandName(event);
        showTasks.setCheck();
    }

    public void deadLineTask(String deadLine){

        //job = "[" + cross + "]" + obj1;
        System.out.println("added: " + deadLine);
        showTasks.setType("D");
        showTasks.setCommandName(deadLine);
        showTasks.setCheck();
    }

    public void addTime(String obj){

        if(obj.isEmpty()){
            showTasks.setTime("No Time");
        }
        else {
            showTasks.setTime(obj);
        }
    }

    public void showTask(){
        System.out.println("Here are the tasks in your list:");
        number = 1;
        for( i = 0; i < showTasks.getCommandName().size(); i++){

            if (showTasks.getTime().get(i).toString().equals("No Time")) {
                System.out.println( number + "." + "[" + showTasks.getType().get(i) + "]" + "[" + showTasks.getCheck().get(i) + "]" + " " + showTasks.getCommandName().get(i));
            }
            else {
                System.out.println(number + "." + "[" + showTasks.getType().get(i) + "]" +
                        "[" + showTasks.getCheck().get(i) + "]" + " " + showTasks.getCommandName().get(i) + " (" + showTasks.getTime().get(i)+")");

            }
            number++;
        }
    }
}

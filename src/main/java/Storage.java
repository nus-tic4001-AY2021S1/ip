import java.util.ArrayList;

public class Storage {



    private ArrayList commandName;


    public Storage(){

        this.commandName = new ArrayList(100);

    }

    public void setCommandName(Tasks obj){
        commandName.add(obj);
    }

    public void setCommandName(String obj){
       makeDone(obj);
    }

    private void makeDone(String obj){
        String clean = obj.replaceAll("\\D+","");
        int num = Integer.parseInt(clean);
        if (num < commandName.size()){
             int num1=num - 1;
             String makeDone = commandName.get(num1).toString();
             commandName.set(num1,makeDone.replace("✗","✓"));
        }
        else {
            System.out.println("Invalid input");
        }
    }


    public void getCommandName() {
       printTask();
    }

    private void printTask(){
        if(commandName.isEmpty()){
            System.out.println("the database is empty");
        }
        else {
            int number = 1;
            for (Object task : commandName) {

                System.out.println(number + task.toString());

                number ++;
            }
        }
    }
}

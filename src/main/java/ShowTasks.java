import java.util.ArrayList;

public class ShowTasks {


    public ArrayList commandName = new ArrayList(100);
    public ArrayList check = new ArrayList(100);

    public ArrayList type = new ArrayList(100);



    int tick1 = 10003;
    int cross1 = 9587;
    public String tick = Character.toString((char)tick1);
    public String cross = Character.toString((char)cross1);



    public ShowTasks(){

    }
    public void showTasks(){
        System.out.println("Here are the tasks in your list:");
        int number = 1;
        for( int i = 0; i < commandName.size(); i++){
            System.out.println(number +"."+ type.get(i) +"["+check.get(i)+"]"+" "+commandName.get(i));
            number++;
        }

    }



//    public void twoDimension(){
//
//        SwitchTasks switchTasks=new SwitchTasks();
//
//
//        switchTasks.check
//
//
//        String[][] taskArray = new String[100][2];
//
//
//
//
//
//        for(int i = 0; i < 100; i++){
//            taskArray[i][0]=check[i];
//            taskArray[i][0]=commandName[i];
//        }
//
//    }

}

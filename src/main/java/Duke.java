import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        // symbol
        int tick1 = 10003;
        int cross1 = 9587;
        String tick = Character.toString((char)tick1);
        String cross = Character.toString((char)cross1);

        System.out.println(tick);
        System.out.println(cross);





        // creating array
        ArrayList commandName = new ArrayList(100);
        ArrayList check = new ArrayList(100);



        // Welcome msg
        System.out.println("Hello! I'm Duke\nWhat can I do for you?\n");

        // user input
        Scanner myObj = new Scanner(System.in);

        while (myObj.hasNext()) {

           // System.out.println("Added task press 1");
           // System.out.println("Show current task press 2");




            String obj1 = myObj.nextLine();

            if(obj1.equalsIgnoreCase("bye")){
                break;
            }
            else if(obj1.equalsIgnoreCase("list")){
                System.out.println("Here are the tasks in your list:");
                int number = 1;
                for( int i = 0; i < commandName.size(); i++){
                    System.out.println(number +"." +"["+check.get(i)+"]"+" "+commandName.get(i));
                    number++;
                }
            }
            else if(obj1.equalsIgnoreCase("done 2")){

                //remove all characters in the string
                String clean = obj1.replaceAll("\\D+","");
                int i = Integer.parseInt(clean);
                //System.out.println(i);
                check.set(i-1,tick);



            }
            else{

                //job = "[" + cross + "]" + obj1;
                System.out.println("added: " + obj1);
                commandName.add(obj1);
                check.add(cross);
            }
        }


        //Good Bye msg
        System.out.println("Bye. Hope to see you again soon!");


    }
}

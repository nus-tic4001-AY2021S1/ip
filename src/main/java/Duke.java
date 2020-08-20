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


       // creating a array list to store user input cap to 100
        ArrayList commandName = new ArrayList(100);


        // Welcome msg
        System.out.println("Hello! I'm Duke\nWhat can I do for you?\n");

        // user input
        Scanner myObj = new Scanner(System.in);

        while (myObj.hasNext()) {

            String obj1 = myObj.nextLine();

            if(obj1.equalsIgnoreCase("bye")){
                break;
            }
            else if(obj1.equalsIgnoreCase("list")){
                int number = 1;
                for( int i = 0; i < commandName.size(); i++){
                    System.out.println(number + "."+" "+commandName.get(i));
                    number++;
                }
            }
            else{
                System.out.println("added: " + obj1);
                commandName.add(obj1);
            }
        }

        
        //Good Bye msg
        System.out.println("Bye. Hope to see you again soon!");


    }
}

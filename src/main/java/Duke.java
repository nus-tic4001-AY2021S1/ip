import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) throws IOException {

        ArrayList<Task> taskList = new ArrayList<Task>();

        System.out.println("Hello! I'm Duke\n" );
        System.out.println("What can I do for you?\n" );

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String textInput = reader.readLine();

        while(!textInput.equals("bye")) {

            String[]arrayOfStr=textInput.split(" ",2);

            if (textInput.equals("list")) {
                //System.out.println(taskList);
                for (int i = 0; i < taskList.size();i++)
                {
                    System.out.println(i+1 + taskList.get(i).toString());
                }
            }
            else if(arrayOfStr[0].equals("done")){
                int index=Integer.parseInt(arrayOfStr[1])-1;
                taskList.get(index).markAsDone();
                System.out.println("Nice! I've marked this task as done: "+ "[" +taskList.get(index).getStatusIcon() +"] "  +taskList.get(index).toString());
            }
            else if(arrayOfStr[0].equals("deadline")){
                String[]arrayOfDoneDetails=arrayOfStr[1].split("by ",2);
                Task t=new Deadline(arrayOfDoneDetails[0],arrayOfDoneDetails[1] );
                taskList.add((t));
                System.out.println("Got it. I've added this task: \n" + t.toString());
                System.out.println("Now you have " + taskList.size()+ " tasks in the list");
            }
            else if(arrayOfStr[0].equals("event")){
                String[]arrayOfDoneDetails=arrayOfStr[1].split("at ",2);
                //arrayOfDoneDetails[0] contains description, arrayOfDoneDetails[1] contains the date.
                //System.out.println("by: " + arrayOfDoneStr[1]);
                Task t=new Event(arrayOfDoneDetails[0],arrayOfDoneDetails[1] );
                taskList.add((t));
                System.out.println("Got it. I've added this task: \n" + t.toString());
                System.out.println("Now you have " + taskList.size()+ " tasks in the list");
            }
            else if(arrayOfStr[0].equals("todo")){

                Task t=new Todo(arrayOfStr[1]);
                taskList.add((t));
                System.out.println("Got it. I've added this task: \n" + t.toString());
                System.out.println("Now you have " + taskList.size()+ " tasks in the list");
            }
            else {
                Task t=new Task(textInput);
                taskList.add((t));
                System.out.println("added: " + t.toString());
            }
            textInput = reader.readLine();
        }

        System.out.println(" Bye.Hope to see you again soon!\n" );






    }
}

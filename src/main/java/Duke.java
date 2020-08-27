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
                    System.out.println(i+1 + ". "+ "[" +taskList.get(i).getStatusIcon() +"] "  +taskList.get(i).getDescription());
                }
            }
            else if(arrayOfStr[0].equals("done")){
                //System.out.println("Done detected");
                int index=Integer.parseInt(arrayOfStr[1])-1;
                taskList.get(index).markAsDone();
                System.out.println("Nice! I've marked this task as done: "+ "[" +taskList.get(index).getStatusIcon() +"] "  +taskList.get(index).getDescription());


            }
            else {
                Task t=new Task(textInput);
                taskList.add((t));
                System.out.println("added: " + t.getDescription());
            }
            textInput = reader.readLine();
        }

        System.out.println(" Bye.Hope to see you again soon!\n" );






    }
}

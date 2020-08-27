import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) throws IOException {

        ArrayList<String> taskList = new ArrayList<String>();

        System.out.println("Hello! I'm Duke\n" );
        System.out.println("What can I do for you?\n" );

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String textInput = reader.readLine();

        while(!textInput.equals("bye")) {

            if (textInput.equals("list")) {
                //System.out.println(taskList);
                for (int i = 0; i < taskList.size();i++)
                {
                    System.out.println(i+1 + ". " +taskList.get(i));
                }
            }
            else {
                taskList.add((textInput));
                System.out.println("added: " + textInput);
            }
            textInput = reader.readLine();
        }

        System.out.println(" Bye.Hope to see you again soon!\n" );






    }
}

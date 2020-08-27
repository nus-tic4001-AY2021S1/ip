import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Duke {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello! I'm Duke\n" );
        System.out.println("What can I do for you?\n" );

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String textInput = reader.readLine();

        while(!textInput.equals("bye")){
            System.out.println(textInput);
            textInput = reader.readLine();
        }
        System.out.println(" Bye.Hope to see you again soon!\n" );






    }
}

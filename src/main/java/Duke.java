import java.util.*;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        String line = "\t_____________________________________________\n";

        String greetings = line + "\t Hello! I'm Duke\n"
                + "\t What can I do for you?\n" + line;

        String closing = line + "\t Bye. Hope to see you again soon!\n" + line;

        String input;
        Scanner sc = new Scanner(System.in);

        //Greet
        System.out.println(greetings);

        //Echo & Exit
        do{
            input = sc.nextLine();
            if (input.equals("bye")){
                System.out.println(closing);
                break;
            }
            else {
                System.out.println(line + "\t" + input + "\n" + line);
            }
        } while(sc.hasNext());
    }
}

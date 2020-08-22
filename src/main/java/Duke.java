import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String hello = " Hello! I'm Duke\n" +
                " What can I do for you?";

        String bye = " Bye. Hope to see you again soon!";
        System.out.println("________________________________________________________");
        System.out.println(hello);
        System.out.println("________________________________________________________");

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while(true){
            String input = scanner.nextLine();

            try {
                if (input.equalsIgnoreCase("bye")) {
                    break;
                } else if (input.equalsIgnoreCase("list")) {
                    System.out.println("Here are the tasks in your list:");
                    int i = 1;
                    for (Task s : tasks) {
                        System.out.println(i + "." + s.getSymbol() + " " + s.getTaskDescription());
                        i++;
                    }
                } else if (input.substring(0, 4).equalsIgnoreCase("done")) {
                    int index = Integer.parseInt(input.split(" ")[1]);
                    tasks.get(index - 1).setDone(true);
                    System.out.println("Nice! I've marked this task as done: ");
                    System.out.println(tasks.get(index - 1).getSymbol() + " " + tasks.get(index - 1).getTaskDescription());
                } else {
                    tasks.add(new Task(input));
                    System.out.println("added: " + input);
                }
            }catch(Exception e){
                System.out.println("Internal error occurs,please re-enter the command.");
                continue;
            }
            System.out.println("________________________________________________________");
        }

        System.out.println("________________________________________________________");
        System.out.println(bye);
        System.out.println("________________________________________________________");

    }
}

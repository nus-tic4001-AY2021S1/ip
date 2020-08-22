import java.util.Scanner;

public class Ui {
    private Scanner in= new Scanner(System.in);
    public void greetInfo() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }
    public void exitInfo(){
        System.out.println("----------------\n"+"Bye. Hope to see you again soon!");
    }
    public String getInput(Scanner in) {
        return in.nextLine().trim();
    }

}

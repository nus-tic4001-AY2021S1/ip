import java.util.Scanner;

public class Ui {

    public void printLine(){
        System.out.println("____________________________________________________________");
    }

    public void printWord(String toPrint){
        System.out.println(" "+toPrint);
    }

    public void printLogo(){
        String logo = "  __          __ \n"
                + "  | | ____    | | ____\n"
                + "  | |/ __ \\   | |/ __ \\\n"
                + "__/ | |__| |__/ | |__| |\n"
                + "\\__/ \\____/ \\__/ \\____/\n";
        System.out.println("Hello from\n" + logo);
    }

    public void greetUser(){
        printLine();
        printWord("Hi! I'm Jojo");
        printWord("What can I do for you?");
        printLine();
    }

    public void farewellUser(){
        printLine();
        printWord("Bye. Have a nice day!");
        printLine();
    }

    public void printError() {
        System.out.println("Unknown command! please try again.");
    }

    private final Scanner in = new Scanner(System.in);

    public String readCommand(){
        String command=in.nextLine().trim();
        return command.toLowerCase();
    }

    public void printError(String message) {
        System.out.println(message);
    }
}

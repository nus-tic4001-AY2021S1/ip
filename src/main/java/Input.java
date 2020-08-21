import java.util.Scanner;

public class Input {
    public String  echoInput(){
        Scanner scanner = new Scanner(System.in);
        String ui = scanner.nextLine();
        return ui;
    }
}

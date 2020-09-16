package Duke;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Duke {
    private TaskList tasks;
    public Parser paser;
    public Ui ui;
    private Storage storage;
    public Duke(String path){
        ui = new Ui();
        storage = new Storage(path);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (DukeException e) {
            ui.printError(e);
            tasks = new TaskList();
        }
    }
    public void run(){
        paser = new Parser(ui,tasks);
        ui.printLogo();
        ui.greetMessage();
        Scanner in = new Scanner(System.in);
        String str = "";

        while (!str.equals("bye") ) {
            try {
                str = ui.getInput(in);
                paser.handleCommands(str);
                storage.saveToFile(tasks);
            }catch (DukeException e){
                ui.printError(e);
            }

        }
    }
    public static void main(String[] args) {

         new Duke("/Users/chenduo/Desktop/ip/Duke.txt").run();
        /*
        LocalDate d1 = LocalDate.parse("2019-12-01");
        LocalDate d2 = LocalDate.parse("2019-12-02");
        LocalDate d3 = LocalDate.parse("2019-12-02");


        System.out.println(d1.isBefore(d2)); // -> true
        System.out.println(d1.isAfter(d2)); // -> false
        System.out.println(d2.equals(d3)); // -> true


        System.out.println(d1.getDayOfWeek()); // -> SUNDAY
        System.out.println(d1.getMonth()); // -> DECEMBER
        System.out.println(d1.plus(1, ChronoUnit.YEARS));  // -> 2020-12-01


        LocalDate d4 = LocalDate.now();
        System.out.println(d4); // -> 2019-10-15
        System.out.println(d4.format(DateTimeFormatter.ofPattern("MMM d yyyy"))); // -> Oct 15 2019
      */
    }

}

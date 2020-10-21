package Duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Duke {

    private TaskList tasks;
    public Parser paser;
    public Ui ui;
    private Storage storage;
    private String filename;

    public Duke(String path){
        ui = new Ui();
        try {
            createDirectory();
        }catch(DukeException e) {
            ui.printError(e);
        }

        this.filename=path;

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

    public void createDirectory() throws DukeException {
        try {
            Path path = Paths.get("data/");
            if (!(Files.exists(path))) {
                Files.createDirectory(path);
                Files.createFile(Paths.get("data/Duke.txt"));
                System.out.println("creating...");
            }else System.out.println("exist...");
        } catch (IOException e) {
            throw new DukeException("I have problem creating the save directory!");
        }
    }


    public static void main(String[] args) {
        Duke d = new Duke("data/Duke.txt");
        d.run();
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
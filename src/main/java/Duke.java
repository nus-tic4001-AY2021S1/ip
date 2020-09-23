import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Duke {
    private Ui ui;
    private Storage storage;
    private Parser parser;
    private TaskList taskList;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        parser = new Parser();
        taskList = storage.load();
    }

    public void run() {
        ui.printGreetings();
        while(!ui.getIsExit()) {
            String fullCommand = ui.readCommand();
            ui.printLine(); // show the divider line ("_______")
            parser.execute(fullCommand, ui, storage, taskList);
            ui.printLine();
        }
    }

    public static void main(String[] args) {
        String dir = System.getProperty("user.dir");
        checkFolder(dir);
        checkTextFile(dir);
        new Duke(dir+"/data/duke.txt").run();
    }

    public static void checkFolder(String dir){
        //check if folder exists
        java.nio.file.Path checkFolderPath = java.nio.file.Paths.get(dir+"/data");
        boolean folderExists = java.nio.file.Files.exists(checkFolderPath);
        //folder not exists, create one
        if(!folderExists) {
            new File(dir+"/data").mkdirs();
        }
    }

    public static void checkTextFile(String dir){
        //check if text file exists
        java.nio.file.Path checkFilePath = java.nio.file.Paths.get(dir+"/data/duke.txt");
        boolean fileExists = java.nio.file.Files.exists(checkFilePath);
        //text file not exists, create one
        if(!fileExists) {
            try {
                File dukeFile = new File(dir+"/data/duke.txt");
                dukeFile.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred while creating file.");
                e.printStackTrace();
            }
        }
    }
}


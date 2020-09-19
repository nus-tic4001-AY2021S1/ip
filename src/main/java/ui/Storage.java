package ui;

import duke.DukeException;
import duke.Task;
import duke.ToDos;
import duke.Deadlines;
import duke.Events;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * This class in charge of memory side, where Task  will read from or write to the txt File
 * File Path is a fixed Path, file address is passed from main class.
 */
public class Storage {

    private static String FILEPATH;

    public Storage(String filePath) {
        this.FILEPATH = filePath;
    }

    public static void createFile() throws IOException, DukeException {
        File f = new File (FILEPATH);
        boolean result = f.createNewFile();
        if(!result) {
            throw new DukeException("File Not Found");
        }
    }

    /**
     * This method append Task List to File, to be called whenever new tasks was entered
     */
    public static void addToFile(ArrayList<Task> tasks) throws IOException{

        FileWriter fw = new FileWriter(FILEPATH, true);
        int index = tasks.size();
        fw.write(String.valueOf(tasks.get(index-1))+ "\n");
        fw.close();
    }

    /**
     * This method update the current Task List to File before the program terminate
     */
    public static void writeToFile(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(FILEPATH, false);
        for(int i = 0; i < tasks.size(); i++) {
            fw.write(String.valueOf(tasks.get(i)+ "\n"));
        }
        fw.close();
    }

    /**
     * This method is updating task status to the file.
     * This method is called whenever user change the status of the task
     */
    public static void updateStatusToFile(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(FILEPATH);
        for (int i = 0; i < tasks.size(); i++) {
            fw.write(String.valueOf(tasks.get(i)) + "\n");
        }
        fw.close();
    }

    //public static void load (ArrayList<Task> tasks) throws IOException {
    public static ArrayList<Task> load () throws IOException, DukeException  {


        File fw = new File(FILEPATH);
        if (! fw.exists()) {
            throw new DukeException("File Not Found");
        }

        Scanner s = new Scanner(fw);
        ArrayList<Task> tasks = new ArrayList<>();
        int count = 0;

        while (s.hasNextLine()) {
            String item = s.nextLine();
            if (item.startsWith("[T")) {
                addTodosToArray(tasks, item, count);
            } else if (item.startsWith("[D")) {
                addDeadlinesToArray(tasks, item, count);
            } else {
                addEventsToArray(tasks, item, count);
            }
            count ++;
        }

        return tasks;
    }

    private static void addTodosToArray (ArrayList<Task> tasks, String line, int ArrIndex) {
        String status = line.substring(4,5);
        String taskName = line.substring(7);
        tasks.add(new ToDos (taskName));
        if(status.equals("\u2713") ) {
            tasks.get(ArrIndex).markAsDone();
        }
    }

    private static void addDeadlinesToArray(ArrayList<Task> tasks, String line, int ArrIndex) {
        int index = line.indexOf("(by");
        String schedule = line.substring(index + 4);
        String taskName = line.substring(7, index);
        String status = line.substring(4,5);
        tasks.add(new Deadlines(taskName, schedule));
        if(status.equals("\u2713") ) {
            tasks.get(ArrIndex).markAsDone();
        }
    }

    private static void addEventsToArray (ArrayList <Task> tasks, String line, int ArrIndex) {
        int index = line.indexOf("(at");
        String status = line.substring(4,5);
        String schedule = line.substring(index + 4);
        String taskName = line.substring(line.indexOf(" ")+1, index);
        tasks.add(new Events(taskName, schedule));
        if(status.equals("\u2713") ) {
            tasks.get(ArrIndex).markAsDone();
        }

    }
}

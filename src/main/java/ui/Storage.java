package ui;

import duke.Deadlines;
import duke.DukeException;
import duke.Events;
import duke.RecurrTask;
import duke.Task;
import duke.ToDos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * This class in charge of memory side, where Task  will read from or write to the txt File.
 * File Path is a fixed Path, file address is passed from main class.
 */
public class Storage {

    private static String FILEPATH;

    public Storage(String filePath) {
        FILEPATH = filePath;
    }

    public static void createFile() throws IOException, DukeException {
        File f = new File("ip/data/record.txt");
        boolean result = f.createNewFile();
        if (!result) {
            throw new DukeException("File Not Found");
        }
    }

    /**
     * This method append Task List to File, to be called whenever new tasks was entered.
     */
    public static void addToFile(ArrayList<Task> tasks) throws IOException {

        FileWriter fw = new FileWriter(FILEPATH, true);
        int index = tasks.size();
        fw.write(tasks.get(index - 1) + "\n");
        fw.close();
    }

    /**
     * This method update the current Task List to File before the program terminate.
     */
    public static void writeToFile(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(FILEPATH, false);
        for (Task task : tasks) {
            fw.write(task + "\n");
        }
        fw.close();
    }

    /**
     * This method is updating task status to the file.
     * This method is called whenever user change the status of the task
     */
    public static void updateStatusToFile(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(FILEPATH);
        for (Task task : tasks) {
            //fw.write(String.valueOf(tasks.get(i)) + "\n");
            fw.write(task + "\n");
        }
        fw.close();
    }

    public static ArrayList<Task> load() throws IOException, DukeException  {

        File fw = new File(FILEPATH);
        if (! fw.exists()) {
            createFile();
            //throw new DukeException("File Not Found");
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
            } else if (item.startsWith("[E")) {
                addEventsToArray(tasks, item, count);
            } else {
                addRecurrTaskToArray(tasks, item, count);
            }
            count++;
        }

        return tasks;
    }

    private static void addTodosToArray(ArrayList<Task> tasks, String line, int arrIndex) {
        String status = line.substring(4,5);
        String taskName = line.substring(7);
        tasks.add(new ToDos(taskName));
        if (status.equals("✓")) {
            tasks.get(arrIndex).markAsDone();
        }
    }

    private static void addDeadlinesToArray(ArrayList<Task> tasks, String line, int arrIndex) {
        int index = line.indexOf("(by");
        int indexCB = line.indexOf(")", index);
        int timeStamp = indexCB - index;

        String status = line.substring(4,5);
        String taskName = line.substring(7, index - 1);

        if (line.contains("(Memos :") && (timeStamp > 16)) { //with time and memos
            int indexM = line.indexOf("(Memos");
            int indexS = line.indexOf(" ", index + 15);
            String memo = line.substring(indexM + 9, line.length() - 1);
            String tschedule = line.substring(indexS + 1, indexM - 2);
            LocalTime timeline = LocalTime.parse(tschedule);
            String schedule = line.substring(index + 5, indexS);
            LocalDate dateline = LocalDate.parse(schedule, DateTimeFormatter.ofPattern("MMM d yyyy"));
            tasks.add(new Deadlines(taskName, dateline,timeline, memo));
        }  else if (timeStamp > 16) {   //with time
            int indexS = line.indexOf(" ", index + 15);
            String schedule = line.substring(index + 5, line.indexOf(" ", index + 15));
            LocalDate dateline = LocalDate.parse(schedule, DateTimeFormatter.ofPattern("MMM d yyyy"));
            String tschedule = line.substring(indexS + 1, line.length() - 1);
            LocalTime timeline = LocalTime.parse(tschedule);
            tasks.add(new Deadlines(taskName, dateline,timeline));
        } else if (line.contains("(Memos :")) { //with only memos
            int indexM = line.indexOf("(Memos");
            String memo = line.substring(indexM + 9, line.length() - 1);
            String schedule = line.substring(index + 5, line.indexOf(")", index + 15));
            LocalDate dateline = LocalDate.parse(schedule, DateTimeFormatter.ofPattern("MMM d yyyy"));
            tasks.add(new Deadlines(taskName, dateline, memo));
        } else { //with nothing
            String schedule = line.substring(index + 5, line.indexOf(")", index + 15));
            LocalDate dateline = LocalDate.parse(schedule, DateTimeFormatter.ofPattern("MMM d yyyy"));
            tasks.add(new Deadlines(taskName, dateline));
        }

        if (status.equals("✓")) {
            tasks.get(arrIndex).markAsDone();
        }
    }

    private static void addEventsToArray(ArrayList<Task> tasks, String line, int arrIndex) {
        int index = line.indexOf("(at");
        String status = line.substring(4,5);
        String schedule = line.substring(index + 5, line.length() - 1);
        String taskName = line.substring(line.indexOf(" ") + 1, index - 1);
        tasks.add(new Events(taskName, schedule));
        if (status.equals("✓")) {
            tasks.get(arrIndex).markAsDone();
        }
    }

    private static void addRecurrTaskToArray(ArrayList<Task> tasks, String line, int arrIndex) {
        int index = line.indexOf(" ");
        String taskType = line.substring(0, index);
        String taskName = line.substring(index + 3);
        tasks.add(new RecurrTask(taskName, taskType));
    }
}

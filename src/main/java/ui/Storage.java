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
        this.FILEPATH = filePath;
    }

    public static void createFile() throws IOException, DukeException {
        File f = new File("ip/record.txt");
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
        fw.write(String.valueOf(tasks.get(index - 1)) + "\n");
        fw.close();
    }

    /**
     * This method update the current Task List to File before the program terminate.
     */
    public static void writeToFile(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(FILEPATH, false);
        for (int i = 0; i < tasks.size(); i++) {
            fw.write(String.valueOf(tasks.get(i) + "\n"));
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

    @SuppressWarnings("checkstyle:ParameterName")
    private static void addTodosToArray(ArrayList<Task> tasks, String line, int arrIndex) {
        String status = line.substring(4,5);
        String taskName = line.substring(7);
        tasks.add(new ToDos(taskName));
        if (status.equals("✓")) {
            tasks.get(arrIndex).markAsDone();
        }
    }

    @SuppressWarnings("checkstyle:ParameterName")
    private static void addDeadlinesToArray(ArrayList<Task> tasks, String line, int arrIndex) {
        int index = line.indexOf("(by");
        String taskName = line.substring(7, index - 1);
        String status = line.substring(4,5);
        String tschedule = line.substring(line.length() - 6, line.length() - 1);

        if (tschedule.contains(":")) {

            String schedule = line.substring(index + 5, line.length() - 7);
            LocalDate dateline = LocalDate.parse(schedule, DateTimeFormatter.ofPattern("MMM d yyyy"));
            LocalTime timeline = LocalTime.parse(tschedule);
            tasks.add(new Deadlines(taskName, dateline,timeline));

        } else {

            String schedule = line.substring(index + 5, line.length() - 1);
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
        String schedule = line.substring(index + 4, line.length() - 1);
        String taskName = line.substring(line.indexOf(" ") + 1, index);
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

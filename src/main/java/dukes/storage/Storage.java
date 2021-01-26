package dukes.storage;

import dukes.tasks.Deadline;
import dukes.tasks.Event;
import dukes.tasks.Task;
import dukes.tasks.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a storage in the hard disk.
 */
public class Storage {
    private ArrayList<String> details = new ArrayList<>();
    public static String path = "data/duke.txt";

    public Storage(String path) {
        this.path = path;
    }

    public ArrayList<String> load() throws dukes.exception.FileNotFoundException {
        try {
            File file = new File(path);
            file.createNewFile();
            Scanner in = new Scanner(file);
            while (in.hasNext()) {
                String input = in.nextLine();
                String[] strArr = input.split(" \\| ");
                Task tasks;
                if (strArr[0].equals("T")) {
                    tasks = new ToDo(strArr[2]);
                } else if (strArr[0].equals("D")) {
                    tasks = new Deadline(strArr[2], strArr[3]);
                } else if (strArr[0].equals("E")) {
                    tasks = new Event(strArr[2], strArr[3]);
                } else {
                    throw new dukes.exception.FileNotFoundException("Previous Tasks are corrupted."
                            + "Please resetting your task.");
                }
                if (strArr[1].equals("1")) {
                    tasks.markAsDone();
                }
                details.add(input);
            }
        } catch (FileNotFoundException e) {
            System.out.println("You have no task.");
        } catch (IOException e) {
            System.out.println("Problem occurred while creating a new file in Storage");
            assert (false);
        }
        return details;
    }


    public void saveTaskFile(ArrayList<Task> task) {
        try {
            FileWriter fw = new FileWriter("data/duke.txt");
            String fileDetails = "";
            for (Task t : task) {
                fileDetails += t.toWriteFile() + "\n";
            }
            fw.write(fileDetails);
            fw.close();
        } catch (IOException e) {
            System.out.println("FileWriting got problem");
        }
    }
}


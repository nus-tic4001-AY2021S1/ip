package duke.storage;

import duke.reminder.SendEmail;
import duke.tasks.Tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;


/**
 * This is a storage class and file read and write. All data will be handle down here.
 */
public class Storage {

    private String filePath;
    private ArrayList commandName;

    public Storage(String filePath, ArrayList commandName) {
        this.commandName = commandName;
        this.filePath = filePath;
    }

    public void setCommandName(Tasks obj) {
        commandName.add(obj);
    }

    public void setCommandName(String obj) {
        commandName.add(obj);
    }


    public ArrayList getCommandName() {
        return commandName;
    }

    // fild checker, check whether the file is create or not
    private void fileChecker() {
        try {
            File myObj = new File(filePath);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    // save the tasks into the txt file
    public void saveToFile(ArrayList commandName) {
        try {
            fileChecker();
            FileWriter myWriter = new FileWriter(filePath, false);
            for (Object task : commandName) {
                //System.out.println(task.toString());
                String obj = task.toString().replace("]", "|").replace("[", "")
                        .replace("x", "0").replace("c", "1");
                myWriter.write(obj + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("File does not exist.");
            e.printStackTrace();
        }
    }


    // read the task from the current file on the system
    public void readFromFile() {
        try {
            fileChecker();
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                divider(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
            e.printStackTrace();
        }
    }

    // convert the data from file into wanted form.
    private void divider(String data) {
        String[] words = data.split("\\|");
        String word0 = words[0];
        String word1 = words[1];
        if (word1.equals("0")) {
            word1 = "x";
        } else {
            word1 = "c";
        }
        String word2 = words[2];
        String word3 = words[3];
        String word4 = words[4];
        data = "[" + word0 + "]" + "[" + word1 + "]" + word2 + "|" + word3 + "|" + word4;
        if (diff(word3) <= 7) {
            new SendEmail(word3.trim(), data);
        }
        commandName.add(data);
    }

    public int diff(String time) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hhmm", Locale.ENGLISH);
        String dateInString = time;
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long mill1 = date.getTime();
        Date today = Calendar.getInstance().getTime();
        long mill2 = today.getTime();
        int days = 0;
        if (mill2 < mill1) {
            long diff = mill1 - mill2;
            days = (int) (diff / (1000 * 60 * 60 * 24));
        }
        return days;
    }


}

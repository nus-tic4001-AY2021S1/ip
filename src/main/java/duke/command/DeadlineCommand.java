package duke.command;

import duke.storage.Storage;
import duke.ui.Ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * A command to create a Deadline.
 */

public class DeadlineCommand extends Command {

    public static final String word = "--deadline";

    public DeadlineCommand(String line, Ui ui, Storage storage, ArrayList commandName) {
        super(line, ui, storage, commandName);
    }

    @Override
    public String execute() {

        ArrayList<String> newProject = new ArrayList<>();
        newProject.add("description");
        newProject.add("date");
        newProject.add("email");


        String[] splits = line.split("--");
        boolean hasMistake = false;
        String error = "";


        for (String command : newProject) {
            if (!line.contains("--" + command)) {
                error = error.concat("The command line is missing for --" + command + "\n");
                hasMistake = true;
            }
        }
        if (hasMistake) {
            return error + "Please create the project in the correct format:\n"
                    + "--todo --description INPUT --date dd/MM/yyyy hhmm --email INPUT";
        }
        String description = "";
        String date = "";
        String email = "";

        for (int num = 1; num < splits.length; num++) {
            if (splits[num].contains("description")) {
                String[] arr = splits[num].split(" ", 2);
                description = arr[1];
            }
            if (splits[num].contains("date")) {
                String[] arr = splits[num].split(" ", 2);
                if (timeChecker(arr[1])) {
                    date = arr[1];
                } else {
                    return "<<Invalid Date Format>>";
                }
            }
            if (splits[num].contains("email")) {
                String[] arr = splits[num].split(" ", 2);
                if (!(arr[1].matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))) {
                    return "<<Invalid Email Format>>";
                } else {
                    email = arr[1];
                }
            }
        }

        commandName.add(new duke.tasks.Deadline(description, date, email));
        return ui.description(line);
    }

    public boolean timeChecker(String time) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hhmm", Locale.ENGLISH);
        String dateInString = time;
        try {
            Date date = formatter.parse(dateInString);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}

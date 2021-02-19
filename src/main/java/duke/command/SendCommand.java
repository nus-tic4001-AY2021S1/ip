package duke.command;

import duke.reminder.SendEmail;
import duke.storage.Storage;
import duke.ui.Ui;

import java.util.ArrayList;

/**
 * A command to send a email to user.
 */
public class SendCommand extends Command {

    public static final String word = "--send";

    public SendCommand(String line, Ui ui, Storage storage, ArrayList commandName) {
        super(line, ui, storage, commandName);
    }

    @Override
    public String execute() {

        try {

            String[] obj = line.split(" ", 2);

            if (commandName.isEmpty()) {
                return "<<No data in the database>>";
            } else {
                String clean = obj[1].replaceAll("\\D+", "");
                int num = Integer.parseInt(clean);

                String[] data = commandName.get(num).toString().split("\\|");
                String email = data[3].trim();
                new SendEmail(email, ui.dataConverter(commandName.get(num).toString()));
                return "Email has been send";
            }

        } catch (NumberFormatException ex) {
            return "<<Please enter a numeric input>>";
        }

    }
}

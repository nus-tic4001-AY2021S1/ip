package Dukes.Tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * deadline task description /by deadline description: add to the task list a deadline task with the given task
 * description and with the deadline description
 *
 * @inheritDoc

 */
public class Deadline extends Task {
    protected String by;


    public Deadline(String description, String by) {
        super(description);
        this.by= by;
    }


    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by:" + by  + ")";
    }

    @Override
    public String toWriteFile() {
        return "D | " + getFileStatusIcon() + " | " + description + " | " + by;

    }
}


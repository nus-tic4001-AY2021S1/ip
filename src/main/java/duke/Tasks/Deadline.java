package duke.Tasks;// Organize the classes into suitable duke.Tasks packages.

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This Deadline class extends from task object.
 *
 * @author Dai Wei
 * @version Finial version 2020.9.9
 * @since Duke javadoc
 */
public class Deadline extends Task {

    protected String by;

    /**
     *convert data string to except format
     *
     * @param startDate data/time string with yyyy-MM-dd format
     * @return  data/time string with MMM d yyyy format
     */
    public String getStartDate(String startDate)
    {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MMM d yyyy");

        return LocalDate.parse(startDate, inputFormat).format(outputFormat);
    }

    /**
     * entity deadline.
     *
     * @param description tasks' description
     * @param by          tasks' deadline time
     */
    public Deadline(String description, String by) {
        super(description);
        //this.by = by;
        this.by =  getStartDate(by);
    }

    /**
     * get user command description of by
     *
     * @return by
     */
    public String getBy() {
        return by;
    }

    /**
     * override the to string method
     *
     * @return user command Deadline to "[D]"
     */
    @Override
    public String toString() {
        return "[D]" + super.printDescription() + " (by: " + by + ")";
    }
}

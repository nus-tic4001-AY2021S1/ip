package duke.Tasks;// Organize the classes into suitable duke.Tasks packages.

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
     * entity deadline.
     *
     * @param description tasks' description
     * @param by          tasks' deadline time
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
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

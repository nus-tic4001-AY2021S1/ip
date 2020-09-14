package duke.Tasks;


/**
 * This Event class extends from task object.
 *
 * @author Dai Wei
 * @version Finial version 2020.9.9
 * @since Duke javadoc
 */
public class Event extends Task {
    protected String at;

    /**
     * entity Event.
     *
     * @param description tasks' description
     * @param at          tasks' event time
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * get user command description of at
     *
     * @return at
     */
    public String getAt() {
        return at;
    }

    /**
     * override the to string method
     *
     * @return user event Deadline to "[E]"
     */
    @Override
    public String toString() {
        return "[E]" + super.printDescription() + " (at: " + at + ")";
    }
}
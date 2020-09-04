package duke.Tasks;// Organize the classes into suitable duke.Tasks packages.

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

    @Override
    public String toString() {
        return "[D]" + super.printDescription() + " (by: " + by + ")";
    }
}

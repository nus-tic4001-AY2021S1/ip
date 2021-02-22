package data;

public class Deadline extends Todo {

    private String deadLine;

    /**
     * Deadline constructor.
     * @param description
     * @param deadLine
     */
    public Deadline(String description, String deadLine) {
        super(description);
        this.deadLine = deadLine;
    }

    public String getDeadLine() {
        return this.deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public String toString() {
        return String.format(super.toString() + " (by: " + this.getDeadLine() + ")");
    }

    @Override
    public String save() {
        return "D" + " | " + (this.isDone() ? 1 : 0) + " | " + getDescription().trim()
                + " | " + this.getDeadLine().trim() + System.lineSeparator();
    }
}

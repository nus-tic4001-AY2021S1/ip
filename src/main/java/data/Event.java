package data;

public class Event extends Todo {
    private String schedule;

    /**
     * Event constructor.
     * @param description
     * @param schedule
     */
    public Event(String description, String schedule) {
        super(description);
        this.schedule = schedule;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public String toString() {
        return String.format(super.toString() + " (at: " + this.getSchedule() + ")");
    }

    @Override
    public String save() {
        return "E" + " | " + (this.isDone() ? 1 : 0) + " | " + this.getDescription().trim()
                + " | " + this.getSchedule().trim() + System.lineSeparator();
    }
}

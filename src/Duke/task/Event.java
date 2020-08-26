package Duke.task;

public class Event extends Todo {
    private String schedule;

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
}

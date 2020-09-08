package duke.Tasks;

// using Inheritance to task class
public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.printDescription();
    }
}
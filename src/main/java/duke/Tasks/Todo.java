package duke.Tasks;


/**
 * This class extends from task object.
 *
 * @author Dai Wei
 * @version Finial version 2020.9.9
 * @since Duke javadoc
 */
public class Todo extends Task {
    /**
     * entity Todo.
     *
     * @param description users' tasks' description
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * override the to string method
     *
     * @return user command todo to "[T]"
     */
    @Override
    public String toString() {
        return "[T]" + super.printDescription();
    }
}
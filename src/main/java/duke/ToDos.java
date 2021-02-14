package duke;

import java.time.LocalDate;

public class ToDos extends Task {

    //protected String by;
    protected String memo;

    public ToDos(String description) {
        super(description);
    }

    public ToDos(String description, String memo) {
        super(description);
        this.memo = memo;
    }

    @Override
    public String toString() {
        //return "[T]" + super.toString() ;
        if (memo != null) {
            return "[T]" + "[" + this.getStatusIcon() + "] " +  this.description
                    + "(Memos : " + this.memo + ")";
        } else {
            return "[T]" + "[" + this.getStatusIcon() + "] " +  this.description;
        }

    }

}

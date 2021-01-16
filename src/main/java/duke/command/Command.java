package duke.command;

public abstract class Command {
    protected String type;
    protected String content;

    public String getCmdContent() {
        return content;
    }

    public String getCmdType() {
        return type;
    }
}

package Command;

public abstract class Command {
    protected String type;
    protected String content;

    public String getCommandContent() {
        return content;
    }

    public String getCommandType(){
        return type;
    }
}

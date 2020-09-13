package Duke.Command;

public abstract class Command {
    protected String type;
    protected String content;

    public String getCMDContent(){
        return content;
    }

    public String getCMDType(){
        return type;
    }
}

import java.util.ArrayList;

public class Storage {
    private boolean isExit;
    Storage(){
        isExit = false;
    }
    public void toExit(){
        isExit=true;
    }
    public boolean getIsExit(){
        return isExit;
    }
}

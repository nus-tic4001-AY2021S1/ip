public class ProgramExit {
    private boolean isExit;

    ProgramExit() {
        isExit = false;

    }

    public void toExit() {
        isExit = true;
    }

    public boolean getIsExit() {
        return isExit;
    }


}

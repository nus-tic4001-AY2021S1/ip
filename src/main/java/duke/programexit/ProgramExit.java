package duke.programexit;

public class ProgramExit {
    // A boolean value, if true: Exit the program, otherwise false.
    private boolean isExit;

    /** .
     * Creating an object of ProgramExit class
     * set the default Exit as false
     */
    public ProgramExit() {
        isExit = false;
    }

    /** .
     * A method to set the Exit as true
     */
    public void toExit() {
        isExit = true;
    }

    /** .
     * A method to return the Exit status
     */
    public boolean getIsExit() {
        return isExit;
    }


}

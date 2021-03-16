package duke.ui;


/** .
 * Ui: deals with interactions with the user
 */
public class Ui {


    /** .
     * This method will display line on standard output (terminal)
     */
    public static void printLine() {
        System.out.println("_________________________________________");

    }

    /** .
     * This method will display welcome message to user on standard output (terminal)
     */

    public static void sayWelcome() {
        printLine();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        printLine();
    }

    /** .
     * This method will display greeting message to user
     *
     */

    public String greetMessage() {
        return "Hello! I'm Duke.\nWhat can I do for you?";
    }

    /** .
     * This method will display any message to user on standard output (terminal)
     *
     * @param message A String which contains the message we will show to user
     */

    public static void showMessage(String message) {
        System.out.println(message);
    }



}

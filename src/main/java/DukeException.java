public class DukeException extends Exception {
    DukeException(String s) {
        super(s);
        System.out.println(Global.PATTERNLINE);
    }
}

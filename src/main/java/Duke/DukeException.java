package Duke;

class DukeException extends Exception {
    public DukeException(String message) {
        //branch out
        super("OOPS!!! " + message);
    }
}
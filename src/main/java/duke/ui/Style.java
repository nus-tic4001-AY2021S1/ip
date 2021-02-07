package duke.ui;
/**
 * Defines the style of graphical content for the whole program.
 */

public enum Style {
    BORDERLINE("\r⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢\r"),

    LOGO(" ____        _        \r"
            + "|  _ \\ _   _| | _____ \r"
            + "| | | | | | | |/ / _ \\\r"
            + "| |_| | |_| |   <  __/\r"
            + "|____/ \\__,_|_|\\_\\___|\r");

    private final String string;

    Style(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}

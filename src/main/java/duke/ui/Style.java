package duke.ui;
/**
 * Defines the style of graphical content for the whole program.
 */
public enum Style {
    BORDERLINE("\n⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢⬡⬡⬢⬢\n"),

    LOGO(" ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n");

    private final String string;

    Style(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}

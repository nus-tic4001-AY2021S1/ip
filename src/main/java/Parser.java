public class Parser {
    /**
     * @param line The entire user input.
     * @return Returns only the first word of the input, which should be the command.
     */
    String getCommandWord(String line) {
        return line.trim().split(" ")[0];
    }

    /**
     * @param line The entire user input.
     * @param ui The UI created in the Duke class.
     * @return Returns true when an invalid command is given, to repeat user input.
     */
    boolean parseInput(String line, UI ui) {

        String command = getCommandWord(line);
        switch (command) {
            // also exit when user input is empty
            case "bye", "" -> {
                ui.farewell();
                return false;
            }
            default -> {
                System.out.println(line);
                return true;
            }
        }
    }
}

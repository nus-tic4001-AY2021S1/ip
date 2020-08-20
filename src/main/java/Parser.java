public class Parser {
    /**
     * @param line The entire user input.
     */
    String getCommandWord(String line) {
        return line.trim().split(" ")[0];
    }

    /**
     * @param line     The entire user input.
     * @param ui       The UI created in the Duke class.
     * @param database The Database created in the Duke class.
     */
    boolean parseInput(String line, UI ui, Database database) {

        String command = getCommandWord(line);
        switch (command) {
            case "list" -> {
                for (int i = 0; i < database.tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + database.tasks.get(i));
                }
                return true;
            }
            // also exit when user input is empty
            case "bye", "" -> {
                ui.farewell();
                return false;
            }
            default -> {
                database.add(line);
                System.out.println(line);
                return true;
            }
        }
    }
}

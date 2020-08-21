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
     * @param tasks    The TaskList created in the Duke class.
     */
    boolean parseInput(String line, UI ui, TaskList tasks) {

        String command = getCommandWord(line);
        switch (command) {
            case "list" -> {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
                }
                return true;
            }
            case "done" -> {
                tasks.changeDone(line, ui, tasks);
                return true;
            }
            // also exit when user input is empty
            case "bye", "" -> {
                ui.farewell();
                return false;
            }
            default -> {
                tasks.add(new Task(line));
                System.out.println(line);
                return true;
            }
        }
    }
}

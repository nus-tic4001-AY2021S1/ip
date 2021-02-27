package duke.commands;

import duke.Storage;
import duke.Ui;
import duke.tasks.TaskList;

public class HelpCommand extends Command {
    private String helpMenu = "Introduction:\n"
            + "This is a Chat Bot to manage a person's Task.\n\n"
            + "Usage:\n"
            + "  help\n"
            + "    -- Print out help information\n"
            + "\n"
            + "  bye\n"
            + "    -- Exit from the program\n"
            + "\n"
            + "  todo <DESCRIPTION>\n"
            + "    -- Add a todo into the task manager\n"
            + "\n"
            + "  deadline <DESCRIPTION> /by <DEADLINE in yyyy-mm-dd format>\n"
            + "    -- Add a deadline into the task manager\n"
            + "\n"
            + "  event <DESCRIPTION> /at <START DATE in yyyy-mm-dd format>\n"
            + "    -- Add an event into the task manager\n"
            + "\n"
            + "  find <KEYWORD>\n"
            + "    -- Find the Tasks contains the keyword\n"
            + "\n"
            + "  list\n"
            + "    -- List all the tasks stored in the task manager\n"
            + "\n"
            + "  delete <TASK INDEX in integer>\n"
            + "    -- Delete a task which is indicated\n"
            + "\n"
            + "  done <TASK INDEX in integer>\n"
            + "    -- Set a task which is indicated as done\n"
            + "\n";

    public String execute(String others, Ui ui, Storage storage, TaskList taskList) {
        return ui.indentPrint(helpMenu);
    }
}

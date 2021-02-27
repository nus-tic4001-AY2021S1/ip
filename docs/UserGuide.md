# User Guide
Duke is a graphic user interface task manager with command using Chat Bot Interface.
It can help you keep track of the list of tasks.

## Quick Start
1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest Duke.jar.
3. Copy the file to the folder you want to use as the home folder for your Task Manager.
4. Double click to open the Duke.jar file.

## Features
Duke supports three different types of Task: Todo, Deadline, and Event.
It could add, delete, set done and list task.
It could find the tasks with keyword, and check duplicate tasks.
It could auto save and load data into a saved file.
### Todo
The simplest Task. It has description, and a status as done or not.

### Deadline
The Task with a deadline. It can store a date as deadline of the given task.

### Event
The Task with a start date. It can store a date as start date of the given task.

### Add
Add a Task to the Task List.

### Delete
Delete a specific Task from the Task List.

### Set Done
Set a Task's status as done.

### List
List all the lists from Task List.

### Find
Find the Tasks with keywords and list them out.

### Duplicate
Show the Tasks which are duplicated.

### Help
Show the helping guide.

### Auto Save and Load
Task List changes will be auto stored as a file, and loaded in next run.


## Usage

### `todo` - Add todo to Task List

todo will create a todo Task with descriptions followed and add to Task List.

Example of usage:

`todo read book`

Expected outcome:

`[T][✘] read book`

### `deadline` - Add deadline to Task List

deadline will create a deadline Task with descriptions and deadline followed and add to Task List.

Example of usage:

`deadline return book /by 2020-09-30`

Expected outcome:

`[D][✘] return book (by: Sep 30 2020)`

### `event` - Add event to Task List

event will create an event Task with descriptions and start date followed and add to Task List.

Example of usage:

`event team meeting /at 2020-10-01`

Expected outcome:

`[E][✘] team meeting (at: Oct 1 2020)`

### `list` - List all Tasks from Task List

list will print out all Tasks stored in Task List.

Example of usage:

`list`

Expected outcome:

` 1. [T][✘] read book`

` 2. [D][✘] return book (by: Sep 30 2020)`

` 3. [E][✘] team meeting (at: Oct 1 2020)`

### `delete` - Delete a Task from Task List

delete will remove the stated Task stored in Task List.

Example of usage:

`delete 1`

Expected outcome:

` Noted. I've removed this task: `

`   [T][✘] read book`

### `done` - Set a Task's status to done

done will set the stated Task's status stored in Task List.

Example of usage:

`done 1`

Expected outcome:

` Nice! I've marked this task as done:`

`   [E][✓] team meeting (at: Oct 1 2020)`

### `duplicate` - Check Tasks which are identical

duplicate will list all the Tasks which are not unique in Task List.

Example of usage:

`duplicate`

Expected outcome:

` Here are duplicated tasks in your list:`

` 4. [D][✓] return book (by: Sep 20 2020)`

` Duplicates:`

` 4. [D][✓] return book (by: Sep 20 2020)`

` ----------------------------------`

### `find` - Find Tasks contains search term stated

find will search through the Task List and list all the tasks contains search term.

Example of usage:

`find book`

Expected outcome:

` Here are the matching tasks in your list:`

    `1. [D][✘] return book (by: Sep 20 2020)`
    
    `2. [T][✓] read book`

### `help` - Show Help Menu

Print out help menu contains all the commands use-cases.

Example of usage:

`help`

Expected outcome:

`  Introduction:`

`This is a Chat Bot to manage a person's Task.`

`Usage:`

`  help`

`    -- Print out help information`

`  bye`

`    -- Exit from the program`


### `bye` - Exit Duke

bye will stop the program and exit.

Example of usage:

`bye`

Expected outcome:

` Bye. Hope to see you again soon!`
    
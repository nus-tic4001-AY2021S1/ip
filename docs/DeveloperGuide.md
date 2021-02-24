# Developer Guide

## Design

### Architecture

![Image of UpdateSequenceDiagram](https://github.com/AY2021S1-TIC4001-3/tp/blob/master/docs/Images/architecture.png?raw=true)
The Architecture Diagram given above explains the high-level design of the App. Given below is a quick overview of each component.

The rest of the App consists of seven components.

UI: The UI of the App.
Duke: The main logic handler of the App.
Launcher: The handler between UI and Duke.
Commons: The control variable of the App.
Storage: Reads data from, and writes data to, the hard disk.
Commands: The actions of the program to interact with Storage.
TaskList: Define the structure of each Task to track.


### How the architecture components interact with each other

The Sequence Diagram below shows how the components interact with each other for the scenario where the user uses the Event command.
![Image of UpdateSequenceDiagram](https://github.com/AY2021S1-TIC4001-3/tp/blob/master/docs/Images/updateSequenceDiagram.png?raw=true)

### Storage component

![Image of UI Class Diagram](https://github.com/AY2021S1-TIC4001-3/tp/blob/master/docs/Images/interface.png?raw=true)

The Storage component is the handler of the temporary storage to storage file. It interacts TaskList Class which contains Task Class, and Task Class have many Subclasses for different scenarios.

It will auto save the program into a .txt file once a change has been made to the TaskList.

## Implementation

Duplicate Implementation

The ```duplicate``` feature displays non-unique Tasks in the Duke. It is achieved by the DuplicateCommand Class which made use of isEquals method in Task Class.

##### Design consideration:
Aspect: Duplicate can otherwise be implemented

###### Alternative 1 (current choice): Allow user to obtain results in the index ascending order.
Pros: Easy to implement. <br>
Cons: If there is a huge amount of return result, it may be difficult for user to view.

###### Alternative 2: Allow user to view part of the result.
Pros: More readable result to user if there is huge return data.<br>
Cons: more difficult to implement.

## Product scope
### Target user profile
* Is a lay person who used to interact with chat-bot.
* prefer desktop apps over other types.
* can type fast.
* prefers typing to mouse interactions.


### Value proposition
manage Tasks faster than a typical mouse driven app. Allows the user to better manage the tasks.

## User Stories

|Priority| As a … | I want to … | So that I can… |
|--------|----------|---------------|------------------|
|* * * |New user|add tasks into Task Manager|track my pending Tasks|
|* * * |New user|list all tasks stored in the Task Manager|find all the recorded tasks|
|* * * |New user|delete a task|remove Task that is irrelevant|
|* * * |New user|set a task as done|to track the progression of the Task Manager|
|* * * |New user|add a task with deadline|remind myself about the remaining time|
|* * * |New user|add a future task with start date|remind myself to prepare for it|
|* * * |User|find tasks with key word|find specific task easily|
|* * * |User|have a help guide|view the usage of the app|
|* * * |User|check duplicate tasks in the Task Manager|those repeated tasks could be delete|


## Non-Functional Requirements

* Should work on any mainstream OS as long as it has Java 11 or above installed.
* Should be able to hold up to 1000 tasks without a noticeable sluggishness in performance for typical usage.
* A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse
* Should load from and save to from a text files


## Glossary

* *Mainstream OS:* Windows, Linux, Unix, OS-X.

## Instructions for manual testing

### Launch and Shutdown

1. Initial launch
    1. Download the jar file and copy into an empty folder.
    2. Double click the jar file to open the program
    3. Type bye to exit from the program.

2. Re-launch the app by double clicking the jar file.

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
    
# Developer Guide

## Overall Look

!-[Image of UpdateSequenceDiagram](https://github.com/AY2021S1-TIC4001-3/tp/blob/master/docs/Images/architecture.png?raw=true)

## Design

### Architechture

!-[Image of UpdateSequenceDiagram](https://github.com/AY2021S1-TIC4001-3/tp/blob/master/docs/Images/architecture.png?raw=true)

The Architecture Diagram given above explains the high-level design of the App. Given below is a quick overview of each component.

The rest of the App consists of few components.

GUI: The UI of the App.

Duke: The main logic handler of the App.

Command: The control commands accepted by the App.

Storage: Reads data from, and writes data to, the hard disk.

Parser: Parse the input and convert the format which could be accepted by the app.

TaskList: Define the structure of each tasks.


### GUI component

The GUI componenet is the handler of the user input and output result to the user. It includes MainWindow Class which will deal with user input, 
and DialogBox Class which will handle the conversation between user and app. 

Both MainWindow and DialogBox are initialized by the Launcher. 

### Duke component

The Duke component includes logic handle command execution. It is used to provide an organised output and passed it to the GUI component.
Duke initializes the Storage and the Tasklist.  

### Storage Component

The Storage component loads a list of tasks from a text file when the program starts up. It makes use of the Parser class to create a task object from a String.
It also saves tasks to file upon program exit. It saves to format that is readable by the Parser class.


### TaskList component

The TaskList component is the container to save the data of tasks during execution of program. It consist an ArrayList to store all the tasks. 
The Task class is the class of tasks as what we defined. It contains the task name, status, type, tags and description.

The TaskList component:
* Able to interact with Storage component and load existing tasks
* Able to add new Todo/Deadline/Event tasks and store it in the instance of Task class
* Able to delete existing tasks that stored in the instance of TaskList class
* Able to get tasks that stored in the instance of TaskList class
* Able to get the whole TaskList itself 
* Able to set/get all details of any specified task
* Able to add a tag to an existing task
* Able to find a task by its keyword

### Command component and Parser component

The Command component are those classes used by the parser class.

The parser class is mainly in charge of parse user's input command and convert them to a workable format to the program.  


## Implementation

Tag Implementation

The ```tag``` feature gives a tag to an existing task. It is facilitated by the Tag Class and inherited by Task Class which comprises of the following implementation:

1. ```tag <index> /t #content``` - give a tag content by the task index


### Value proposition
Manage tasks faster and allows the user to better manage the tasks.

## User Stories
 
|Priority| As a … | I want to … | So that I can… |
|--------|----------|---------------|------------------|
|* * * |New user|add tasks into the system|track my tasks|
|* * * |New user|view an task that is based on the id|see its content.|
|* * * |New user|delete a task|remove tasks that are completed or no longer required|
|* * * |New user|list all tasks currently in the task list|find all of the recorded tasks currently in the list.|
|* * |New user|I would like a given creating task format|so that I can know a structured way of using the app|
|...|...|...|...|


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
    1. Download the jar file and copy into an empty folder
    2. Use Command Prompt to run jar file with `java -jar` command.
    3. type bye command to exit from the program.

2. Re-launch the app by running `java -jar` command with Command Prompt.

### Adding a todo/deadline/event task
1. Add the task through following command:
    1. ```todo <CONTENT>```
    2. ```deadline <CONTENT> /by <DEADLINE in dd-mm-yyyy format>```
    3. ```event <CONTENT> /at <DEADLINE in dd-mm-yyyy format>```
 
### tag a task
1. Tag the task through following command:
    1. ```tag <INDEX> /t <CONTENT>```

### Listing all tasks in the system
1. Enter the command
    1. ```list```
2. List of all tasks in the system will be listed in the order they were created.

### Find a particular task in the system
1. Enter the command
    1. ```find <KEYWORD>```
2. The tasks with the specified keyword will be shown on screen in details.

### Delete a particular task in the system
1. Enter the command
    1. ```Delete <INDEX>```. Eg:delete 1
2. The second Defect will be deleted.



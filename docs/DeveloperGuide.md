# Developer Guide

## Design

###The Task components are the basic building block of the Duke chat bot.

The Task component:
* Is an abstract class that is inherited by 3 subclasses - Todo, Deadline and Event 
* Has properties like description, end dates, boolean value whether the task has completed or not.
* Method to return the Task in a specific format.

![Image of TaskClassDiagram](https://github.com/JanuariusJang/ip/blob/master/docs/images/TaskClassDiagram.png?raw=true)

### COMMONS component

The commons component are those classes used by multiple components are in the program, such as enum classes and the parser class.

The parser class is mainly in charge of parse user's input and convert them to a workable format to the program. The enum classes are used to strict the keywords. 


## Product scope
### Target user profile
* Is a developer, tester or member of the project team.
* prefer desktop apps over other types.
* can type fast.
* prefers typing to mouse interactions.
* is reasonably comfortable using CLI apps.


### Value proposition
manage defects faster than a typical mouse/GUI driven app. Allows the user to better manage the project issues.

## User Stories
 
|Priority| As a … | I want to … | So that I can… |
|--------|----------|---------------|------------------|
|* * * |new user|add to do tasks into Duke|view my tasks|
|* * * |New user|add deadline tasks into Duke|view and track deadlines of tasks|
|* * * |New user|add event tasks into Duke|view and track event tasks with start and end dates|
|


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
    3. type exit command to exit from the program.

2. Re-launch the app by running `java -jar` command with Command Prompt.

### Adding a Task
1. Add the To Do Task through following command:
    1. todo Taskname
 
### Adding a Deadline
1. Add the Deadline Task through following command:
    1. deadline Taskname by Enddate

### Adding an Event
1. Add the Event Task through following command:
    1. event Taskname at Startdate Enddate

### Listing all tasks in the Duke chatbot
1. Enter the command
    1. list
2. All tasks in the system will be listed.

### Delete a particular task in the system
1. Enter Delete command
    1. delete Index Number.
2. The Task at the index number will be deleted.

### Marking a task as done (finished)
1. Enter Done command
    1. done Index Number.
2. The Task at the index number will be marked as done.
3. When running the list command, tasks that are marked as done will have a tick. Tasks that are not marked as done will have a cross

### Update a task description
1. Enter the Update command
    1. update Index Number New Description.
2. The task at the Index Number will be updated with a new description

### Find a task
1. Enter the Find command
    1. find Description 
2. If a task fits the description, it will be returned. 

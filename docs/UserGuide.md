## User Guide

Welcome to Duke Task Tracker (DTT). (DTT) is an app for managing on-hand task, optimized for use via a Command Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI). 

## Quick Start
1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest Duke.jar from [here](https://github.com/Chilaiping/ip/releases).
3. Copy the file to the directory you want to use as the home directory for your Duke Task Tracker Application.
4. Open a command prompt / terminal window in that directory.
5. Run the command ```java -jar Duke.jar``` to open up the application.

## Features
```Todo```: Add a tasks either with any memo or without <br/>
```Deadlines```: Add a task with specified data, memo and time is optinal input. <br/>
```Event```: Add a task with location or time frame, memo is optional input. <br/>
```AddRecurr```: Add recurring tasks. <br/>
```List```: View the list of tasks that have been added. <br/>
```Done```: Mark specified tasks as completed. <br/>
```Delete```: Delete a specified task. <br/>
```Find```: Find tasks using a specified keyword. <br/>
```Bye```: Exit Task Tracker <br/>

### Todo
Format1: todo <description> <br/>
Format2: todo <description> /memo <memo><br/>
Example: todo submit report /memo TIC4002 <br/>
Output: <br/>
___________________________________________________________________________<br/>
Got it. I've added is tasks:<br/>
[T][✘] submit report (Memos : TIC4002) <br/>
Now you have 1 tasks in the list <br/>
___________________________________________________________________________<br/>

### Deadline
Format1: deadline <description> /by <date> <br/>
Format2: deadline <description> /by <date> <time> /memo <memo><br/>
Example: deadline submit ppt 2021-02-21 14:00 /memo TIC4002 <br/>
Output: <br/>
___________________________________________________________________________<br/>
Got it. I've added is tasks:<br/>
[D][✘] submit ppt (by: Feb 21 2021 14:00)(Memos : TIC4002) <br/>
Now you have 1 tasks in the list <br/>
___________________________________________________________________________<br/>

### Event
Format1: event <description> /at <place><br/>
Format2: event <description> /at <place> /memo <memo><br/>
Example: event submit hardcopy /at NUS Com-2 /memo TIC4003 <br/>
Output: <br/>
___________________________________________________________________________<br/>
Got it. I've added is tasks:<br/>
[E][✘] submit hardcopy (at: NUS Com-2)(Memos : TIC4002) <br/>
Now you have 1 tasks in the list <br/>
___________________________________________________________________________<br/>

### AddRecurring Task
Format1: weekly <description> /memo <memo><br/>
Format2: monthly <description> /memo <memo><br/>
Example: weekly submit form /memo 3 Forms <br/>
Output: <br/>
___________________________________________________________________________<br/>
Got it. I've added is tasks:<br/>
weekly - submit form (Memos : TIC4002) <br/>
Now you have 1 tasks in the list <br/>
___________________________________________________________________________<br/>

### List
Format: list<br/>
Example: list<br/>
Output: <br/>
___________________________________________________________________________<br/>
1.[T][✘] submit report (Memos : TIC4002) <br/>
2.[D][✘] submit ppt (by: Feb 21 2021 14:00)(Memos : TIC4002) <br/>
3.[E][✘] submit hardcopy (at: NUS Com-2)(Memos : TIC4002) <br/>
4.weekly - submit form (Memos : TIC4002) <br/>
___________________________________________________________________________<br/>

### Done
Format: done <index> <br/>
Example: done 3<br/>
Output: <br/>
___________________________________________________________________________<br/>
Nice. I've marked this task as done:
[D][✓] submit ppt (by: Feb 21 2021 14:00)(Memos : TIC4002) <br/>
___________________________________________________________________________<br/>

### Delete
Format: delete <index> <br/>
Example: delete 3<br/>
Output: <br/>
___________________________________________________________________________<br/>
Task Deleted
___________________________________________________________________________<br/>

### Find
Format: find <description> <br/>
Example: find report<br/>
Output: <br/>
___________________________________________________________________________<br/>
Here are the matching tasks in your list:
1.[T][✘] submit report (Memos : TIC4002) <br/>
___________________________________________________________________________<br/>


## Saving the data <br/>
Saving of the data is done automatically after each command. It will be saved into the
data/record.txt is the directory where you can find the list of tasks saved. <br/>

### Support or Contact <br/>
Having trouble with executing the program? Contact the developer [here](https://ay2021s1-tic4001-4.github.io/tp/AboutUs.html) and We'll help you sort it out. 
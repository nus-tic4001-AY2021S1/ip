# User Guide
Project Duke is a educational software project that helps user to keep track of various things and finish the task before the deadline.

## Quick start 

1. Ensure you have Java 11 or above installed in your Computer
1. Download the IntelliJ
1. Set up the correct JDK version as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Download the latest project from [here](https://github.com/linqing42/ip).
1. Import the project into Intellij.
1. Go to the sr folder and find src\main\java\Dukes\Duke
1. Right click the Duke and select Run Duke
1. The program now should run on the Console (usually located at the bottom side)
1. Type the command and presse Enter to execute it.<br>
1.Refer to teh [Feature](#features) below for details of each command.

## Features 

### Feature 1 
Adding a task: todo

## Usage
Adding a task in the task list and show the total number of task in the list. Therefore, the user know the task that he need to do.

### `todo` - Adding a task into a task list.
<br/>>The keyword 'todo' with description can be **upper and lowercase letters** and its outcome will not include the keyword.
<br/>>If you key in the keyword without description. There will be an error message:"☹ OOPS!!! The description of a todo cannot be empty. "

**Format**: todo Description

**Example of usage**: TOdo Read BOOK

**Expected outcome**:
<br/>Got it. I've added this task: 
<br/>[T][X] Read BOOK
<br/>Now you have [index number] task in the list.

### Feature 2 
Adding a deadline task: deadline

## Usage
Adding a deadline task helps to know the deadline for the specific task in the task list and show the total number of task in the list.

### `deadline` - Adding a deadline task

<br/>>The keyword 'deadline' with description can be **upper and lowercase letters**.
<br/>>The outcome will not include the keyword with date and time format: dd MMM yyyy, hh:mm a
<br/>>If you key in the keyword without description. There will be an error message:"☹ OOPS!!! The description of a deadline cannot be empty." 
<br/>>If you missing the date and time or /by, there will be an reminder message:"Please specify the deadline date and time."

**Format**: deadline  Description /by dd/mm/yyyy HHmm

**Example of usage**: deadline return book /by 12/12/2019 1800

**Expected outcome**:
<br/>Got it. I've added this task: 
<br/>[D][X] return book (by:12 Dec 2019, 06:00 PM)
<br/>Now you have [index number] task in the list.

### Feature 3 
Adding an event task: event

## Usage
Adding an event task helps to remember to join or complete the event with specific date and time in the task list and show the total number of task in the list.

### `event` - Adding an event task

<br/>>The keyword 'event' with description can be **upper and lowercase letters**.
<br/>>The outcome will not include the keyword with date adn time format: dd MMM yyyy, hh:mm a
<br/>>If you key in the keyword without description. There will be an error message:"☹ OOPS!!! The description of a event cannot be empty."
<br/>>If you missing the date and time or /by, there will be an reminder message:"Please specify the event date and time."

**Format**: event  Description /by dd/mm/yyyy HHmm

**Example of usage**: EVENT join club /at 12/11/2019 0900

**Expected outcome**:
<br/>Got it. I've added this task: 
<br/>[E][X] join club (at:12 Nov 2019, 09:00 AM)
<br/>Now you have [index number] task in the list.

### Feature 4 
Marking a specific task: done

## Usage
Marking a specific task to remind the user that he has finished the task.

### `done` - Marking a specific task from the task list.
<br/>>The keyword 'done' can be **upper and lowercase letters** 
<br/>>The outcome will be change the X to ✓ in the specific task.
<br/>>The index refers to the index number shown in the displayed task list and the index **must be positive integer** 1,2,3...
<br/>>If you key in the keyword without INDEX. There will be an error message:"please key in correct format." 

**Format**: done INDEX

**Example of usage**: 
<br/>step 1: TODO READ BOOK
<br/>step 2: Done 1 or DONE 1 or done 1

**Expected outcome**:
<br/>Nice! I've marked this task as done:
<br/>[T][✓] READ BOOK

### Feature 5
Deleting a task: delete

## Usage
Delete a specific task from task list to helps remove the completed task and tidy the task list. It will show the total number of tasks left in the task list. 

### `delete` - Deleting a specific task from the task list.
<br/>>The keyword 'delete' can be **upper and lowercase letters** and its outcome will be remove the specific task and reduce the total number of task in the list.
<br/>>The index refers to the index number shown in the displayed task list and the index **must be a positive integer** 1,2,3...
<br/>>If you key in the keyword without INDEX. There will be an error message:"☹ OOPS!!! There is no specific task to delete."

**Format**: delete INDEX

**Example of usage**: 
<br/>step 1.TODO READ BOOK
<br/>step 2: done 1
<br/>steps 3:Delete 1 or DELETE 1 or delete 1

**Expected outcome**:
<br/>Noted. I've removed this task: 
<br/>[T][✓] READ BOOK
<br/>Now you have [INDEX-1] task in the list.

### Feature 6
Listing all tasks: list

## Usage
It shows a list of all task in the task list with a number. it helps to summarize the task list.
### `list` - Listing all tasks with number.
<br/>>The keyword 'list' can be **upper and lowercase letters** and its outcome will be show a list of task in the task list
<br/>>If you key in the keyword with empty task.There will be an error message:"☹ OOPS!!! There are no tasks in your list."

**Format**: list

**Example of usage**: 
<br/>step 1.TODO READ BOOK
<br/>step 2. list or List or LIST

**Expected outcome**:
   <br/>Here are the tasks in your list:
   <br/>1.[T][X] READ BOOK
    
### Feature 7
Locating tasks by description_keyword: find

## Usage
It helps to search a task that contain any of the given description_keyword, and the search is case-insensitive. e.g book will match BOOK. Therefore, the user can easily find out the specific task base on find function.
### `find` - Locating tasks with given description_keyword
<br/>>The keyword 'find' can be **upper and lowercase letters** and its outcome will be show a list of task in the task list when the task is match the specific description keywords.
<br/>>The order of the description_keyword does not matter.
<br/>>If you key in the specific description keyword that does not match the task in your list.There will be an error message:"☹ OOPS!!! There is no matching tasks in your list."
<br/>>If you only key in the **keyword**, there will be an error message:"☹ OOPS!!! The description of a find cannot be empty."

**Format**: find description_keyword[more_keyword]

**Example of usage**: 
   <br/>step 1.TODO READ BOOK
   <br/>step 2. todo join club
   <br/>step 3. find book or Find BOok or FIND BOOK

**Expected outcome**:
   <br/>Here are the matching tasks in your list:
   <br/>1.[T][X] READ BOOK

### Feature 8
Exiting the program: exit/bye

## Usage
It helps to end the program and display the list of a task will be save in the hard disk.
### `exit/bye` - Exiting the program 
   <br/>The keyword 'exit/by' can be **upper and lowercase letters** and its outcome will be show a list of task in the task list that will be save in hard disk and a bye message.

**Format**: exit 
**Format**: bye

**Example of usage**: 
   <br/>step 1.TODO READ BOOK
   <br/>step 2. todo join club
   <br/>step 3. bye/exit/BYE/EXIT/Bye/Exit

**Expected outcome**:
   <br/>Your following tasks will be save: 
   <br/>[T][X] READ BOOK
   <br/>[T][X] join club
   <br/>Bye. Hope to see you again soon!

### Feature 9
Saving the task in the hard-disk
## Usage
It helps to save the tasks in the hard disk automatically after exiting the program, and the format of display will be change when task save in hard disk. It saves the user's time as there is no need to save manually.

**Example of usage**: 
   <br/>step 1.todo read book
   <br/>step 2. deadline return book /by 12/11/2019 1800
   <br/>step 3. event join club /at 11/2/2020 1300
   <br/>step 4. done 1
   <br/>step 5. bye

**Expected outcome**: save into /data/duke.txt
   <br/>T | 1 | read book
   <br/>D | 0 | return book  | 12 Nov 2019, 06:00 PM
   <br/>E | 0 | join club  | 11 Feb 2020, 01:00 PM

### Feature 10
Exceptions message
## Usage
It helps to handle error message that will guid the user.

**Example of usage**: 
   <br/>read book

**Expected outcome**:
   <br/>☹ OOPS!!! I'm sorry, but I don't know what that means :-(

## Command Summary

|**Action** | **Format** | **Examples**|
-------|:-------:| :-----:|
|Todo | todo Description | todo read book|
|Deadline | deadline Description /by dd/mm/yyyy HHmm | deadline return book /by 12/12/2019 1800|
|Event | event Description /at dd/mm/yyyy HHmm | event join club /by 11/1/2019 1300|
|Done | done INDEX | done 1|
|Delete | delete INDEX | delete 1|
|List | list|
|Find | find description_keyword[more_keywords] | find book|
|Exit | exit|
|Bye | bye|

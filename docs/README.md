# User Guide

## Features 

### Add Tasks
This feature allow user to input new Tasks, such as Todo, Deadlines and Event.

### Delete Tasks
This feature allow user to remvoe any unnecessary Tasks from the existing list.

### Display Tasks
This feature is to have one glance view of all existing Tasks, be it completed Tasks or not. 

### Feature Find 
This feature is to allow user to search a keyword from the existing Tasks.

### Feature Save
This feature is to automatically save all entry to the file before the user quit the system.


## Usage

### `Todo` - Create a new Todo Tasks 

Create a Todo tasks which without any timeline

Example of usage: 

`todo Submit tp`

Expected outcome:

`Got it. I've added this task:`

 `	[T][✘] Submit tp`
 
 `Now you have 5 tasks in the list.`

### `Deadline` - Create a new Tasks with Deadline 

Create a new tasks with deadlines to the list

Example of usage: 

`deadline Submit ip /by 2020-09-20 09:30`

Expected outcome:

`Got it. I've added this task:`

 `	[D][✘] Submit ip  (by: Sep 20 2020 09:30)`
 
 `Now you have 5 tasks in the list.`
 
 
 
 ### `Event` - Create a new Tasks with date and time frame
 
 Create a new tasks with timing to the list
 
 Example of usage: 
 
 `event submit ip /at 28 Sept 2020 09:00-10:00`
 
 Expected outcome:
 
 `Got it. I've added this task:`
 
  `	[D][✘] submit ip  (at: 28 Sept 2020 09:00-10:00)`
  
  `Now you have 5 tasks in the list.`

### `List` - Display all existing Tasks
All Tasks will be display after user entered the List

Example of usage: 

`List`

Expected outcome:

`1. [D][✘] Submit ip  (by: Aug 9 2020 09:04)   `

`2. [T][✓] Submit tp  `

`3. [E][✘] Submit ip  (at: Aug 9 2020 09:00-10:00)`

### `Delete` - Remove Tasks from the List

This is to allow user to remove unnecessary Tasks from the existing list and remove from the .txt file.

Example of usage: 

`delete 3`

Expected outcome:

`Tasks Number 3 is deleted from the list`


### `Find` - Find Tasks with Keywords
It will search from the list of Tasks and return to Users whichever Tasks that contain the keywords.

Example of usage: 

`Find books`

Expected outcome:

`1. Todo Read Book  `

`2 Todo Borrow book From Library`

### `Done` - Mark the Tasks as a completed Tasks
It will set the tasks as completed and represented by a [✓]

Example of usage: 

`Done 1`

Expected outcome:

`Nice! I've marked this task as done:  `

 `[D][✓]  Submit ip  (by: Aug 9 2020 09:04)`

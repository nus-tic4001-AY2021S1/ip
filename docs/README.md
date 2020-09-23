# User Guide
This product is not meant for end-users and therefore there is no user-friendly installer. Please refer to the Setting up section below to learn how to set up the project.



#Starting the program
Using IntelliJ
1.	Find the project in the Project Explorer (usually located at the left side)
<br /> * If the Project Explorer is not visible, press `ALT`+`1` for Windows/Linux, `CMD`+`1` for macOS to open the Project Explorer tab
2.	Go to the `src` folder and locate the Duke file
3.	Right click the file and select Run `Duke.main()`
4.	The program now should run on the `Console` (usually located at the bottom side)
5.	Now you can interact with the program through the `Console`


Using Command Line
1.	'Build' the project using IntelliJ
2.	Open the Terminal/Command Prompt
3.	cd into the project’s `out\artifacts\ip_jar`
4.	Type `java -jar ip.jar`  then Enter to execute 
5.	Now you can interact with the program through the CLI


## Features 
- Adding a Todo task: todo
- Adding a Deadline task: deadline
- Adding an Event task: event
- Listing task information: list
- Finding all tasks containing any keyword: find
- Deleting a task : delete
- Mark as Done of a task: done
- View details of a task : view
- Clearing all entries : clear
- Exiting the program : bye
- Loading the data
- Saving the data

Notes about the command format:
- Words in **UPPER_CASE** are the parameters to be supplied by the user.
`E.g. DESCRIPTIONS in the command todo TASK DESCRIPTIONS`.
Order of parameters are fixed.





### Feature 1: Adding a Todo task: todo
Adds a Todo task. ToDos: tasks without any date/time attached to it `e.g., visit new theme park`

## Usage

Format: `todo` **TASK DESCRIPTIONS**

Example of usage: 

`todo borrow book`

Expected outcome:

`Got it. I've added this task:`<br />
 &nbsp; `[T][✘] borrow book`<br />
`Now you have 13 tasks in the list.`

 <br />
 
 ### Feature 2: Adding a Deadline task: deadline
 Adds a Deadline task. Deadlines: tasks that need to be done before a specific date `e.g., submit report by 2020-10-23`
 
 ## Usage
 
 Format: `deadline` **TASK DESCRIPTIONS** `/by` **SPECIFIC DATE** (FORMAT:yyyy-MM-dd)
 
 Example of usage: 
 
`deadline return book /by 2020-12-12`
 
 Expected outcome:
 
 `Got it. I've added this task:`<br />
  &nbsp;   `[D][✘] return book (by: 2020年12月12日星期六)`<br />
 `Now you have 15 tasks in the list.`<br />
 
<br />
 
 ### Feature 3: Adding an Event task: event
 Adds an Event task. Events: tasks that start at a specific time and ends at a specific time `e.g., team project meeting at 2020-10-23 10:00`
 
 ## Usage
 
 Format: `event` **TASK DESCRIPTIONS** `/at` **SPECIFIC DATE AND TIME** (FORMAT:yyyy-MM-dd'T'HH:mm)
 
Example of usage: 
 
`event project meeting /at 2020-12-12 10:00`
 
Expected outcome:
 
`Got it. I've added this task:`<br />
  &nbsp;   `[E][✘] project meeting (at: 星期六, 12月12日, 2020 10:00:00 上午)`<br />
`Now you have 17 tasks in the list.`<br />

<br />

 ### Feature 4: Listing task information: list
 Display the text entered by the user back to the user when requested. The list contains the task details.
 
 ## Usage
 
 Format: `list` 
 
Example of usage: 
 
`list`
 
Expected outcome:
 
`Here are the tasks in your list:`<br />
`1.[T][✓] write a program`<br />
`2.[E][✓] visit zoo (at: 星期二, 11月10日, 2020 10:30:00 上午)`<br />
`3.[D][✓] read book (by: 2020年11月23日星期一)`<br />
`4.[T][✓] meet friends`<br />
`5.[E][✓] be happy (at: 星期六, 10月10日, 2020 11:11:00 上午)`<br />
`6.[D][✘] to submit assignment (by: 2020年10月11日星期日)`<br />
`7.[D][✓] check coding (by: 2020年9月10日星期四)`<br />
`8.[T][✘] add book to list`<br />
`9.[T][✓] checking`<br />
`10.[E][✘] class (at: 星期六, 12月12日, 2020 11:00:00 上午)`<br />
`11.[D][✓] submit assignment (by: 2020年10月12日星期一)`<br />
`12.[T][✘] add more function`<br />
`13.[T][✘] borrow book`<br />
`14.[T][✘] return book`<br />
`15.[D][✘] return book (by: 2020年12月12日星期六)`<br />
`16.[D][✘] read book (by: 2020年12月23日星期三)`<br />
`17.[E][✘] project meeting (at: 星期六, 12月12日, 2020 10:00:00 上午)`<br />
`18.[E][✘] class meeting (at: 星期三, 12月23日, 2020 09:00:00 上午)`<br />

<br />
 
 ### Feature 5: Finding all tasks containing any keyword: find
Finds tasks which contain any of the given keywords.

 ## Usage
 
 Format: `find` **KEYWORD** [MORE_KEYWORDS]
 
 Example of usage: 
 
`find book`
 
 Expected outcome:
 
 `Here are the matching tasks in your list:`<br />
 `1.[D][✓] read book (by: 2020年11月23日星期一)`<br />
 `2.[T][✘] add book to list`<br />
 `3.[T][✘] borrow book`<br />
 `4.[T][✘] return book`<br />
 `5.[D][✘] return book (by: 2020年12月12日星期六)`<br />
 `6.[D][✘] read book (by: 2020年12月23日星期三)`<br />

 <br />
 
 ### Feature 6: Deleting a task : delete
Deletes the specified task from the task list. Irreversible.
 
 ## Usage
 
 Format: `delete` **INDEX**
 
 Select the task to delete based on the specified INDEX. The index refers to the index number shown in the most recent listing.
  
 
 Example of usage: 
 
 `list `<br />
 `delete 4 `<br />
 Deletes the 4th task in the task list.
 
 Expected outcome:
 
 `Noted. I've removed this task: `<br />
   &nbsp;   `[T][✘] write a song`<br />
 `Now you have 3 tasks in the list.`<br />


 
<br />

 ### Feature 7: Mark as Done of a task: done
 Mark specified task as done.
 
 ## Usage
 
 Format: `done` **INDEX**
 
 Mark as Done of the task at the specified INDEX. The index refers to the index number shown in the most recent listing.
 
 Example of usage: 
 
  `list `<br />
  `done 4 `<br />
  Marks the 4th task in the task list as done.
 
 Expected outcome:
 
 `Nice! I've marked this task as done: `<br />
 `[✓] set a meeting`
 
 
<br />


 ### Feature 8: View details of a task : view
 Displays the details of the specified task.
 
 ## Usage
 
 Format: `view` **INDEX**
 
 Views the task at the specified INDEX. The index refers to the index number shown in the most recent listing.
 
 Example of usage: 
 
  `list `<br />
  `view 4 `<br />
  Views the 4th task in the task list.
 
 Expected outcome:
 
 `Nice! Here is the task ready to view:`<br />
 `[T][✓] set a meeting`
 
 
 
<br />


 ### Feature 9: Clearing all entries : clear
Clears all entries from the address book.
 
 ## Usage
 
 Format: `clear` 
 
 Example of usage: 
 
  `clear `<br />
 
 Expected outcome:
 
 `The Task list initially:`<br />
 `[[T][✓] have dinner, [T][✘] buy book, [T][✘] visit friends, [T][✓] set a meeting]`<br />
 `The Task list after using clear() method:[]`

 
<br />


 ### Feature 10: Exiting the program : bye
 Exits the program.
 
 ## Usage
 
 Format: `bye` 
 
Example of usage: 
 
  `bye `<br />
 
 Expected outcome:
 
 `Bye. Hope to see you again soon!`<br />
 
 
<br />

### Feature 11: Loading the data
Auto-load the data from the hard disk when Duke starts up. <br />
The file name and location `e.g., [project_root]/data/duke.txt`
 
<br />

### Feature 12: Saving the data
Save the tasks in the hard disk automatically whenever the task list changes. There is no need to save manually. If there is no existing txt file, or data folder. The program can auto create a txt file and save the data in the hard disk.
<br />
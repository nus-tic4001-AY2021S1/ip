![Image of Todolist](https://github.com/binbinhui/ip/blob/master/docs/94735-istock-863607936.jpg)
# User Guide


# About
A task manager application help user to record their daily task.


# What to Use Task Manager for and When to Use It

User can use this task manager in his/her daily live. Task Manaer is a commonly user for:

- Record tasks
- Edit tasks
- Find tasks
- Others


# Source

You can found on [GitHub](https://github.com/binbinhui/ip). Fork me!

# Features 
- `help`        
- `todo`       
- `event`       
- `deadline`   
- `list`       
- `done`        
- `delete`            
- `find`        
- `bye`        

### `help`
If user doesnt know the commands or typo, can always use the help option.<br/>

Example:<br/>
<pre>help

Expected outcome:
help       -Check the user manual
todo       -Add a to do task
event      -Add an event 
deadline   -Add a deadline task
list       -List all task
done       -Mark a task to be done
delete     -Delete a task
load       -Load task from the file
find       -Find a task contain the key word
bye        -Exit the task</pre>

### `todo`
User able to add a todo task with date or without date.<br/>
Example:<br/>
<pre>Please enter
todo
Please add a to do task
read book
please add date: dd/mm/yyyy hhmm eg: 2/12/2019 1800
2/12/2019 1800

Expected outcome:
Mon Dec 02 18:00:00 SGT 2019 is valid date format
Task has been added</pre>

### `event`
User able to add a event task with date.<br/>
Example:<br/>
<pre>Please enter
event
Please add a event task
go for party
please add date: dd/mm/yyyy hhmm eg: 2/12/2019 1800
2/12/2019 1800

Expected outcome:
Mon Dec 02 18:00:00 SGT 2019 is valid date format
Task has been added</pre>


### `deadline`
User able to add a deadline task with date.<br/>
Example:<br/>
<pre>Please enter
deadline
Please add a event task
return book
please add date: dd/mm/yyyy hhmm eg: 2/12/2019 1800
2/12/2019 1800

Expected outcome:
Mon Dec 02 18:00:00 SGT 2019 is valid date format
Task has been added</pre>


### `list`
User able to list all the tasks. <br/>
Example:<br/>
<pre>list

Expected outcome:
1. [T][x] read book  by Mon Dec 02 18:00:00 SGT 2019
2. [E][x] go for party  by Mon Dec 02 18:00:00 SGT 2019
3. [D][x] return book  by Mon Dec 02 18:00:00 SGT 2019</pre>

### `done`
User able to change the status of a task. <br/>
Example:<br/>
<pre>done
Please mark done a task
1. [T][x] read book  by Mon Dec 02 18:00:00 SGT 2019
2. [E][x] go for party  by Mon Dec 02 18:00:00 SGT 2019
3. [D][x] return book  by Mon Dec 02 18:00:00 SGT 2019
1

Expected outcome:
[T][c] read book | 2/12/2019 1800 has been set to done.</pre>


### `delete`
User able to delete a task. <br/>
Example:<br/>
<pre>delete
Please delete a task
1. [T][c] read book  by Mon Dec 02 18:00:00 SGT 2019
2. [E][x] go for party  by Mon Dec 02 18:00:00 SGT 2019
3. [D][x] return book  by Mon Dec 02 18:00:00 SGT 2019
1

Expected outcome:
[T][c] read book | 2/12/2019 1800 has been detele.</pre>



### `find`
User able to find any keyword from the tasks.<br/>
Example:<br/>
<pre>find
Please type the keyword
1800

Expected outcome:
2. [T][x] read book  by Mon Dec 02 18:00:00 SGT 2019
3. [E][x] go school  by Mon Dec 02 18:00:00 SGT 2019</pre>


### `bye`
User exit the program the tasks will save into a file.<br/>
Example:<br/>
<pre>bye

Expected outcome:
Successfully wrote to the file.
Bye. Hope to see you again soon!</pre>


# Thank You!!!

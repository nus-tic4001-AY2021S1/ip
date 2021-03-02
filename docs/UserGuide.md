# User Guide

## Introduction

Duke Chatbot is an application to key in your Tasks (To do list, Deadlines, Event reminders). Interaction with the app is via a command-line interface (CLI) .

## Quick Start

1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest Duke.jar.
3. Copy the file to the folder you want to use as the home folder for your Duke Chat bot.
4. Open the program which should appear in the command prompt with java -jar [Directory of the Duke.jar file].


## Features 


|Action| Command Summary|
|--------|----------|
|todo | To create a new ToDo Task. Todo tasks do not have an end date. |
|deadline  | To create a new Deadline Task. Deadline tasks have an end date |
|event | To create a new Event Task. Event tasks have a start and end date |
|delete | To delete a task (To do, deadline, event) |
|list |Listing all task in the application|
|done |To mark Tasks when they are completed.|
|find |To find tasks in the application|
|update |To update the task descriptions|
|Load  |Load issues from text files when program starts, if task.txt exists|
|save|Save issues to task.txt immediately|



### Command Summary
 
|Action|Format, Examples|
|--------|----------|
|todo|todo Taskname <br>E.g. todo complete math exercises |
|deadline| deadline Taskname by end date <br>E.g. deadline complete Assignment by 10 October |
|event|event Taskname at Start-date End-date <br>E.g. event Attend Apple conference at 11 October 12 October |
|delete|delete Index Number <br>E.g. delete 2|
|list|list <br> list|
|done|done Index Number<br> done 3|
|find|find Taskname<br> find Return Library books|
|update |update Index Number Taskname<br> update 2 Return money |



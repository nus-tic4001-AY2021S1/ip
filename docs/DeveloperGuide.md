# Developer Guide

A Personal Assistant Chatbot that helps a person to keep track of various things. It's named after the Java mascot _Duke_.

## Product scope
### Target user profile

The target user is a student who would like to keep track of various kinds of tasks, such as a simple to do, tasks with deadlines and events with a start and end date and time.

### Value proposition

Project Duke will help the user remember his/her tasks, deadlines and events that occur according to schedule. He/she can set a task to completed when said task is done.

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v0.1|student|exit the program|close the application.|
|v0.1|student|create a task|keep track of my schedule.|
|v0.1|student|add an end date to my task| know the deadline.|
|v0.1|student|add a start and end date to my task| know the timeframe.|
|v0.1|student|list down all tasks| see all the tasks that I have.|
|v0.1|new user|see the commands list | know the features that the program has.|
|v0.1|student|set a task as completed| know that said task is done.|
|v0.1|student|delete a task| remove unwanted clutter.|
|v0.1|student|save my tasks|keep a record for use later.|
|v0.2|student|find tasks by word(s)| easily see the tasks that are related to my search.|
|v0.3|student|add a note to a task| record small snippets of textual information.|

## Non-Functional Requirements

* Operation Environment: Project Duke works on Windows OS with Java **11**.
* Usability: A command line interface application that accepts textual user input.
* Capacity: Project Duke is able to record as many tasks as a text file can hold.
* Availability: As long as the jar file is available, the application can be opened.
* Maintainability: A updated JAR file will be released to user if there is any update to the current version of the project tracker.

## Glossary

* Mainstream OS * - Windows, Mac and Linux

## Instructions for manual testing

Run the application
*    1. Download the Jar file and copy into an empty folder
*    2. Use terminal/CMD to run jar file with `java -jar` command.
*    3. Click the close button to close the program. 
        
Saving data
*    1. Data is saved automatically every time the database is accessed when adding, removing or completing a task.
*    2. Tasks that have their task type (Todo, Deadline or Event) externally edited will be detected by the program and the corrupted task will not be added into the memory. It is advisable to check the text file for the error.
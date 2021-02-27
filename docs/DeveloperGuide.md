---
layout: page
title: Developer Guide
---
* Table of Contents
{:toc}


--------------------------------------------------------------------------------------------------------------------
## Design

### Architecture

UI: The UI of the App.
Duke: The main logic handler of the App.
Launcher: The handler between UI and Duke.
Commons: The control variable of the App.
Storage: Reads data from, and writes data to, the hard disk.
Commands: The actions of the program to interact with Storage.
TaskList: Define the structure of each Task to track.


### Class Diagram

![Image of Storage Class Diagram]()

The Storage component is the handler of the temporary storage to storage file. It interacts TaskList Class which contains Task Class, and Task Class have many Subclasses for different scenarios.

It will auto save the program into a .txt file once a change has been made to the TaskList.


--------------------------------------------------------------------------------------------------------------------

## **Appendix: Requirements**

### Product scope

**Target user profile**: This app is targeted towards small business owners who wish to keep track of employee data such as salary, role and days of leave taken.

**Value proposition**: This app shall allow users to consolidate employee data on a single platform. This increases their productivity because they no longer need to access multiple data sources to retrieve/update employee data.

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



## Non-Functional Requirements

* Should work on any mainstream OS as long as it has Java 11 or above installed.
* A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse
* Should load from and save to from a text files                                   |

*{More to be added}*


### Glossary

* *Mainstream OS* - Windows 7, Windows 10, Linux, Unix, OS-X

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Instructions for manual testing**

### Launch and shutdown

1. Initial launch

   1. Download the jar file and copy into an empty folder

   1. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

1. Saving window preferences

   1. Resize the window to an optimum size. Move the window to a different location. Close the window.

   1. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

1. _{ more test cases …​ }_








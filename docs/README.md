# User Guide

## Features 

### Feature 1 
Description of feature.

## Usage

### Adding a todo: `todo`

Adds a `todo` to Duke. `todo` is a task that has a description.

Format: `todo DESCRIPTION`

Example of usage: `todo Read book`

Expected outcome:
```
Duke: Got it! I have added this task:
      [T][N] Read book
      Now you have 1 tasks in the list.
```
### Adding a deadline: `deadline`

Adds a deadline to Duke. `deadline` is a task that has a description,
and it must be done by a specified date and time.

Format: `deadline DESCRIPTION /by DATE_TIME`
- `DATE_TIME` must be in yyyy-MM-dd HHmm  format. E.g. `2020-09-20 1800`.

Example of usage: `deadline Finish TIC4001 quiz /by 2020-09-20 1800`

Expected outcome:
```
Duke: Got it! I have added this task:
      [D][N] Finish TIC4001 quiz (by: 20 Sep 2020 6:00PM)
      Now you have 2 tasks in the list.
```
### Adding an event: `event`

Adds an event to Duke. `event` is a task that has a description,
and it will happen at a specified time period.

Format: `event DESCRIPTION /at TIME_PERIOD`

Example of usage: `event Attend party /at 6 Sep 2-4PM`

Expected outcome:
```
Duke: Got it! I have added this task:
      [E][N] Attend party (at: 6 Sep 2-4PM)
      Now you have 3 tasks in the list.
```

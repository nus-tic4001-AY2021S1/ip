package NUS.Duke.DTO;

import java.util.Date;

public abstract class TaskDTO {
    private String taskName;
    private Date recordDate = new Date();
    private boolean isDone = false;

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }


    public TaskDTO() {
    }



    public void processDoneTask(){
        this.isDone = true;
        System.out.println(" Nice! I've marked this task as done: \n" +
                "[✓]"+this.taskName);
    }

    public abstract String getTaskType();

    @Override
    public String toString() {
        return taskName;
    }

    public abstract String getTaskFullDescription();

    public abstract String getPrintFileString();
}

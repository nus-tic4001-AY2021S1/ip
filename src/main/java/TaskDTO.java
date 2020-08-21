import java.util.Date;

public class TaskDTO {
    private String taskName;
    private Date recordDate;
    private int doneInd;
    private int taskId;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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

    public int getDoneInd() {
        return doneInd;
    }

    public void setDoneInd(int doneInd) {
        this.doneInd = doneInd;
    }
}

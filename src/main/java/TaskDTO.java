import java.util.Date;

public class TaskDTO {
    private String taskName;
    private Date recordDate;
    private TaskTypeEnum taskType;
    private int doneInd;
    private int taskId;
    private String deadlineDateString;



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

    public TaskDTO(String taskName, Date recordDate, TaskTypeEnum taskType, int doneInd, int taskId, String deadlineDateString) {
        this.taskName = taskName;
        this.recordDate = recordDate;
        this.taskType = taskType;
        this.doneInd = doneInd;
        this.taskId = taskId;
        this.deadlineDateString = deadlineDateString;
    }

    public TaskDTO() {
    }



    public void processDoneTask(){
        this.setDoneInd(1);
        System.out.println(" Nice! I've marked this task as done: \n" +
                "[✓]"+this.taskName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(taskId+". [");
        sb.append(taskType.getTypeShortForm());
        sb.append("][");
        int ascii = 0;
        if (doneInd==0){
            ascii = 0x2717;
        }else {
            ascii = 0x2713;

        }
        String sign = Character.toString((char)ascii);

        sb.append(sign +"]");
        sb.append(taskName);
        if (taskType != TaskTypeEnum.TODO){
            sb.append(deadlineDateString);
        }
        sb.append("\n");
        return sb.toString();
    }
}

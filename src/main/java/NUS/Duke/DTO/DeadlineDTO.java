package NUS.Duke.DTO;

public class DeadlineDTO extends TaskDTO {
    private String deadlineDateString;

    @Override
    public String getTaskType() {
        return "D";
    }

    public DeadlineDTO(String taskName , String deadlineDateString, int taskId) {
        this.setTaskName(taskName);
        this.deadlineDateString = deadlineDateString;
        this.setTaskId(taskId);
    }

    public String getDeadlineDateString() {
        return deadlineDateString;
    }

    public void setDeadlineDateString(String deadlineDateString) {
        this.deadlineDateString = deadlineDateString;
    }

    @Override
    public String toString() {
        return super.toString() +" (by: "+deadlineDateString+" )";
    }

    @Override
    public String getTaskFullDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(getTaskType());
        sb.append("]");
        sb.append("[");
        int ascii = 0;
        if (!isDone()){
            ascii = 0x2717;
        }else {
            ascii = 0x2713;
        }

        String sign = Character.toString((char)ascii);
        sb.append(sign +"]");
        sb.append(getTaskName());
        sb.append("(by: ");
        sb.append(deadlineDateString);
        sb.append(" )");
        return sb.toString();
    }
}

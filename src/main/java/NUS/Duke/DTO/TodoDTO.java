package NUS.Duke.DTO;

public class TodoDTO extends TaskDTO {
    public TodoDTO(String taskName,int taskId) {
        this.setTaskName(taskName);
        this.setTaskId(taskId);
    }

    @Override
    public String getTaskType() {
        return "T";
    }

    @Override
    public String toString() {
        return super.toString();
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
        return sb.toString();
    }
}

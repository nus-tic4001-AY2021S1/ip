package NUS.Duke.DTO;

import NUS.Duke.ProcessingException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeadlineDTO extends TaskDTO {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat printFormat = new SimpleDateFormat("yyyy MMM dd");
    private String deadlineDateString;
    private Date deadline;

    @Override
    public String getTaskType() {
        return "D";
    }

    public DeadlineDTO(String taskName , String deadlineDateString) throws ProcessingException {
        this.setTaskName(taskName);
        this.deadlineDateString = deadlineDateString;

        try {
            this.deadline = simpleDateFormat.parse(deadlineDateString);
        } catch (ParseException e) {
            throw new ProcessingException("Wrong date format. Please use the format as yyyy-mm-dd");
        }
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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
        sb.append(printFormat.format(deadline));
        sb.append(" )");
        return sb.toString();
    }

    @Override
    public String getPrintFileString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getTaskType());
        sb.append(" | ");

        if (!isDone()){
            sb.append("0");
        }else {
            sb.append("1");
        }
        sb.append(" | ");
        sb.append(getTaskName());
        sb.append(" | ");
        sb.append(deadlineDateString);
        sb.append("\n");
        return sb.toString();
    }

}

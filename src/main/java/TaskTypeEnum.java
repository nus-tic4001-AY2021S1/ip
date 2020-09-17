import java.util.HashMap;
import java.util.Map;

public enum TaskTypeEnum {

    TODO(0, "T"),
    DEADLINE(1, "D"),
    EVENT(2, "E");

    private Integer typeId;

    private String typeShortForm;

    TaskTypeEnum(final Integer typeId, final String typeShortForm) {
        this.typeId = typeId;
        this.typeShortForm = typeShortForm;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeShortForm() {
        return typeShortForm;
    }

    public void setTypeShortForm(String typeShortForm) {
        this.typeShortForm = typeShortForm;
    }

    public static TaskTypeEnum getTypeById(final Integer typeId) {
        for (TaskTypeEnum taskTypeEnum : TaskTypeEnum.values()) {
            if (taskTypeEnum.getTypeId().equals(typeId)) {
                return taskTypeEnum;
            }
        }
        return null;
    }

    public static TaskTypeEnum getTypeByDescription(final String typeDescription) {
        for (TaskTypeEnum taskTypeEnum : TaskTypeEnum.values()) {
            if (taskTypeEnum.getTypeShortForm().equals(typeDescription)) {
                return taskTypeEnum;
            }
        }
        return null;
    }


    public static Map<Integer, String> getMap() {
        Map<Integer, String> mMap = new HashMap<Integer, String>();
        for (TaskTypeEnum s : TaskTypeEnum.values()) {
            mMap.put(s.typeId, s.typeShortForm);
        }
        return mMap;
    }


}

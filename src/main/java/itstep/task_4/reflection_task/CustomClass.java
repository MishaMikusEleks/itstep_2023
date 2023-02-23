package itstep.task_4.reflection_task;

public class CustomClass {
    private String stringField = "stringFieldData";
    private Integer intValue = 666;

    @Override
    public String toString() {
        return "CustomClass{" +
                "stringField='" + stringField + '\'' +
                ", intValue=" + intValue +
                '}';
    }
}

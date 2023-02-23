package itstep.task_5;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class User implements Serializable, Comparable {

    @JsonProperty("_")
    private String name;
    private Integer age;
    private List<String> phoneList;

    @JsonIgnore
    private String uuid= UUID.randomUUID().toString();

    public User() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", phoneList=" + phoneList +
                ", uuid='" + uuid + '\'' +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        User o1=(User)this;
        User o2=(User)o;
        return o1.getName().compareTo(o2.getName());
    }
}

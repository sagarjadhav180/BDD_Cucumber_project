package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MachineDetails {
    private String id;
    private String name;
    private MachineData machineData;

    @Override
    public String toString() {
        return "MachineDetails{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", data=" + machineData +
                '}';
    }

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public MachineData getData() {
        return machineData;
    }
    public void setData(MachineData machineData) {
        this.machineData = machineData;
    }


}

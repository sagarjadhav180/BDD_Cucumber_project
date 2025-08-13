package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppleMacBookDetails {
    private String id;
    private String name;
    private AppleMacData data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AppleMacBookDetails{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", data=" + data +
                '}';
    }

    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public AppleMacData getData() {
        return data;
    }
    public void setData(AppleMacData data) {
        this.data = data;
    }
}

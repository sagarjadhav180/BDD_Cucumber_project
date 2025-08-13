package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MachineData {
    @JsonProperty("Generation")
    private String generation;

    @JsonProperty("Price")
    private String price;

    @JsonProperty("Capacity")
    private String capacity;

    // Getters and Setters
    public String getGeneration() {
        return generation;
    }
    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Data{" +
                "generation='" + generation + '\'' +
                ", price='" + price + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }

    public String getCapacity() {
        return capacity;
    }
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}

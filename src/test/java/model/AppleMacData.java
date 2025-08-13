package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppleMacData {
    private int year;
    private double price;

    @JsonProperty("CPU model")
    private String cpuModel;

    @JsonProperty("Hard disk size")
    private String hardDiskSize;

    // Getters and Setters
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getCpuModel() {
        return cpuModel;
    }
    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    @Override
    public String toString() {
        return "AppleMacBook{" +
                "year=" + year +
                ", price=" + price +
                ", cpuModel='" + cpuModel + '\'' +
                ", hardDiskSize='" + hardDiskSize + '\'' +
                '}';
    }

    public String getHardDiskSize() {
        return hardDiskSize;
    }
    public void setHardDiskSize(String hardDiskSize) {
        this.hardDiskSize = hardDiskSize;
    }
}

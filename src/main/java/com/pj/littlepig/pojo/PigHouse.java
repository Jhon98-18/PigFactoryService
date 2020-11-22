package com.pj.littlepig.pojo;

public class PigHouse {
    private Integer id;

    private String no;

    private String description;

    private Integer isdisinfection;

    private Integer factoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsdisinfection() {
        return isdisinfection;
    }

    public void setIsdisinfection(Integer isdisinfection) {
        this.isdisinfection = isdisinfection;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    @Override
    public String toString() {
        return "PigHouse{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", description='" + description + '\'' +
                ", isdisinfection=" + isdisinfection +
                ", factoryId=" + factoryId +
                '}';
    }
}

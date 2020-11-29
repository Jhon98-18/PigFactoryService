package com.pj.littlepig.pojo;

public class Factory {
    private Integer id;

    private String no;

    private String description;

    private String isdisinfection;

    private Integer factoryid;

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
        this.no = no == null ? null : no.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIsdisinfection() {
        return isdisinfection;
    }

    public void setIsdisinfection(String isdisinfection) {
        this.isdisinfection = isdisinfection == null ? null : isdisinfection.trim();
    }

    public Integer getFactoryid() {
        return factoryid;
    }

    public void setFactoryid(Integer factoryid) {
        this.factoryid = factoryid;
    }
}
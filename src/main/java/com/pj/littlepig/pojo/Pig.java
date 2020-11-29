package com.pj.littlepig.pojo;

public class Pig {
    private Integer id;

    private Integer type;

    private String variety;

    private Integer factoryid;

    private Integer pighouseid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety == null ? null : variety.trim();
    }

    public Integer getFactoryid() {
        return factoryid;
    }

    public void setFactoryid(Integer factoryid) {
        this.factoryid = factoryid;
    }

    public Integer getPighouseid() {
        return pighouseid;
    }

    public void setPighouseid(Integer pighouseid) {
        this.pighouseid = pighouseid;
    }
}
package com.pj.littlepig.Vo;

/*
 *猪条件查询前端展示信息
 */
public class PigPaginationInfo {
    private Integer currentPage;//当前页
    private Integer currentIndex;
    private Integer pageSize;//页码大小
    private Integer factoryId;//猪场id
    private Integer houseId;//猪舍id



    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCurrentIndex() {
        this.currentIndex = (this.getCurrentPage() - 1) * this.getPageSize();
        return currentIndex;
    }


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

}

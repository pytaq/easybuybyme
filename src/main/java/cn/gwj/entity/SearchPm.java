package cn.gwj.entity;

public class SearchPm {
    private Integer currentPageStr;
    private Integer pageSize;
    private String userName;
    private Integer sex;
    private Integer type;

    public Integer getCurrentPageStr() {
        return currentPageStr;
    }

    public void setCurrentPageStr(Integer currentPageStr) {
        this.currentPageStr = currentPageStr;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

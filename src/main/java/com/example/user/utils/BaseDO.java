package com.example.user.utils;

import java.util.Date;

public class BaseDO {
    /**
     * 主键id
     */
    private  Integer id;
    /**
     * 创建时间
     */
    private Date cteateDate;
    /**
     * 创建时间格式化
     */
    private String createDateStr;
    /**
     * 创建用户的id
     */
    private Integer createId;

    /**
     * 删除标记1.正常 0.删除 del_flag
     */
    private Integer delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCteateDate() {
        return cteateDate;
    }

    public void setCteateDate(Date cteateDate) {
        this.cteateDate = cteateDate;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

}

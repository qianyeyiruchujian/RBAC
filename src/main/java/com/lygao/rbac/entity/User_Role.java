package com.lygao.rbac.entity;

/**
 * @author lygao
 * @create 2020-02-17 21:12
 */
public class User_Role {
    private Integer assignid;
    private Integer userid;
    private Integer roleid;

    public User_Role() {
    }

    public User_Role(Integer assignid, Integer userid, Integer roleid) {
        this.assignid = assignid;
        this.userid = userid;
        this.roleid = roleid;
    }

    public Integer getAssignid() {
        return assignid;
    }

    public void setAssignid(Integer assignid) {
        this.assignid = assignid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "User_Role{" +
                "assignid=" + assignid +
                ", userid=" + userid +
                ", roleid=" + roleid +
                '}';
    }
}

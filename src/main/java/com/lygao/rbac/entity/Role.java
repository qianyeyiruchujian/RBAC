package com.lygao.rbac.entity;

/**
 * @author lygao
 * @create 2020-02-17 14:21
 */
public class Role {
    private Integer roleid;
    private String rolename;
    private String createtime;
    private String modifytime;

    public Role() {
    }

    public Role(Integer roleid, String rolename, String createtime, String modifytime) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.createtime = createtime;
        this.modifytime = modifytime;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", createtime='" + createtime + '\'' +
                ", modifytime='" + modifytime + '\'' +
                '}';
    }
}

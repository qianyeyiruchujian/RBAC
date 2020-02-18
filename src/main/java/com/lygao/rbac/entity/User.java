package com.lygao.rbac.entity;

/**
 * @author lygao
 * @create 2020-02-13 14:05
 */
public class User {
    private int id;
    private String account;
    private String name;
    private String password;
    private String email;
    private String duty;
    private String createtime;
    private String modifytime;

    public User() {
    }

    public User(int id, String account, String name, String password, String email, String duty, String createtime, String modifytime) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.password = password;
        this.email = email;
        this.duty = duty;
        this.createtime = createtime;
        this.modifytime = modifytime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
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
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", duty='" + duty + '\'' +
                ", createtime='" + createtime + '\'' +
                ", modifytime='" + modifytime + '\'' +
                '}';
    }
}

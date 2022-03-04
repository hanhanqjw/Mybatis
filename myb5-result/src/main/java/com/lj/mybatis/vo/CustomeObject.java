package com.lj.mybatis.vo;

/**
 * @author luojie
 * @Description
 * @date 2022/2/22 09/21
 */
public class CustomeObject {
    private Integer cid;
    private String cname;
    private String email;
    private Integer age;

    @Override
    public String toString() {
        return "CustomeObject{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

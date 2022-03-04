package com.lj.mybatis.vo;

/**
 * @author luojie
 * @Description
 * @date 2022/2/21 20/33
 */
public class Province {
    private Integer id;
    private String name;
    private Integer cid;
    private String cname;

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

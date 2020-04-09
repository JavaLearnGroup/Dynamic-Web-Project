package com.nf.entity;
import java.sql.Date;
public class LoveInHeart {
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Date getTime() {
        return time;
    }

    public Float getMoney() {
        return money;
    }

    private Integer id;
    private String name;
    private String sex;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    private Date time;
    private Float money;

    public LoveInHeart() {
    }

    public Integer getid(){
        return id;
    }
}

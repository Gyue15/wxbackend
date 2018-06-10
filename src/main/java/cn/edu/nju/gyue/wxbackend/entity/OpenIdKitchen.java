package cn.edu.nju.gyue.wxbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_kitchen")
public class OpenIdKitchen {
    @Id
    @Column(name = "open_id")
    private String openId;
    @Column(name = "kitchen")
    private Long kitchen;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Long getKitchen(){return kitchen;}

    public void setKitchen(Long kitchen){this.kitchen = kitchen;}
}

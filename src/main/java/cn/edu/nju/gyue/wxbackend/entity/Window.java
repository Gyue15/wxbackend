package cn.edu.nju.gyue.wxbackend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Window {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long windowId;

    private String windowName;

    private String photoUrl;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "canteen_id")
    private Canteen canteen;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "window")
    private List<Food> foods;

    public Long getWindowId() {
        return windowId;
    }

    public void setWindowId(Long windowId) {
        this.windowId = windowId;
    }

    public Canteen getCanteen() {
        return canteen;
    }

    public void setCanteen(Canteen canteen) {
        this.canteen = canteen;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public String getWindowName() {
        return windowName;
    }

    public void setWindowName(String windowName) {
        this.windowName = windowName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}

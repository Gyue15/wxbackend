package cn.edu.nju.gyue.wxbackend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Canteen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long canteenId;

    private String canteenName;

    private String password;

    private String photoUrl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "canteen")
    private List<Window> windows;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "school_id")
    private School school;

    public Long getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(Long canteenId) {
        this.canteenId = canteenId;
    }

    public String getCanteenName() {
        return canteenName;
    }

    public void setCanteenName(String canteenName) {
        this.canteenName = canteenName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}

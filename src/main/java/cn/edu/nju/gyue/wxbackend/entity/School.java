package cn.edu.nju.gyue.wxbackend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schoolId;

    private String schoolName;

    private String location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private List<Student> students;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private List<Canteen> canteens;

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Canteen> getCanteens() {
        return canteens;
    }

    public void setCanteens(List<Canteen> canteens) {
        this.canteens = canteens;
    }
}

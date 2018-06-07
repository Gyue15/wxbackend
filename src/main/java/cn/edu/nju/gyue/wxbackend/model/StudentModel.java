package cn.edu.nju.gyue.wxbackend.model;

public class StudentModel {
    private Long studentId;

    private String username;

    private boolean hasSchool;

    private Long schoolId;

    private String schoolName;

    private String location;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isHasSchool() {
        return hasSchool;
    }

    public void setHasSchool(boolean hasSchool) {
        this.hasSchool = hasSchool;
    }

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
}

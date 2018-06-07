package cn.edu.nju.gyue.wxbackend.model;

public class WindowModel {
    private Long windowId;

    private String windowName;

    private String photoUrl;

    public Long getWindowId() {
        return windowId;
    }

    public void setWindowId(Long windowId) {
        this.windowId = windowId;
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

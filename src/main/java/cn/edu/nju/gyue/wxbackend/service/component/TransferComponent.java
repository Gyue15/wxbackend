package cn.edu.nju.gyue.wxbackend.service.component;

import cn.edu.nju.gyue.wxbackend.entity.*;
import cn.edu.nju.gyue.wxbackend.model.*;
import org.springframework.stereotype.Component;

@Component
public class TransferComponent {

    public StudentModel toModel(Student student) {
        StudentModel studentModel = new StudentModel();
        studentModel.setUsername(student.getUsername());
        studentModel.setStudentId(student.getStudentId());
        studentModel.setHasSchool(student.getHasSchool());
        if (student.getHasSchool()) {
            School school = student.getSchool();
            studentModel.setSchoolId(school.getSchoolId());
            studentModel.setSchoolName(school.getSchoolName());
            studentModel.setLocation(school.getLocation());
        }
        return studentModel;
    }

    public SchoolModel toModel(School school) {
        SchoolModel schoolModel = new SchoolModel();
        schoolModel.setLocation(school.getLocation());
        schoolModel.setSchoolId(school.getSchoolId());
        schoolModel.setSchoolName(school.getSchoolName());
        return schoolModel;
    }

    public CanteenModel toModel(Canteen canteen) {
        CanteenModel canteenModel = new CanteenModel();
        canteenModel.setCanteenId(canteen.getCanteenId());
        canteenModel.setCanteenName(canteen.getCanteenName());
        canteenModel.setPhotoUrl(canteen.getPhotoUrl());
        return canteenModel;
    }

    public WindowModel toModel(Window window) {
        WindowModel windowModel = new WindowModel();
        windowModel.setWindowId(window.getWindowId());
        windowModel.setPhotoUrl(window.getPhotoUrl());
        windowModel.setWindowName(window.getWindowName());
        return windowModel;
    }

    public FoodModel toModel(Food food) {
        FoodModel foodModel = new FoodModel();
        foodModel.setFoodId(food.getFoodId());
        foodModel.setDescription(food.getDescription());
        foodModel.setFoodName(food.getFoodName());
        foodModel.setUpdateTime(food.getUpdateTime());
        foodModel.setPhotoUrl(food.getPhotoUrl());
        return foodModel;
    }

    public CommentModel toModel(Comment comment) {
        CommentModel commentModel = new CommentModel();
        commentModel.setCommentId(comment.getCommentId());
        commentModel.setComment(comment.getComment());
        commentModel.setRelatedId(comment.getRelatedId());
        commentModel.setIsReply(comment.getIsReply());
        commentModel.setUsername(comment.getUsername());
        commentModel.setCommentType(comment.getCommentType());
        return commentModel;
    }

}

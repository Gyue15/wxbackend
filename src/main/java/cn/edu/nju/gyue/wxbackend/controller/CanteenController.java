package cn.edu.nju.gyue.wxbackend.controller;

import cn.edu.nju.gyue.wxbackend.model.CanteenModel;
import cn.edu.nju.gyue.wxbackend.model.CommentModel;
import cn.edu.nju.gyue.wxbackend.model.FoodModel;
import cn.edu.nju.gyue.wxbackend.model.WindowModel;
import cn.edu.nju.gyue.wxbackend.parm.CommentType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/canteen", produces = "application/json;charset=UTF-8")
public class CanteenController {

    @GetMapping("/canteens")
    public List<CanteenModel> getCanteenList(@RequestParam("school-id") Long schoolId) {
        return null;
    }

    @GetMapping("/windows")
    public List<WindowModel> getWindowList(@RequestParam("canteen-id") Long canteenId) {
        return null;
    }

    @GetMapping("/foods")
    public List<FoodModel> getFoodList(@RequestParam("window-id") Long windowId) {
        return null;
    }

    @GetMapping("/comments")
    public List<CommentModel> getCommentList(@RequestParam("comment-type") CommentType commentType, @RequestParam
            ("related-id") Long relatedId) {
        return null;
    }

    @PostMapping("/comment")
    public void comment(CommentType commentType, Long studentId, String comment) {

    }

    @PostMapping("/reply-comment")
    public void replyComment(CommentType commentType, Long commentId, Long canteenId, String reply) {

    }

}

package cn.edu.nju.gyue.wxbackend.service;

import cn.edu.nju.gyue.wxbackend.model.CanteenModel;
import cn.edu.nju.gyue.wxbackend.model.CommentModel;
import cn.edu.nju.gyue.wxbackend.model.FoodModel;
import cn.edu.nju.gyue.wxbackend.model.WindowModel;
import cn.edu.nju.gyue.wxbackend.parm.CommentType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CanteenService {
    List<CanteenModel> getCanteenList(Long schoolId);

    List<WindowModel> getWindowList(Long canteenId);

    List<FoodModel> getFoodList(Long windowId);

    List<CommentModel> getCommentList(CommentType commentType, Long relatedId);

    void comment(CommentType commentType, Long studentId, Long relatedId, String comment);

    void replyComment(CommentType commentType, Long commentId, Long canteenId, String reply);
}

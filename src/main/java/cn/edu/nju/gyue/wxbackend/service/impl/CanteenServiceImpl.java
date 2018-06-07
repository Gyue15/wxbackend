package cn.edu.nju.gyue.wxbackend.service.impl;

import cn.edu.nju.gyue.wxbackend.entity.Canteen;
import cn.edu.nju.gyue.wxbackend.entity.Comment;
import cn.edu.nju.gyue.wxbackend.entity.Student;
import cn.edu.nju.gyue.wxbackend.exception.BadRequestException;
import cn.edu.nju.gyue.wxbackend.model.CanteenModel;
import cn.edu.nju.gyue.wxbackend.model.CommentModel;
import cn.edu.nju.gyue.wxbackend.model.FoodModel;
import cn.edu.nju.gyue.wxbackend.model.WindowModel;
import cn.edu.nju.gyue.wxbackend.parm.CommentType;
import cn.edu.nju.gyue.wxbackend.repository.*;
import cn.edu.nju.gyue.wxbackend.service.CanteenService;
import cn.edu.nju.gyue.wxbackend.service.component.TransferComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CanteenServiceImpl implements CanteenService {

    @Autowired
    private CanteenRepository canteenRepository;

    @Autowired
    private WindowRepository windowRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TransferComponent transferComponent;

    @Override
    public List<CanteenModel> getCanteenList(Long schoolId) {
        List<Canteen> canteenList = canteenRepository.findBySchool_SchoolId(schoolId);
        return canteenList.stream().map(transferComponent::toModel).collect(Collectors.toList());
    }

    @Override
    public List<WindowModel> getWindowList(Long canteenId) {
        return windowRepository.findByCanteen_CanteenId(canteenId).stream().map(transferComponent::toModel).collect
                (Collectors.toList());
    }

    @Override
    public List<FoodModel> getFoodList(Long windowId) {
        return foodRepository.findByWindow_WindowId(windowId).stream().map(transferComponent::toModel).collect
                (Collectors.toList());
    }

    @Override
    public List<CommentModel> getCommentList(CommentType commentType, Long relatedId) {
        return commentRepository.findByCommentTypeAndRelatedId(commentType, relatedId).stream().map
                (transferComponent::toModel).collect(Collectors.toList());
    }

    @Override
    public void comment(CommentType commentType, Long studentId, Long relatedId, String comment) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (!studentOptional.isPresent()) {
            throw new BadRequestException("该学生不存在");
        }
        Student student = studentOptional.get();
        Comment commentEntity = new Comment();
        commentEntity.setComment(comment);
        commentEntity.setRelatedId(relatedId);
        commentEntity.setReply(false);
        commentEntity.setUsername(student.getUsername());
        commentEntity.setCommentType(commentType);
        commentRepository.saveAndFlush(commentEntity);
    }

    @Override
    public void replyComment(CommentType commentType, Long commentId, Long canteenId, String reply) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (!commentOptional.isPresent()) {
            throw new BadRequestException("该评论不存在");
        }
        Comment comment = commentOptional.get();
        Optional<Canteen> canteenOptional = canteenRepository.findById(canteenId);
        if (!canteenOptional.isPresent()) {
            throw new BadRequestException("该食堂不存在");
        }
        Canteen canteen = canteenOptional.get();
        Comment commentEntity = new Comment();
        commentEntity.setComment(reply);
        commentEntity.setRelatedId(comment.getRelatedId());
        commentEntity.setReply(true);
        commentEntity.setUsername(canteen.getCanteenName());
        commentEntity.setCommentType(commentType);
        commentRepository.saveAndFlush(commentEntity);
    }
}

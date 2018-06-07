package cn.edu.nju.gyue.wxbackend.repository;

import cn.edu.nju.gyue.wxbackend.entity.Comment;
import cn.edu.nju.gyue.wxbackend.parm.CommentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByCommentTypeAndRelatedId(CommentType commentType, Long relatedId);
}

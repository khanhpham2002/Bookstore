package com.example.bai_tap_cuoi_ky_web.Service;

import com.example.bai_tap_cuoi_ky_web.Entity.Comment;
import com.example.bai_tap_cuoi_ky_web.Interface.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public void addComment(Comment comment){
        commentRepository.save(comment);
    }

    public List<Comment> cmFindByProductID(Integer productID) {
        return commentRepository.cmFindByProductID(productID);
    }

    public void deleteCommentByProductID(List<Comment> comments) {
        commentRepository.deleteAll(comments);
    }
}

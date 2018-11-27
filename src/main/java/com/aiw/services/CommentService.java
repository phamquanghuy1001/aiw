package com.aiw.services;

import com.aiw.entities.Comment;
import com.aiw.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getAll(){
      List<Comment> commentList = new ArrayList<>();
      commentRepository.findAll().forEach(commentList::add);
        return commentList;
    }
    public List<Comment> getAllByArticleId(long id){
        List<Comment> commentList = new ArrayList<>();
        commentRepository.findByIdarticle(id).forEach(commentList::add);
        return commentList;
    }
    public void deleteComment(long id){
        commentRepository.deleteById(id);
    }
    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }
}

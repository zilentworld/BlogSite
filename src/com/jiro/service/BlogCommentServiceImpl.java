package com.jiro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.dao.BlogCommentDao;
import com.jiro.model.BlogComment;

@Service
public class BlogCommentServiceImpl implements BlogCommentService {
    
    @Autowired
    BlogCommentDao blogCommentDao;
        
    public void setBlogCommentDao(BlogCommentDao blogCommentDao) {
        this.blogCommentDao = blogCommentDao;
    }

    public List<BlogComment> getPostCommentList(long postId) {
        return blogCommentDao.getBlogPostComments(postId);
    }
    
    public List<BlogComment> getUserCommentList(long userId) {
        return blogCommentDao.getBlogUserComments(userId);
    }
    
    public long postComment(BlogComment blogComment) {
        return blogCommentDao.persist(blogComment);
    }
    
    public void deleteComment(long commentId) {
        blogCommentDao.delete(blogCommentDao.get(commentId));
    }

}

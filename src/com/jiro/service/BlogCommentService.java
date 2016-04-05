package com.jiro.service;

import java.util.List;

import com.jiro.model.BlogComment;

public interface BlogCommentService {

    public List<BlogComment> getPostCommentList(long postId);
    
    public List<BlogComment> getUserCommentList(long postId);

    public long postComment(BlogComment blogComment);
    
    public void deleteComment(long commentId);

}

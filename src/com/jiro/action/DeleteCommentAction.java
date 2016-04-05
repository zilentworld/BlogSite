package com.jiro.action;

import com.jiro.service.BlogCommentService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCommentAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private BlogCommentService blogCommentService;
    private long commentId;
    private long postId;
    
    public BlogCommentService getBlogCommentService() {
        return blogCommentService;
    }

    public void setBlogCommentService(BlogCommentService blogCommentService) {
        this.blogCommentService = blogCommentService;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }
    
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Override
    public String execute() throws Exception {
        blogCommentService.deleteComment(commentId);
        return SUCCESS;
    }
    
}

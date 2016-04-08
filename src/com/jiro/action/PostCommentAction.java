package com.jiro.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jiro.model.BlogComment;
import com.jiro.service.BlogCommentService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class PostCommentAction extends ActionSupport implements SessionAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Map<String, Object> sessionMap;
    private BlogComment blogComment;
    private BlogCommentService blogCommentService;
    private String commentAction;

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public BlogCommentService getBlogCommentService() {
        return blogCommentService;
    }

    public void setBlogCommentService(BlogCommentService blogCommentService) {
        this.blogCommentService = blogCommentService;
    }
        
    public BlogComment getBlogComment() {
        return blogComment;
    }

    public void setBlogComment(BlogComment blogComment) {
        this.blogComment = blogComment;
    }
    
    public String getCommentAction() {
        return commentAction;
    }

    public void setCommentAction(String commentAction) {
        this.commentAction = commentAction;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public String execute() throws Exception {
        blogComment.getBlogUser().setUserId((long) sessionMap.get(Constants.SESSION_USERID));
        if(commentAction == null || "".equals(commentAction) || "new".equalsIgnoreCase(commentAction))
            blogCommentService.postComment(blogComment);
        else if("edit".equals(commentAction))
            blogCommentService.editComment(blogComment);
        
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (!sessionMap.containsKey(Constants.SESSION_USERID))
            addFieldError("blogComment.commentContent", "Kindly relog");
        if(blogComment.getCommentContent() == null || blogComment.getCommentContent().length() <= 0)
            addFieldError("blogComment.commentContent", "Please write a comment");
    }
    
    
}

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

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    @Override
    public String execute() throws Exception {
        long userId = 0L;
        if (sessionMap.containsKey(Constants.SESSION_USERID)) {
            userId = (long) sessionMap.get(Constants.SESSION_USERID);
        }

        blogComment.getBlogUser().setUserId((long)sessionMap.get(Constants.SESSION_USERID));
        long postId = blogComment.getBlogPost().getBlogPostId();
        String newComment = blogComment.getCommentContent();
        System.out.println("user:"+userId+", postContentId:"+postId+",newcomment:"+newComment);
        blogCommentService.postComment(blogComment);
        return SUCCESS;
    }
}

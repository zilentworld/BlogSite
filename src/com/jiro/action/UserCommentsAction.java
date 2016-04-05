package com.jiro.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jiro.model.BlogComment;
import com.jiro.service.BlogCommentService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class UserCommentsAction extends ActionSupport implements SessionAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Map<String, Object> sessionMap;
    private BlogCommentService blogCommentService;
    private List<BlogComment> userBlogComment;
    
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
    
    public List<BlogComment> getUserBlogComment() {
        return userBlogComment;
    }
    
    public void setUserBlogComment(List<BlogComment> userBlogComment) {
        this.userBlogComment = userBlogComment;
    }
    
    @Override
    public String execute() throws Exception {
        long userId = (long) sessionMap.get(Constants.SESSION_USERID);
        userBlogComment =  blogCommentService.getUserCommentList(userId);
        return SUCCESS;
    }
    
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

}

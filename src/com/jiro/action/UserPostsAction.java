package com.jiro.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jiro.model.BlogPost;
import com.jiro.service.BlogPostService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class UserPostsAction extends ActionSupport implements SessionAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Map<String, Object> sessionMap;
    private BlogPostService blogPostService;
    private List<BlogPost> userBlogPosts;

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public BlogPostService getBlogPostService() {
        return blogPostService;
    }

    public void setBlogPostService(BlogPostService blogCommentService) {
        this.blogPostService = blogCommentService;
    }

    public List<BlogPost> getUserBlogPosts() {
        return userBlogPosts;
    }

    public void setUserBlogPosts(List<BlogPost> userBlogPosts) {
        this.userBlogPosts = userBlogPosts;
    }
    
    @Override
    public String execute() throws Exception {
        System.out.println("USERPOSTS");
        long userId = (long) sessionMap.get(Constants.SESSION_USERID);
        userBlogPosts = blogPostService.getUserPosts(userId);
        System.out.println("userBlogPosts:"+userBlogPosts.size());
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

}

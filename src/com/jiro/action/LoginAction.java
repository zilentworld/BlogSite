package com.jiro.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.jiro.model.BlogUser;
import com.jiro.service.BlogUserService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    BlogUserService blogUserService;
    BlogUser blogUser;
    private Map<String, Object> sessionMap;
    private String msg;

    public void setBlogUserService(BlogUserService blogUserService) {
        this.blogUserService = blogUserService;
    }

    public void setBlogUser(BlogUser blogUser) {
        this.blogUser = blogUser;
    }

    public BlogUserService getBlogUserService() {
        return blogUserService;
    }

    public BlogUser getBlogUser() {
        return blogUser;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String execute() throws Exception {
        blogUser = blogUserService.getUserByLogin(blogUser.getUsername(), blogUser.getPassword());
        sessionMap.put(Constants.SESSION_USERNAME, blogUser.getUsername());
        sessionMap.put(Constants.SESSION_USERID, blogUser.getUserId());
        return SUCCESS;
    }
    
    @Override
    public void validate() {
        String username = blogUser.getUsername();
        String password = blogUser.getPassword();
        if (username == null || password == null) {
            addFieldError("blogUser.username", "Invalid login");
        } else if (!blogUserService.checkLogin(username, password)) {
            addFieldError("blogUser.username", "Invalid login");
        }
    }

    @SkipValidation
    public String postLogin() throws Exception {
        return LOGIN;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
}

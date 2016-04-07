package com.jiro.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.jiro.model.BlogUser;
import com.jiro.service.BlogUserService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterUserAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private BlogUser blogUser;
    private BlogUserService blogUserService;
    private String msg;
    
    public BlogUser getBlogUser() {
        return blogUser;
    }

    public void setBlogUser(BlogUser blogUser) {
        this.blogUser = blogUser;
    }

    public BlogUserService getBlogUserService() {
        return blogUserService;
    }

    public void setBlogUserService(BlogUserService blogUserService) {
        this.blogUserService = blogUserService;
    }
        
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String execute() throws Exception {
        msg = "Registration Successful";
        return SUCCESS;
    }
    
    @Override
    public void validate() {
        String username = blogUser.getUsername();
        String password = blogUser.getPassword();
        if (username == null || password == null) {
            addFieldError("blogUser.username", "Invalid login");
        }
        long userId = blogUserService.saveNewUser(blogUser);
        if(userId == 0)
            addFieldError("blogUser.username", "Error in creating user");
    }

    @SkipValidation
    public String postRegister() {
        return SUCCESS;
    }
        
}

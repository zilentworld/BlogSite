package com.jiro.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jiro.model.BlogPost;
import com.jiro.service.BlogPostService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class NewBlogPostAction extends ActionSupport implements SessionAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private long postId;
    private BlogPost blogPost;
    private BlogPostService blogPostService;
    private Map<String, Object> sessionMap;
    private String errMsg;
    private String postType;
        
    public BlogPost getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(BlogPost blogPost) {
        this.blogPost = blogPost;
    }
    
    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }
        
    public BlogPostService getBlogPostService() {
        return blogPostService;
    }

    public void setBlogPostService(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }
    
    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
    
    public boolean isErrMsg() {
        if(errMsg == null || "".equals(errMsg)) {
            return false;
        } else {
            return true;
        }
    }
    
    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("afas");
        blogPost.getBlogUser().setUserId((long)sessionMap.get(Constants.SESSION_USERID));
        if("edit".equals(postType))
            blogPostService.updateNewBlogPost(blogPost);
        else
            postId = blogPostService.saveNewBlogPost(blogPost);
        System.out.println("HHHH" + postId);
        if(postId > 0)
            return SUCCESS;
        else {
            return ERROR;
        }
    }
    
    public String createPost() {
        return SUCCESS;
    }
    
    public String editPost() {
        blogPost = blogPostService.getBlogPost(postId, true);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

}

package com.jiro.action;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
    private String title;
    private String content;
        
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
            
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        blogPost.getBlogUser().setUserId((long)sessionMap.get(Constants.SESSION_USERID));
        System.out.println("postType:"+postType);
        System.out.println("postContent:"+blogPost.getPostContent());
        if("edit".equalsIgnoreCase(postType)) {
            System.out.println("EDIT:postId:"+postId+", blogPost.postId:"+blogPost.getBlogPostId());
            blogPostService.updateNewBlogPost(blogPost);
            postId = blogPost.getBlogPostId();
        } else {
            postId = blogPostService.saveNewBlogPost(blogPost);
        }
        if(postId > 0)
            return SUCCESS;
        else
            return ERROR;
    }
    
    public String createPost() {
        System.out.println("TEST2:title:"+title+", content:"+content);
        if(!StringUtils.isEmpty(title)) {
            if(blogPost == null) 
                blogPost = new BlogPost();
            blogPost.setBlogTitle(title);
        }
        if(!StringUtils.isEmpty(content)) {
            if(blogPost == null) 
                blogPost = new BlogPost();
            blogPost.setPostContent(content);
        }
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

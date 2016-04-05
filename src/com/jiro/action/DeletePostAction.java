package com.jiro.action;

import com.jiro.service.BlogPostService;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePostAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private BlogPostService blogPostService;
    private long postId;
        
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

    @Override
    public String execute() throws Exception {
        blogPostService.deletePost(postId);
        return SUCCESS;
    }
        
}

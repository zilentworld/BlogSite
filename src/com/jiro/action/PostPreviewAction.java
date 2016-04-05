package com.jiro.action;

import java.util.List;

import com.jiro.model.BlogPost;
import com.jiro.service.BlogPostService;
import com.opensymphony.xwork2.ActionSupport;

public class PostPreviewAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private BlogPostService blogPostService;
    private List<BlogPost> postPreview;
    private long lastPostId;
    private int previewCount;

    public BlogPostService getBlogPostService() {
        return blogPostService;
    }

    public void setBlogPostService(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }
        
    public List<BlogPost> getPostPreview() {
        return postPreview;
    }

    public void setPostPreview(List<BlogPost> postPreview) {
        this.postPreview = postPreview;
    }
    
    public long getLastPostId() {
        return lastPostId;
    }

    public void setLastPostId(long lastPostId) {
        this.lastPostId = lastPostId;
    }

    public int getPreviewCount() {
        return previewCount;
    }

    public void setPreviewCount(int previewCount) {
        this.previewCount = previewCount;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("PRINT PREVIEW");
        if(previewCount <= 0) 
            previewCount = 20;
        postPreview = blogPostService.generatePostsPreviews(lastPostId, previewCount);
        return SUCCESS;
    }
}

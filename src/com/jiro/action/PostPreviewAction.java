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

    @Override
    public String execute() throws Exception {
        System.out.println("PRINT PREVIEW");
        postPreview = blogPostService.generatePostsPreviews(0, 20);
        return SUCCESS;
    }
}

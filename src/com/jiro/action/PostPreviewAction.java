package com.jiro.action;

import java.util.List;

import com.jiro.model.BlogPost;
import com.jiro.service.BlogPostService;
import com.jiro.utility.Constants;
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
    private boolean isNext;
    private int currPage;

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
    
    public boolean isNext() {
        return isNext;
    }

    public void setNext(boolean isNext) {
        this.isNext = isNext;
    }
    
    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    @Override
    public String execute() throws Exception {
        if(previewCount <= 0) 
            previewCount = Constants.POST_PREVIEW_DEFAULT_COUNT;
        if(currPage <= 0) 
            currPage = 1;
        postPreview = blogPostService.generatePostsPreviews(currPage, previewCount);
        if(postPreview != null && postPreview.size() > 0)
            lastPostId = postPreview.get(postPreview.size()-1).getBlogPostId();
        else
            lastPostId = 0;
       
        isNext = blogPostService.isNextButton(lastPostId);
                 
        return SUCCESS;
    }
}

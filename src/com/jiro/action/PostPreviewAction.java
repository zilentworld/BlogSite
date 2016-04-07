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
    private long oldLastPostId;
    private long lastPostId;
    private int previewCount;
    private boolean isNext;
    private boolean isBack;

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
    
    public boolean isBack() {
        return isBack;
    }

    public void setBack(boolean isBack) {
        this.isBack = isBack;
    }
    
    public long getOldLastPostId() {
        return oldLastPostId;
    }

    public void setOldLastPostId(long oldLastPostId) {
        this.oldLastPostId = oldLastPostId;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("PRINT PREVIEW");
        if(previewCount <= 0) 
            previewCount = Constants.POST_PREVIEW_DEFAULT_COUNT;
        postPreview = blogPostService.generatePostsPreviews(lastPostId, previewCount);
        isNext = blogPostService.isNextButton(lastPostId, previewCount);
        oldLastPostId = lastPostId;
        lastPostId = postPreview.get(previewCount).getBlogPostId();
                
        return SUCCESS;
    }
}

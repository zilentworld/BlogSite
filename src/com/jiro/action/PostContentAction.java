package com.jiro.action;

import java.util.List;

import com.jiro.model.BlogComment;
import com.jiro.model.BlogPost;
import com.jiro.service.BlogCommentService;
import com.jiro.service.BlogPostService;
import com.opensymphony.xwork2.ActionSupport;

public class PostContentAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String postId;
    private BlogPost blogPost;
    private BlogPostService blogPostService;
    private List<BlogComment> blogComments;
    private BlogCommentService blogCommentService;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public BlogPostService getBlogPostService() {
        return blogPostService;
    }

    public void setBlogPostService(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(BlogPost blogPost) {
        this.blogPost = blogPost;
    }

    public List<BlogComment> getBlogComments() {
        return blogComments;
    }

    public void setBlogComments(List<BlogComment> blogComments) {
        this.blogComments = blogComments;
    }
    
    public BlogCommentService getBlogCommentService() {
        return blogCommentService;
    }

    public void setBlogCommentService(BlogCommentService blogCommentService) {
        this.blogCommentService = blogCommentService;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("PRINT CONTENT:"+postId);
        try {
            getPostContent(Long.parseLong(this.postId));
//            getPostContent(postId);
        } catch (NumberFormatException e) {
            blogPost = null;
        }

        return SUCCESS;
    }
    
    private void getPostContent(long postIdLong) {
        try {
            blogPost = blogPostService.getBlogPost(postIdLong, false);
            if(blogPost.getBlogUser().getUserId() > 0) {
                blogComments = blogCommentService.getPostCommentList(blogPost.getBlogPostId());
                System.out.println("1");
                System.out.println(blogComments.size());                    
            } else {
                blogPost = null;
            }
        } catch (NullPointerException e) {
            blogPost = null;
        }
    }
    
}

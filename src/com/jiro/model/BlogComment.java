package com.jiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="blog_comment")
public class BlogComment {
    
    private long commentId;
    private long replyTo;
//    private long userId;
//    private long blogPostId;
    private String commentContent;
    private BlogUser blogUser;
    private BlogPost blogPost;

    @Column(name="comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public long getCommentId() {
        return commentId;
    }
    
    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    @Column(name="reply_to")
    public long getReplyTo() {
        return replyTo;
    }
    
    public void setReplyTo(long replyTo) {
        this.replyTo = replyTo;
    }

//    @Column(name="user_id")
//    public long getUserId() {
//        return userId;
//    }
//    
//    public void setUserId(long userId) {
//        this.userId = userId;
//    }

    @Column(name="comment_content")
    public String getCommentContent() {
        return commentContent;
    }
    
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
    
//    @Column(name="blog_post_id")
//    public long getBlogPostId() {
//        return blogPostId;
//    }
//    
//    public void setBlogPostId(long blogPostId) {
//        this.blogPostId = blogPostId;
//    }

    @ManyToOne
    @JoinColumn(name = "blog_post_id")
    public BlogPost getBlogPost() {
        return blogPost;
    }
    
    public void setBlogPost(BlogPost blogPost) {
        this.blogPost = blogPost;
    }
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    public BlogUser getBlogUser() {
        return blogUser;
    }
    
    public void setBlogUser(BlogUser blogUser) {
        this.blogUser = blogUser;
    }
    
    public BlogComment() {    
    }

    public BlogComment(long replyTo, String commentContent) {
        this.replyTo = replyTo;
        this.commentContent = commentContent;
    }    
}

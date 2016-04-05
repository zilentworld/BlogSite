package com.jiro.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="blog_post")
public class BlogPost {
    
    private long blogPostId;
    private String blogUrl;
//    private long posterUserId;
    private String blogTitle;
    private String postContent;
    private String postPreview;
    private BlogUser blogUser;
    private Set<BlogComment> blogComments;
    
    @Column(name="blog_post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public long getBlogPostId() {
        return blogPostId;
    }
    public void setBlogPostId(long blogPostId) {
        this.blogPostId = blogPostId;
    }

    @Column(name="blog_url")
    public String getBlogUrl() {
        return blogUrl;
    }
    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

//    @Column(name="poster_user_id")
//    public long getPosterUserId() {
//        return posterUserId;
//    }
//    public void setPosterUserId(long posterUserId) {
//        this.posterUserId = posterUserId;
//    }

    @Column(name="blog_title")
    public String getBlogTitle() {
        return blogTitle;
    }
    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    @Column(name="post_content")
    public String getPostContent() {
        return postContent;
    }
    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
    
    @Column(name="post_preview")
    public String getPostPreview() {
        return postPreview;
    }
    public void setPostPreview(String postPreview) {
        this.postPreview = postPreview;
    }

    @ManyToOne
    @JoinColumn(name = "poster_user_id")
    public BlogUser getBlogUser() {
        return blogUser;
    }
    
    public void setBlogUser(BlogUser blogUser) {
        this.blogUser = blogUser;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blogPost", fetch = FetchType.LAZY)
    public Set<BlogComment> getBlogComments() {
        return blogComments;
    }
    
    public void setBlogComments(Set<BlogComment> blogComments) {
        this.blogComments = blogComments;
    }
    
    public BlogPost() { }
    
    public BlogPost(String blogTitle, String postContent, String postPreview) {
        this.blogTitle = blogTitle;
        this.postContent = postContent;
        this.postPreview = postPreview;
    }
    
}
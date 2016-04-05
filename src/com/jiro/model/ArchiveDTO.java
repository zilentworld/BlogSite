package com.jiro.model;

import java.math.BigInteger;


public class ArchiveDTO {
    
    private String postYear;
    private String postMonth;
    private String postDay;
    private BigInteger blogPostId;
    private BigInteger posterUserId;
    private String blogTitle;
    
    public String getPostYear() {
        return postYear;
    }
    public void setPostYear(String postYear) {
        this.postYear = postYear;
    }
    public String getPostMonth() {
        return postMonth;
    }
    public void setPostMonth(String postMonth) {
        this.postMonth = postMonth;
    }
    public String getPostDay() {
        return postDay;
    }
    public void setPostDay(String postDay) {
        this.postDay = postDay;
    }
    
    public BigInteger getBlogPostId() {
        return blogPostId;
    }
    public void setBlogPostId(BigInteger blogPostId) {
        this.blogPostId = blogPostId;
    }
    public BigInteger getPosterUserId() {
        return posterUserId;
    }
    public void setPosterUserId(BigInteger posterUserId) {
        this.posterUserId = posterUserId;
    }
    public String getBlogTitle() {
        return blogTitle;
    }
    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }
    
    @Override
    public String toString() {
        return "year:" + postYear + ", month:" + postMonth + ",day:" + postDay +  ", postID:" + blogPostId 
                + ", posterUserId:" + posterUserId + ", blog_title:" + blogTitle;
    }

}

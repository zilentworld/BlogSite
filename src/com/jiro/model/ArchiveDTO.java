package com.jiro.model;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ArchiveDTO implements Comparable<ArchiveDTO> {

    private String postYear;
    private String postMonth;
    private String postMonthNum;
    private String postDay;
    private BigInteger blogPostId;
    private BigInteger posterUserId;
    private String blogTitle;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

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
    

    public String getPostMonthNum() {
        return postMonthNum;
    }

    public void setPostMonthNum(String postMonthNum) {
        this.postMonthNum = postMonthNum;
    }

    @Override
    public String toString() {
        return "year:" + postYear + ", month:" + postMonth +  ", monthNum:" + postMonthNum + ",day:" + postDay
                + ", postID:" + blogPostId + ", posterUserId:" + posterUserId
                + ", blog_title:" + blogTitle;
    }

    public ArchiveDTO(BlogPost blogPost) {
        blogPostId = BigInteger.valueOf(blogPost.getBlogPostId());
        posterUserId = BigInteger.valueOf(blogPost.getBlogUser().getUserId());
        blogTitle = blogPost.getBlogTitle();
        dateTime = blogPost.getDateTime();
        postYear = new SimpleDateFormat("yyyy").format(dateTime);
        postMonth = new SimpleDateFormat("MMMMM").format(dateTime);
        postMonthNum = new SimpleDateFormat("MM").format(dateTime);
        postDay = new SimpleDateFormat("dd").format(dateTime);
    }

    @Override
    public int compareTo(ArchiveDTO archiveDTO2) {
        int archive1PostYear = Integer.parseInt(this.postYear);
        int archive2PostYear = Integer.parseInt(archiveDTO2.getPostYear());
        int archive1PostMonth = Integer.parseInt(this.postMonthNum);
        int archive2PostMonth = Integer.parseInt(archiveDTO2.getPostMonthNum());
        int archive1PostDay = Integer.parseInt(this.postDay);
        int archive2PostDay = Integer.parseInt(archiveDTO2.getPostDay());
        
        int holder = archive1PostYear - archive2PostYear;
        if(holder != 0) {
            return holder * -1;
        
        holder = archive1PostMonth - archive2PostMonth;
        if(holder != 0)
            return holder;
        
        holder = archive1PostDay - archive2PostDay;
        if(holder != 0)
            return holder;
        return this.blogPostId.compareTo(archiveDTO2.getBlogPostId());
    }

}

package com.jiro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiro.dao.BlogPostDao;
import com.jiro.model.ArchiveDTO;
import com.jiro.model.BlogPost;
import com.jiro.utility.HtmlUtility;

public class BlogPostServiceImpl implements BlogPostService {

    @Autowired
    BlogPostDao blogPostDao;

    public void setBlogPostDao(BlogPostDao blogPostDao) {
        this.blogPostDao = blogPostDao;
    }

    public List<BlogPost> generatePostsPreviews(long lastPost, int postCount) {
        return blogPostDao.getPostPreview(lastPost, postCount);
    }

    public List<BlogPost> getUserPosts(long userId) {
        return blogPostDao.getUserPost(userId);
    }

    public BlogPost getPostContent(long postId) {
        return (BlogPost) blogPostDao.get(postId);
    }

    public long saveNewBlogPost(BlogPost blogPost) {
        return blogPostDao.persist(blogPost);
    }

    public void deletePost(long postId) {
        blogPostDao.delete(blogPostDao.get(postId));
    }

    @SuppressWarnings("rawtypes")
    public Map getBlogPostArchive() {
        System.out.println("BBBB");
        Map<String, LinkedHashMap<String, List<String>>> yearMap = new LinkedHashMap<String, LinkedHashMap<String, List<String>>>();
        List<ArchiveDTO> archiveDTOs = blogPostDao.getBlogPostArchive();
        System.out.println("START ARCHIVE DTO");
        for (ArchiveDTO archiveDTO : archiveDTOs) {
            String postYear = archiveDTO.getPostYear();
            String postMonth = archiveDTO.getPostMonth();
            LinkedHashMap<String, List<String>> monthMap;
            List<String> links;
            if (yearMap.containsKey(postYear)) {
                monthMap = yearMap.get(postYear);
            } else {
                monthMap = new LinkedHashMap<String, List<String>>();
            }
            if (monthMap.containsKey(postMonth)) {
                links = monthMap.get(postMonth);
            } else {
                links = new ArrayList<String>();
            }
            links.add(HtmlUtility.generateActionHref("postContentActionBean",
                    archiveDTO.getBlogTitle(), "postId",
                    archiveDTO.getBlogPostId()));
            monthMap.put(postMonth, links);
            yearMap.put(postYear, monthMap);
        }
        System.out.println("SERVICE ARCHIVE:" + yearMap.size());
        return yearMap;
    }

    @SuppressWarnings("rawtypes")
    public List getBlogPostData() {
        return blogPostDao.getBlogPostData();
    }

}

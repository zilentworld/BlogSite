package com.jiro.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
        List<BlogPost> blogPostList = blogPostDao.getPostPreview(lastPost,
                postCount);
        blogPostList.forEach(e -> e.setPostContent(postContentManipulation(
                                        e.getPostContent(), "postPreview")));

        return blogPostList;
    }

    public List<BlogPost> getUserPosts(long userId) {
        return blogPostDao.getUserPost(userId);
    }

    public BlogPost getBlogPost(long postId, boolean rawData) {
        BlogPost blogPost = (BlogPost) blogPostDao.get(postId);
        if (!rawData)
            blogPost.setPostContent(postContentManipulation(
                    blogPost.getPostContent(), "postContent"));
        return blogPost;
    }

    public long saveNewBlogPost(BlogPost blogPost) {
        return blogPostDao.persist(blogPost);
    }

    public void updateNewBlogPost(BlogPost blogPost) {
        blogPostDao.saveOrUpdate(blogPost);
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
    public List getBlogPostDataProjection(String... projectionVars) {
        if (projectionVars.length >= 2) {
            DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BlogPost.class);
            ProjectionList projectionList = Projections.projectionList();
            try {
                for (int a = 0; a < projectionVars.length; a += 2) {
                    switch (projectionVars[a].toUpperCase()) {
                    case "MAX":
                        projectionList.add(Projections
                                .max(projectionVars[a + 1]));
                        break;
                    case "COUNT":
                        projectionList.add(Projections
                                .count(projectionVars[a + 1]));
                    default:
                        break;
                    }
                }
                detachedCriteria.setProjection(projectionList);
                return blogPostDao.getBlogPostData(detachedCriteria);
            } catch (ArrayIndexOutOfBoundsException e) {
                return null;
            }
        } else {
            return null;
        }
    }
    
    public boolean isNextButton(long startPostId, int displayCount) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BlogPost.class);
        detachedCriteria.add(Restrictions.gt("blogPostId", startPostId))
            .setProjection(Projections.count("blogPostId"))
            .addOrder(Order.desc("blogPostId"));
        int postCount = (int) blogPostDao.getBlogPostData(detachedCriteria).get(0);
        return postCount > displayCount;
    }
    

    private String postContentManipulation(String postContent, String displayFor) {
        String holder = postContent;

        while (holder.contains("<image>") || holder.contains("</image")) {
            int imgIdxStart = holder.indexOf("<image>");
            int imgIdxEnd = holder.indexOf("</image>");
            if (imgIdxStart > imgIdxEnd)
                break;

            if ("postContent".equals(displayFor)) {
                String imgString = "<div style=\"heigth:800px;width:800px;\"><img src=\""
                        + holder.substring(imgIdxStart + 7, imgIdxEnd)
                                .replaceAll("(\\r|\\n|\\r\\n)+", "")
                        + "\" style=\"max-width:100%; max-height:100%\"></img></div>";
                holder = holder.substring(0, imgIdxStart) + imgString
                        + holder.substring(imgIdxEnd + 8);
            } else { // postPreview and others
                holder = holder.substring(0, imgIdxStart)
                        + holder.substring(imgIdxEnd + 8);
            }
            System.out.println("HOLDER:" + holder);
        }
        holder = "<p>" + holder.replaceAll("(\\r|\\n|\\r\\n)+", "</p><p>")
                + "</p>";

        return holder;
    }

}

package com.jiro.service;

import java.util.List;
import java.util.Map;

import com.jiro.model.BlogPost;

public interface BlogPostService {
    
    public List<BlogPost> generatePostsPreviews(long lastPost, int postCount);
    
    public BlogPost getPostContent(long postId);
    
    public long saveNewBlogPost(BlogPost blogPost);
    
    public List<BlogPost> getUserPosts(long userId);
    
    public void deletePost(long postId);
    
    @SuppressWarnings("rawtypes")
    public Map getBlogPostArchive();
    
    /**
     * 
     * @return Object[1] = max(blog_post_id) <br>
     *         Object[2] = count(blog_post_id)
     */
    @SuppressWarnings("rawtypes")
    public List getBlogPostData();
}

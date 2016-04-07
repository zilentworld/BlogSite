package com.jiro.service;

import java.util.List;
import java.util.Map;

import com.jiro.model.BlogPost;

public interface BlogPostService {
    
    public List<BlogPost> generatePostsPreviews(int currPage, int postCount);
    
    public BlogPost getBlogPost(long postId, boolean rawData);
    
    public long saveNewBlogPost(BlogPost blogPost);
    
    public void updateNewBlogPost(BlogPost blogPost);
    
    public void deletePost(long postId);
    
    public List<BlogPost> getUserPosts(long userId);
        
    @SuppressWarnings("rawtypes")
    public Map getBlogPostArchive();
    
    /**
     * Requires pairs of Strings, <br>
     * x = first of the pair and y = second of the pair
     * 
     * @param 
     *        String[x] = projection type (max, count) <br>
     *        String[y] = column 
     */
    @SuppressWarnings("rawtypes")
    public List getBlogPostDataProjection(String... projectionVars);
        
    public boolean isNextButton(long startPostId);
}

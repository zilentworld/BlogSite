package com.jiro.dao;

import java.io.Serializable;
import java.util.List;

import com.jiro.model.ArchiveDTO;
import com.jiro.model.BlogPost;

public interface BlogPostDao extends GenericDao {

    public BlogPost get(Serializable value);

    public List<BlogPost> getList();

    public List<BlogPost> getPostPreview(long lastPostId, int maxResults);
    
    public List<BlogPost> getUserPost(long userId);
    
    public List<ArchiveDTO> getBlogPostArchive();
    
    public List getBlogPostData();
}

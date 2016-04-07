package com.jiro.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.jiro.model.ArchiveDTO;
import com.jiro.model.BlogPost;

public interface BlogPostDao extends GenericDao {

    public BlogPost get(Serializable value);

    public List<BlogPost> getList();

    public List<BlogPost> getPostPreview(int currPage, int maxResults);
    
    public List<BlogPost> getUserPost(long userId);
    
    public List<ArchiveDTO> getBlogPostArchive();
    
    @SuppressWarnings("rawtypes")
    public List getBlogPostData(DetachedCriteria detachedCriteria);
}

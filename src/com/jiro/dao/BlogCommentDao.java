package com.jiro.dao;

import java.util.List;

import com.jiro.model.BlogComment;

public interface BlogCommentDao extends GenericDao {

    public BlogComment get(long commentId);

    public List<BlogComment> getBlogPostComments(long postId);

    public List<BlogComment> getBlogUserComments(long userId);
}

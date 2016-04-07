package com.jiro.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.model.BlogComment;

@Repository
public class BlogCommentDaoImpl extends GenericDaoImpl implements BlogCommentDao {

    @Transactional
    public BlogComment get(long commentId) {
        return (BlogComment) super.get(BlogComment.class, commentId);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<BlogComment> getBlogPostComments(long postId) {
        return getCurrentSession().createCriteria(BlogComment.class)
                .addOrder(Order.desc("commentId"))
                .createCriteria("blogPost")
                    .add(Restrictions.eq("blogPostId", postId))
                .list();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<BlogComment> getBlogUserComments(long userId) {
        return (List<BlogComment>) getCurrentSession()
                .createCriteria(BlogComment.class)
                .addOrder(Order.desc("commentId"))
                .createCriteria("blogUser")
                    .add(Restrictions.eq("userId", userId))
                .list();
    }
}

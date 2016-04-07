package com.jiro.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.model.ArchiveDTO;
import com.jiro.model.BlogPost;

@Repository
public class BlogPostDaoImpl extends GenericDaoImpl implements BlogPostDao {

    @Transactional
    public BlogPost get(Serializable value) {
        return (BlogPost) super.get(BlogPost.class, value);
    }

    @SuppressWarnings("unchecked")
    public List<BlogPost> getList() {
        return (List<BlogPost>) super.getList(BlogPost.class);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<BlogPost> getPostPreview(long lastPostId, int maxResults) {
        return (List<BlogPost>) getCurrentSession()
                .createCriteria(BlogPost.class)
                .add(Restrictions.gt("blogPostId", lastPostId))
                .addOrder(Order.desc("blogPostId"))
                .setMaxResults(maxResults)
                .list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<BlogPost> getUserPost(long userId) {
        return (List<BlogPost>) getCurrentSession()
                .createCriteria(BlogPost.class)
                .addOrder(Order.desc("blogPostId")).createCriteria("blogUser")
                .add(Restrictions.eq("userId", userId)).list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<ArchiveDTO> getBlogPostArchive() {
        System.out.println("AAAAA");
        String sql = "select blog_post_id as blogPostId, "
                + "poster_user_id as posterUserId, "
                + "blog_title as blogTitle, "
                + "DATE_FORMAT(date_time,'%Y') as postYear, "
                + "DATE_FORMAT(date_time,'%M') as postMonth, "
                + "DATE_FORMAT(date_time,'%e') as postDay "
                + "from blog_post b " + "order by year(date_time) desc, "
                + "month(date_time), " + "day(date_time), "
                + "blog_post_id asc;";

        return (List<ArchiveDTO>) getCurrentSession()
                .createSQLQuery(sql)
                .addScalar("blogPostId")
                .addScalar("posterUserId")
                .addScalar("blogTitle")
                .addScalar("postYear")
                .addScalar("postMonth")
                .addScalar("postDay")
                .setResultTransformer(
                        Transformers.aliasToBean(ArchiveDTO.class)).list();
    }

    @SuppressWarnings("rawtypes")
    @Transactional
    public List getBlogPostData(DetachedCriteria detachedCriteria) {
        return detachedCriteria.getExecutableCriteria(getCurrentSession())
                .list();
    }
}

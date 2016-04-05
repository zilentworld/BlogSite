package com.jiro.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jiro.model.BlogPost;
import com.jiro.model.BlogUser;

@Repository
public class BlogUserDaoImpl extends GenericDaoImpl implements BlogUserDao {
    
    public BlogUser get(long userId) {
        return (BlogUser) super.get(BlogPost.class, userId);
    }

    @SuppressWarnings("unchecked")
    public List<BlogUser> getList() {
        // TODO Auto-generated method stub
        return (List<BlogUser>) super.getList(BlogPost.class);
    }

    @Transactional
    public BlogUser getUserByLogin(String username, String password) {
        try {
            return (BlogUser) getCurrentSession()
                                .createCriteria(BlogUser.class)
                                .add(Restrictions.eq("username",username))
                                .add(Restrictions.eq("password", password)).uniqueResult();
        } catch (Exception ne) {
            ne.printStackTrace();
            return null;
        }
    }


}

package com.jiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiro.dao.BlogUserDao;
import com.jiro.model.BlogUser;

@Service
public class BlogUserServiceImpl implements BlogUserService {
    
    @Autowired
    BlogUserDao blogUserDao;
    
    public void setBlogUserDao(BlogUserDao blogUserDao) {
        this.blogUserDao = blogUserDao;
    }
    
    public boolean checkLogin(String username, String password) {
        BlogUser blogUser = blogUserDao.getUserByLogin(username, password);
        if(blogUser == null) {
            return false;
        } else {
            if(blogUser.getUserId() > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public BlogUser getUserByLogin(String username, String password) {
        return blogUserDao.getUserByLogin(username, password);
    }
    
    public long saveNewUser(BlogUser blogUser) {
        return blogUserDao.persist(blogUser);
    }
    
}

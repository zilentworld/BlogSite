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
        System.out.println("username:"+username + ", password:"+password);
        BlogUser blogUser = blogUserDao.getUserByLogin(username, password);
        if(blogUser == null) {
            System.out.println("null");
            return false;
        } else {
            if(blogUser.getUserId() > 0) {
                System.out.println(">0");
                return true;
            } else {
                System.out.println("else");
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

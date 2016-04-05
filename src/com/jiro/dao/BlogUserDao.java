package com.jiro.dao;

import java.util.List;

import com.jiro.model.BlogUser;

public interface BlogUserDao extends GenericDao {
    
    public BlogUser get(long userId);

    public List<BlogUser> getList();

    public BlogUser getUserByLogin(String username, String password);

}

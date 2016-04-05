package com.jiro.service;

import com.jiro.model.BlogUser;

public interface BlogUserService {
    
    public boolean checkLogin(String username, String password);
    
    public BlogUser getUserByLogin(String username, String password);
    
    public long saveNewUser(BlogUser blogUser);

}

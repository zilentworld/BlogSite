package com.jiro.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware  {

    private Map<String, Object> sessionMap;

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Override
    public String execute() throws Exception {
        sessionMap.remove(Constants.SESSION_USERNAME);
        sessionMap.remove(Constants.SESSION_USERID);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

}

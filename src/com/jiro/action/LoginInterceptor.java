package com.jiro.action;

import java.util.Map;

import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("LOGIN INTERCEPT");
        Map<String, Object> sessionMap = ActionContext.getContext()
                .getSession();
        
        if(sessionMap.get(Constants.SESSION_USERID) == null)
            return invocation.invoke();
        else
            return "FORCELOGIN";
    }
    
}

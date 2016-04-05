package com.jiro.action;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.jiro.model.BlogPost;
import com.jiro.service.BlogPostService;
import com.jiro.utility.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ArchiveInterceptor implements Interceptor {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    private BlogPostService blogPostService;

    public BlogPostService getBlogPostService() {
        return blogPostService;
    }

    public void setBlogPostService(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> sessionMap = ActionContext.getContext()
                .getSession();

        Object ob[] = (Object[]) blogPostService.getBlogPostData().iterator()
                .next();
        System.out.println("AAAA:" + ob.length);
        long currMaxPosts = (long) ob[0];
        long currPostsCount = (long) ob[1];

        if (checkIfArchiveUpdate(sessionMap, currMaxPosts, currPostsCount) || true) {
            System.out.println("Archive 9");
            @SuppressWarnings("unchecked")
            Map<String, Map<String, List<String>>> zMap = blogPostService.getBlogPostArchive();
            for (Entry<String, Map<String, List<String>>> yearMap : zMap.entrySet()) {
                System.out.println("YEAR:"+yearMap.getKey());
                for (Map.Entry<String, List<String>> monthMap : yearMap.getValue().entrySet()) {
                    System.out.println("MONTH"+monthMap.getKey());
                }
            }
//            sessionMap.put(Constants.SESSION_BLOG_ARCHIVE, blogPostService.getBlogPostArchive());
            sessionMap.put(Constants.SESSION_BLOG_ARCHIVE, zMap);
            sessionMap.put(Constants.SESSION_MAX_POST, currMaxPosts);
            sessionMap.put(Constants.SESSION_POST_COUNT, currPostsCount);
        } else
            System.out.println("NOT UPDATE ARCHIVE");

        return invocation.invoke();
    }

    private boolean checkIfArchiveUpdate(Map<String, Object> sessionMap, long currMaxPosts, long currPostsCount) {
        if (sessionMap.containsKey(Constants.SESSION_BLOG_ARCHIVE)) {
            if(sessionMap.get(Constants.SESSION_BLOG_ARCHIVE) != null) {
                long maxPosts = -1;
                long postsCount = -1;
                if (sessionMap.containsKey(Constants.SESSION_MAX_POST)) {
                    Object obj = sessionMap.get(Constants.SESSION_MAX_POST);
                    if (obj != null) {
                        maxPosts = (long) obj;
                    }
                }
    
                if (sessionMap.containsKey(Constants.SESSION_POST_COUNT)) {
                    Object obj = sessionMap.get(Constants.SESSION_POST_COUNT);
                    if (obj != null) {
                        postsCount = (long) obj;
                    }
                }
                System.out.println("max:" + maxPosts + ", currMax:" + currMaxPosts
                        + ", post:" + postsCount + ", currPost:" + currPostsCount);
    
                return (maxPosts != currMaxPosts || postsCount != currPostsCount);
            }
        }
        return true;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

}
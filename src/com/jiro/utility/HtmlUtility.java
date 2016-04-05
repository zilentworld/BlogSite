package com.jiro.utility;


public class HtmlUtility {

    public static long processUserId(String userIdStr) {
        try {
            return Long.parseLong(userIdStr);
        } catch (Exception e) {
            return 0L;
        }
    }

    public static String generateActionHref(String url, String hrefLink, Object... vars) {
        String href = "<a href=\"javascript:callAction('";
        href += url;
        if(vars.length > 0)
            href += "?";
        for(int a = 0; a < vars.length; a += 2) {
            if(a > 0)
                href += "&'";
            href += vars[a].toString() + "='+" + vars[a+1].toString();
        }
        href += ");\">";
        href += hrefLink;
        href += "</a>";
        return href;
    }
}

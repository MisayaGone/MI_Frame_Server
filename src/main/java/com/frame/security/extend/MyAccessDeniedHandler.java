package com.frame.security.extend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by THINK on 2016/10/17.
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    private final static Logger logger = LoggerFactory.getLogger(MyAccessDeniedHandler.class);

    private String accessDeniedUrl;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {

        if (accessDeniedUrl != null)
        {
            logger.debug("you do not have access to to '" + request.getRequestURI() + "'");
            request.getSession();
            redirectStrategy.sendRedirect(request, response, accessDeniedUrl);
            return;
        }
    }

    public String getAccessDeniedUrl() {
        return accessDeniedUrl;
    }

    public void setAccessDeniedUrl(String accessDeniedUrl) {
        Assert.hasText(accessDeniedUrl, "Need to defind an accessDeniedUrl!");
        this.accessDeniedUrl = accessDeniedUrl;
    }
}

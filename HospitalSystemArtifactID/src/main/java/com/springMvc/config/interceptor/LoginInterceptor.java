package com.springMvc.config.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {


    public void afterCompletion(HttpServletRequest httpRequest,
                                HttpServletResponse httpResponse, Object object, Exception exception)
            throws Exception {
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object object, ModelAndView modelAndView) throws Exception {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
        request.setCharacterEncoding("UTF-8");

        if (request.getSession(false) == null)
            response.sendRedirect("/login");

        logger.info("成功通过验证");
        return true;
    }

}

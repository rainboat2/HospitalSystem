package com.springMvc.config.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {


    public void afterCompletion(HttpServletRequest httpRequest,
                                HttpServletResponse httpResponse, Object object, Exception exception) throws Exception {
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object object, ModelAndView modelAndView) throws Exception {
    }

    // 判断用户是否登陆，如果未登录，则重定向到登陆页面
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userId") != null)
            return true;
        response.sendRedirect(request.getContextPath() + "/login");
        return false;
    }
}

package com.aliyun.carManager.interceptor;

import com.aliyun.carManager.pojo.Account;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Account loginAccount = (Account) request.getSession().getAttribute("loginAccount");
        System.out.println(request.getRequestURI());
        if (loginAccount == null) {
            System.out.println();
            response.sendRedirect("/login.html");
            return false;
        }
        return true;
    }
}

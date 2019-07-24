package cn.gwj.interceptor;/*    
    Created by IntelliJ IDEA.
    Package:cn.gwj.interceptor
    User:1093499975@qq.com
    Date:2019/7/18 0018
    Time:11:03
*/

import cn.gwj.entity.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //返回true放行 false拦截
        User user=(User) request.getSession().getAttribute("loginUser");
        if(user==null){
            response.sendRedirect("/login.html");
            return false;
        }
        return true;
    }
}

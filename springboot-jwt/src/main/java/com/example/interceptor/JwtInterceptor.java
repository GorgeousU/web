package com.example.interceptor;

import com.example.util.JwtUtil;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        //跨域请求会首先发一个option请求，直接返回正常状态并通过拦截器
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        //获取token
        String token = request.getHeader("token");
        if (token != null) {
            boolean result = JwtUtil.verify(token);
            if (result) {
                System.out.println("通过拦截器");
                return true;
            }
        }

        try {
            JSONObject json = new JSONObject();
            json.put("msg","token verify fail");
            json.put("code","20001");
            response.getWriter().append(json.toString());
            System.out.println("认证失败，未通过拦截器");
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}

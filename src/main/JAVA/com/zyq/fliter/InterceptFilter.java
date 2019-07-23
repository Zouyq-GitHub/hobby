package com.zyq.fliter;

import com.zyq.bean.Page;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截器
 */
@WebFilter(filterName = "InterceptFilter",urlPatterns = "/pages/*")
//@WebFilter(filterName = "InterceptFilter")
public class InterceptFilter  implements Filter {

    public  void InterceptFilter(){

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //向下类型转换
        HttpServletRequest request2=(HttpServletRequest)request;
        //获取当前用户信息
        Object object=request2.getSession().getAttribute("RootDemo");
        //获取到了就可以放行请求
        if (object !=null) {
            chain.doFilter(request, response);
        }else {
            //未登录
            HttpServletResponse response2=(HttpServletResponse)response;
            response2.sendRedirect("Hello.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

package com.pascal.j2ee.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        // 获取初始化参数
        String site = filterConfig.getInitParameter("Site");

        // 输出初始化参数
        System.out.println("网站名称: " + site);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        /**
         * 需要转换，才可以获取相关信息
         */
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        // 输出站点名称
        System.out.println("站点网址：http://www.runoob.com");
        Enumeration attriNames = servletRequest.getAttributeNames();
        while (attriNames.hasMoreElements()) {
            String attriName = (String) attriNames.nextElement();
            String attriValue = (String) servletRequest.getAttribute(attriName);
            System.out.println("attriName:" + attriName + "+++attriValue" + attriValue + "\n");
        }

        String localAddr = servletRequest.getLocalAddr();
        System.out.println("localAddr:" + localAddr + "\n");
        String localName = servletRequest.getLocalName();
        System.out.println("localName" + localName + "\n");
        //servletRequest.gets
        String localPort = servletRequest.getLocalAddr();
        System.out.println("localPort" + localPort + "\n");
        Enumeration params = servletRequest.getParameterNames();

        while (params.hasMoreElements()) {
            String paraName = params.nextElement().toString();
            String paraValue = servletRequest.getParameter(paraName).toString();
            System.out.println("paraName:" + paraName + "+++paraValue" + paraValue + "\n");
        }
        String remoteAddr = servletRequest.getRemoteAddr();
        System.out.println("remoteAddr" + remoteAddr + "\n");
        String remoteHost = servletRequest.getRemoteHost();
        System.out.println("remoteHost" + remoteHost + "\n");
        int remotePort = servletRequest.getRemotePort();
        System.out.println("remotePort" + remotePort + "\n");
        String scheme = servletRequest.getScheme();
        System.out.println("scheme" + scheme + "\n");

        System.out.println(servletRequest.getRequestURL().toString());
        // 把请求传回过滤链
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

package com.duopharma.filter;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CacheFilter implements Filter{
	 @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
		 HttpServletResponse res = (HttpServletResponse) response;
		 System.out.println("|-|-|-|-|-|--|-|-|--");
		 System.out.println(req.getRequestURI());
		 System.out.println(req.getContextPath());
		 System.out.println(ResourceHandler.RESOURCE_IDENTIFIER);
		 System.out.println("|-|-|-|-|-|--|-|-|--");
		 if (!req.getRequestURI().startsWith(
		         req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) { // Skip JSF resources //
		                                                                         // (CSS/JS/Images/etc)
		     res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		     res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		     res.setDateHeader("Expires", 0); // Proxies.
		 }

	    }

	    @Override
	    public void init(FilterConfig filterConfig) throws ServletException {

	    }

	    @Override
	    public void destroy() {
	    }
}

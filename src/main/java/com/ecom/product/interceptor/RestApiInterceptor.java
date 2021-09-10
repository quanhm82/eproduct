package com.ecom.product.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import brave.Tracer;

/**
 * @author quanhoang
 * Interceptor for audit purpose of product query
 */
public class RestApiInterceptor implements HandlerInterceptor {
	Logger logger = LoggerFactory.getLogger(RestApiInterceptor.class);
	
	@Autowired
	Tracer tracer;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("Product resource API hit {} {}", request.getMethod(), request.getRequestURL().toString());
		if (request.getRequestURL().toString().contains("product") && request.getMethod().equalsIgnoreCase("get")) {
			// TODO: Getting authentication info from request to put into audit log
			tracer.currentSpan().name("ProductQuery").start();
        	logger.info("Product query hit with {}", request.getRequestURI().toString());
        	tracer.currentSpan().finish();
		}
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}

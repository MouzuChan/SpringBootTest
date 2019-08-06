package com.imooc.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.imooc.controller.Interceptor.OneInterceptor;
import com.imooc.controller.Interceptor.TwoInterceptor;

public class WebMvcConfigurer extends WebMvcConfigurationSupport {
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按照顺序执行
		 */
		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
													 .addPathPatterns("/one/**");
		registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");
		
		super.addInterceptors(registry);
	}
}

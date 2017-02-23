package com.feedback.init;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@SpringBootConfiguration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/register").setViewName("register");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("index");
		registry.addViewController("/profile").setViewName("profile");	
		registry.addViewController("/index").setViewName("index");
		
		/*Admin*/
		registry.addViewController("/admin").setViewName("admin/admin");
	}
	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry
	 * registry) {
	 * registry.addResourceHandler("/css/**").addResourceLocations("/css/**");
	 * registry.addResourceHandler("/img/**").addResourceLocations("/img/**");
	 * registry.addResourceHandler("/js/**").addResourceLocations("/js/**");
	 * registry.addResourceHandler("/sound/**").addResourceLocations("/sound/**"
	 * );
	 * registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/**"
	 * ); }
	 */

}
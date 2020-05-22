package com.bipin.E_COMMERCE.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter
{
	//view resolver
    @Bean
    public InternalResourceViewResolver viewresolver()
    {
    	InternalResourceViewResolver iv=new InternalResourceViewResolver();
    	iv.setPrefix("/WEB-INF/views/");
    	iv.setSuffix(".jsp");
    	return iv;
    }
    
    //static resource
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/assest/");

	}
}

package com.sinoway.zero.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebMvcConfig extends WebMvcConfigurerAdapter
{

    @Value("${spring.view.prefix}")
    String prefix;

    @Value("${spring.view.suffix}")
    String suffix;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        //registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/plugin/**").addResourceLocations("/plugin/");
        registry.addResourceHandler("/api/**").addResourceLocations("/api/");
        //registry.addResourceHandler("/auth/**").addResourceLocations("/auth/");
        //registry.addResourceHandler("/server_monitor/**").addResourceLocations("/server_monitor/");
        super.addResourceHandlers(registry);
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver()
    {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(prefix);
        resolver.setSuffix(suffix);
        return resolver;
    }
}
package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.controller.RequestInterceptor;

@Configuration
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	RequestInterceptor requestInterceptor;
	
	/*
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(requestInterceptor);
	}
	*/
	
	/*
	 * This method is not needed if you have this in application.yml:
	   spring:
		 mvc:
		   view:
		     prefix: /WEB-INF/view/
		     suffix: .jsp
		      
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        registry.viewResolver(resolver);
    }
    */
	
    
    /*
    @Bean
    @Primary
    @ConfigurationProperties("myds.datasource")
    public DataSourceProperties dataSourceProperties() {
    	return new DataSourceProperties();
    }
    */
	
	@Bean
	@ConfigurationProperties("myds.datasource")
	public DataSource dataSource(DataSourceProperties properties) {
		//return DataSourceBuilder.create().build();
		//return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
		return properties.initializeDataSourceBuilder().build();
	}	

	
}

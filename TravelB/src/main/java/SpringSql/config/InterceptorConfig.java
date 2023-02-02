package SpringSql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import SpringSql.interceptor.IndexInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private IndexInterceptor indexInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addInterceptor(indexInterceptor)
				.addPathPatterns("/updatePassword/**")
				.excludePathPatterns("/login/**", "/register/**", "/css/**", "/images/**", "/js/**");
	}

}

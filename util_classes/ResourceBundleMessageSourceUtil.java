package org.inetsolv.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ResourceBundleMessageSourceUtil {
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.addBasenames("errors");
		return messageSource;
	}

}

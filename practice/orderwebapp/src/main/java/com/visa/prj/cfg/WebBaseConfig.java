package com.visa.prj.cfg;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class WebBaseConfig {
	
	@Bean(name="messageSource") // required
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		// We can have a comma separated names of the property file.
		ms.setBasename("classpath:messages"); // not _hi or _fr.. does based on the setting of the browser.
		return ms;
	}
	
}

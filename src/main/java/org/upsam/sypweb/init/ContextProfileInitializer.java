package org.upsam.sypweb.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.context.ConfigurableWebApplicationContext;

public class ContextProfileInitializer implements ApplicationContextInitializer<ConfigurableWebApplicationContext> {

	@Override
	public void initialize(ConfigurableWebApplicationContext applicationContext) {
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		environment.setActiveProfiles("production");
	}

}

package com.cspingenieria.democdi.main;

import org.springframework.context.ApplicationContext;

import com.cspingenieria.democdi.main.config.ApplicationContextProvider;
import com.cspingenieria.democdi.main.config.DemoCDIConfiguration;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class DemoCDIApp extends Application<DemoCDIConfiguration> {

	@Override
	public void run(DemoCDIConfiguration configuration, Environment environment) throws Exception {
		ApplicationContext ac = ApplicationContextProvider.getInstance().getApplicationContext();
		environment.jersey().register(ac.getBean("operacionResource"));
	}

	public static void main(String... arguments) throws Exception {
		new DemoCDIApp().run(arguments);
	}

}

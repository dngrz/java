package com.cspingenieria.consumer.main;

import org.springframework.context.ApplicationContext;

import com.cspingenieria.consumer.main.config.ApplicationContextProvider;
import com.cspingenieria.consumer.main.config.ConsumerConfiguration;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class ConsumerApplication extends Application<ConsumerConfiguration> {

	@Override
	public void run(ConsumerConfiguration configuration, Environment environment) throws Exception {
		ApplicationContext ac = ApplicationContextProvider.getInstance().getApplicationContext();
		environment.jersey().register(ac.getBean("operacionResource"));
	}

	public static void main(String... arguments) throws Exception {
		new ConsumerApplication().run(arguments);
	}

}

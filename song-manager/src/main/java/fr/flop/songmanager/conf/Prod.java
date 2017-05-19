package fr.flop.songmanager.conf;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.util.Log4jConfigurer;

@Configuration
@Profile("prod")
@PropertySource("file:${SONG_MANAGER_CONF}/songManager.properties")
public class Prod {

	@Bean
	public static MethodInvokingFactoryBean initLog4j() throws FileNotFoundException {
		MethodInvokingFactoryBean log4jInitialization = new MethodInvokingFactoryBean();
		log4jInitialization.setTargetClass(Log4jConfigurer.class);
		log4jInitialization.setTargetMethod("initLogging");
		log4jInitialization.setArguments(Arrays.asList("file:${SONG_MANAGER_CONF}/log4j.xml", 10000).toArray());

		return log4jInitialization;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}

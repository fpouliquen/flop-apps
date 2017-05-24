package fr.flop.songmanager;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@SpringBootApplication
@EnableJpaRepositories("fr.flop.songmanager.dao.repository")
@EnableTransactionManagement
@EnableScheduling
public class SongManagerApplication {

	/*
	 * *************************************************************************
	 * Custom data source.
	 * *************************************************************************
	 */

	@Value("${spring.datasource.driver-class-name}")
	private String driverClass;
	@Value("${spring.datasource.url}")
	private String jdbcUrl;
	@Value("${spring.datasource.username}")
	private String user;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${song.manager.base.min.pool.size}")
	private Integer minPoolSize;
	@Value("${song.manager.base.max.pool.size}")
	private Integer maxPoolSize;
	@Value("${song.manager.base.idleTime}")
	private Integer maxIdleTime;

	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setDriverClass(driverClass);
		comboPooledDataSource.setJdbcUrl(jdbcUrl);
		comboPooledDataSource.setUser(user);
		comboPooledDataSource.setPassword(password);
		comboPooledDataSource.setMinPoolSize(minPoolSize);
		comboPooledDataSource.setMaxPoolSize(maxPoolSize);
		comboPooledDataSource.setMaxIdleTime(maxIdleTime);
		comboPooledDataSource.setAcquireIncrement(3);
		comboPooledDataSource.setNumHelperThreads(6);
		return comboPooledDataSource;
	}

	/*
	 * *************************************************************************
	 * 
	 * *************************************************************************
	 */

	public static void main(String[] args) {
		SpringApplication.run(SongManagerApplication.class, args);
	}
}

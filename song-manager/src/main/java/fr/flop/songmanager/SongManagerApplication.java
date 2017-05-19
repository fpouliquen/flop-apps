package fr.flop.songmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories("fr.flop.songmanager.dao.repository")
@EnableTransactionManagement
@EnableScheduling
public class SongManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongManagerApplication.class, args);
	}
}

package com.tharuke.lhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan({"com.tharuke.lhi.repository"})
@EnableMongoRepositories(value = "com.tharuke.lhi.repository")
@EnableTransactionManagement
@EnableMongoAuditing
@EnableScheduling
@SpringBootApplication
@EnableCaching
public class LhiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LhiApplication.class, args);
	}

}

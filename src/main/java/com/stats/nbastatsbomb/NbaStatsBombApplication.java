package com.stats.nbastatsbomb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableMongoRepositories
@EnableElasticsearchRepositories
public class NbaStatsBombApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbaStatsBombApplication.class, args);
	}

}

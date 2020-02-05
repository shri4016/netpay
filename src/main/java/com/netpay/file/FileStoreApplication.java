package com.netpay.file;

import com.github.mongobee.Mongobee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication(scanBasePackages = {"com.netpay.*"})
public class FileStoreApplication {
	@Autowired
	static MongoTemplate mongoTemplate;



	public static void main(String[] args) throws Exception {
		SpringApplication.run(FileStoreApplication.class, args);
	}


	@Bean
	public Mongobee mongobee() {
		Mongobee runner = new Mongobee("mongodb://localhost:27017/filestore");
		runner.setMongoTemplate(mongoTemplate);
		runner.setChangeLogsScanPackage("com.netpay.*");
		return runner;
	}


}

package com.soa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.soa.dto.LizbethResponse;
import com.soa.soap.RfcClient;

@SpringBootApplication
public class RfcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RfcClientApplication.class, args);
	}

	@Bean
    CommandLineRunner lookup(RfcClient client) {
        return args -> {
            LizbethResponse response = client.execute();
            System.err.println(response.getRfc());
        };
    }
}

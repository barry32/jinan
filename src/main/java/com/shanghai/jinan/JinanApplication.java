package com.shanghai.jinan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.shanghai.jinan"})
@MapperScan("com.shanghai.jinan.mapper")
public class JinanApplication {

	public static void main(String[] args) {
		SpringApplication.run(JinanApplication.class, args);
	}

}

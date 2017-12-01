package com.pengfeis.spr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pengfeis.spr.mapper")
public class BootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDemoApplication.class, args);
	}
}

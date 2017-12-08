package com.ncu.sysweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ncu.sysweb.mapper")
public class SyswebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyswebApplication.class, args);
	}
}

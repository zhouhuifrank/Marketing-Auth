package com.frankzhou.lottery.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
* @Author: this.FrankZhou
* @Description: SSO登录启动
* @DateTime: 2023/1/8 0:13
*/
@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "com.frankzhou.lottery.backend.mapper")
public class LotteryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotteryApplication.class, args);
	}

}

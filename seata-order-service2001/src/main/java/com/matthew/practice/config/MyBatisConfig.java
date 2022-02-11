package com.matthew.practice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.matthew.practice.dao"})
public class MyBatisConfig {
}

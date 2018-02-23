package com.mmlgo.yh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MmlgoApplication {
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(MmlgoApplication.class);
        //修改Banner的模式为OFF
        builder.bannerMode(Banner.Mode.OFF).run(args);
       // SpringApplication.run(MmlgoApplication.class, args);
    }
}

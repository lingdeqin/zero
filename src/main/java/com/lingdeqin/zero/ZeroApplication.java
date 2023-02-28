package com.lingdeqin.zero;

import com.lingdeqin.zero.config.ZeroConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(ZeroConfig.class)
@MapperScan("com.lingdeqin.zero.dao")
@SpringBootApplication
public class ZeroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeroApplication.class, args);
    }

}

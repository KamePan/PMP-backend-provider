package cn.edu.ecnu.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.edu.ecnu.*"})
@MapperScan("cn.edu.ecnu.dao")
public class PmpBackendProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmpBackendProviderApplication.class, args);
    }

}

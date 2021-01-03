package com.etrener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TrenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrenerApplication.class, args);
    }

}

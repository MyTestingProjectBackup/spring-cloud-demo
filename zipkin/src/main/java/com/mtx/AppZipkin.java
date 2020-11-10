package com.mtx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class AppZipkin {

    public static void main(String[] args) {

        SpringApplication.run(AppZipkin.class);
    }
}

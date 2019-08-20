package com.skhata.schoolMgmtSystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SchoolMgmtSystemApplication extends SpringBootServletInitializer {
    private static final Logger LOG = LoggerFactory.getLogger(SchoolMgmtSystemApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SchoolMgmtSystemApplication.class);
    }

    public static void main(String[] args) {
        LOG.info("Starting School Management System");
        SpringApplication.run(SchoolMgmtSystemApplication.class, args);
    }
}

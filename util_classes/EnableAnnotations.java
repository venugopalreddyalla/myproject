package org.inetsolv.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages="org.inetsolv")
@EnableWebMvc

public class EnableAnnotations {

}

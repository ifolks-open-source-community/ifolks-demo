package org.ifolks.demo.junit;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"org.ifolks.demo", "org.ifolks.generator", "org.ifolks.commons"})
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

}
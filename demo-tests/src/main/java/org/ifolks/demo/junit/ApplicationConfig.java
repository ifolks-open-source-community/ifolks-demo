package org.ifolks.demo.junit;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootConfiguration
@ComponentScan(basePackages = {"org.ifolks.demo", "org.ifolks.generator"})
@EnableAspectJAutoProxy
public class ApplicationConfig {

}

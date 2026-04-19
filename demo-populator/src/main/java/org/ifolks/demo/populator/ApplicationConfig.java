package org.ifolks.demo.populator;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.ifolks.generator.components.population.datasources.InputDataSourceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "org.ifolks.demo, org.ifolks.generator")
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
	
	@Bean
	public InputDataSourceProvider inputDataSourceProvider() {
		
		Map<String, DataSource> datasources = new HashMap<>();
		
		InputDataSourceProvider result = new InputDataSourceProvider(datasources);
		
		return result;
		
	}

}
package org.ifolks.demo.populator.executor;

import javax.sql.DataSource;
import org.ifolks.demo.populator.ApplicationConfig;
import org.ifolks.generator.components.build.prompt.BuildPrompter;
import org.ifolks.generator.components.metadata.validation.prompt.ValidationPrompter;
import org.ifolks.generator.model.domain.Project;
import org.ifolks.generator.model.metadata.ProjectMetaData;
import org.ifolks.generator.model.metadata.validation.ProjectValidationReport;
import org.ifolks.generator.services.DatabaseBuilder;
import org.ifolks.generator.services.ProjectLoader;
import org.ifolks.generator.services.ProjectMetaDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * This class can be launched to execute your database building<br/>
 * Argument required : 
 * <li>the workspace folder where the "data-model" folder will be detected
 * <li>the database name that must be declared in /data-model/datasource-context.xml
 * Depending on the meta data that is going to be read, the main method will :
 * <li>load the project representation
 * <li>clean the project database
 * <li>execute all the SQL files that have been previously generated to build your database
 * @author Nicolas Thibault
 *
 */
public class DatabaseBuilderLauncher {
	/*
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(DatabaseBuilderLauncher.class);
	
	
	/**
	 * main method to be executed
	 * @param args 0->the workspace folder where the "data-model" folder will be detected
	 * @param args 1->the database name, declared in /data-model/datasource-context.xml
	 */
	public static void main(String[] args) {
		
		if (args.length < 1) {
			throw new IllegalArgumentException("Path is Mandatory");
		}
		String workspacePath = args[0];
		Boolean noPrompt =  false;
		
		if (args.length >2) {
			noPrompt = Boolean.valueOf(args[2]);
		}
		
		
		Project project;
		
		try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);) {
			
			logger.info("noPrompt: " + noPrompt);
			
			if (!noPrompt) {
				BuildPrompter.promptForConfirmation();
			}
			
			logger.info("start loading project");
			
			ProjectMetaDataService projectMetaDataService = appContext.getBean(ProjectMetaDataService.class);
			ProjectLoader projectLoader = appContext.getBean(ProjectLoader.class);
			
			ProjectMetaData projectMetaData = projectMetaDataService.loadProjectMetaData(workspacePath);
			
			ProjectValidationReport report = projectMetaDataService.validate(projectMetaData);
			ValidationPrompter.promptOnValidation(report);
			
			project = projectLoader.loadProject(projectMetaData);
			
			logger.info("loading project " + project.projectName + " completed");
		
			try {
				DataSource dataSource = appContext.getBean(DataSource.class);
				Environment env = appContext.getBean(Environment.class);
				
				DatabaseBuilder databaseBuilder = appContext.getBean(DatabaseBuilder.class);
				databaseBuilder.buildDatabase(dataSource, project, env.getRequiredProperty("db.engine"));
				
			} catch (Exception e) {
				logger.error("failed", e);
				return;
			}
		} catch (Exception e) {
			logger.error("failed", e);
			return;
		}
	}
}
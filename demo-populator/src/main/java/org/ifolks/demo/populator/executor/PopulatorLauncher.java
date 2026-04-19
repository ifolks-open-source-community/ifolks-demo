package org.ifolks.demo.populator.executor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.sql.DataSource;
import org.ifolks.demo.populator.ApplicationConfig;
import org.ifolks.generator.components.population.checks.PopulationPostExecutionChecker;
import org.ifolks.generator.components.population.checks.PopulationPreExecutionChecker;
import org.ifolks.generator.components.population.datasources.InputDataSourceProvider;
import org.ifolks.generator.components.population.prompt.PopulatorPrompter;
import org.ifolks.generator.model.domain.Project;
import org.ifolks.generator.model.metadata.ProjectMetaData;
import org.ifolks.generator.model.population.check.PopulationPlanPostExecutionWarning;
import org.ifolks.generator.model.population.check.PopulationPlanPreExecutionWarning;
import org.ifolks.generator.services.Populator;
import org.ifolks.generator.services.ProjectLoader;
import org.ifolks.generator.services.ProjectMetaDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class PopulatorLauncher {

	/*
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(PopulatorLauncher.class);
	
	
	/**
	 * 
	 * @param args 0->the workspace folder where the "data-model" folder will be detected
	 * @param args 1->the folder where the backup plan will be read
	 * @param args 3->if a confirmation prompt is needed
	 * @param args 4(optional)->a list of semicolon separated table names if you want to restrict the population with this list
	 */
	public static void main(String[] args) {
		
		if (args.length < 2) {
			throw new IllegalArgumentException("workspace path and backup plan folder are Mandatory");
		}
		String workspacePath = args[0];
		String backupPath = args[1];
		Boolean noPrompt =  false;
			
		if (args.length >2) {
			noPrompt = Boolean.valueOf(args[2]);
		}

		Set<String> tables = extractTables(args);
		
			logger.info("Context loaded");
			
			Project project;
			
			try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);) {
				logger.info("start loading project");
				
				ProjectMetaDataService projectMetaDataService = appContext.getBean(ProjectMetaDataService.class);
				ProjectLoader projectLoader = appContext.getBean(ProjectLoader.class);
				
				ProjectMetaData projectMetaData = projectMetaDataService.loadProjectMetaData(workspacePath);
				project = projectLoader.loadProject(projectMetaData);
				
				logger.info("loading project " + project.projectName + " completed");
					
				try {
					
					DataSource dataSource = appContext.getBean(DataSource.class);
													
					InputDataSourceProvider inputDataSourceProvider = appContext.getBean(InputDataSourceProvider.class);
					
					PopulationPreExecutionChecker preChecker = appContext.getBean(PopulationPreExecutionChecker.class);
					logger.info("Checking backup plan before execution...");
					List<PopulationPlanPreExecutionWarning> preExecutionWarnings = preChecker.checkPlan(inputDataSourceProvider, project, tables, backupPath);
					logger.info("plan pre-execution check finished");
					
					PopulatorPrompter.printPreExecutionWarnings(preExecutionWarnings);
					
					logger.info("noPrompt: " + noPrompt);
	
					if (!noPrompt) {
						PopulatorPrompter.promptForConfirmation();
					}
					
					Populator populator = appContext.getBean(Populator.class);
					populator.populate(inputDataSourceProvider, project, tables, backupPath);
					
					PopulationPostExecutionChecker postChecker = appContext.getBean(PopulationPostExecutionChecker.class);
					logger.info("Checking backup plan after execution...");
					List<PopulationPlanPostExecutionWarning> postExecutionWarnings = postChecker.checkPlan(dataSource, project, tables);
					logger.info("plan post-execution check finished");
					
					PopulatorPrompter.printPostExecutionWarnings(postExecutionWarnings);
					
				} catch (Exception e) {
					logger.error("failed", e);
					return;
				}
			} catch (Exception e) {
				logger.error("failed", e);
				return;
			}
		}
	
	private static Set<String> extractTables(String[] args) {
		
		Set<String> tables = null;
		
		if (args.length > 3) {
			String tablesArg = args[3];
			String[] tableTokens = tablesArg.split(";");
			tables = new HashSet<String>();
			for (String table:tableTokens) {
				tables.add(table);
			}
		}
		
		return tables;
	}
}

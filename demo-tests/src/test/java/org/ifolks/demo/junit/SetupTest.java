package org.ifolks.demo.junit;

import java.util.List;

import org.ifolks.demo.api.interfaces.organizations.OrganizationService;
import org.ifolks.demo.api.model.organizations.enums.OrganizationRole;
import org.ifolks.demo.api.model.organizations.views.basic.OrganizationBasicView;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationFullView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(ApplicationConfig.class)
public class SetupTest {

	/*
	 * logger
	 */
	private final Logger logger = LoggerFactory.getLogger(SetupTest.class);
	
	@Autowired
	private JUnitDataInitializer dataInitializer;

	@Autowired
	private OrganizationService organizationService;

	
	@BeforeEach
	public void setUp() {
		dataInitializer.initialize();
	}
	
	
	@Test
	public void testSetup() {
		logger.info("Your test environment is ready to use !");
		List<OrganizationBasicView> orgs = organizationService.loadList();
		Assertions.assertEquals(3, orgs.size());

		OrganizationFullView acme = organizationService.find("ACME");
		Assertions.assertNotNull(acme);
		Assertions.assertEquals(OrganizationRole.HEADQUARTERS, acme.form().role());

		OrganizationFullView acmeFr = organizationService.find("ACME-FR");
		Assertions.assertNotNull(acmeFr);
		Assertions.assertEquals(OrganizationRole.SUBSIDIARY, acmeFr.form().role());

		OrganizationFullView acmeLyon = organizationService.find("ACME-LYON");
		Assertions.assertNotNull(acmeLyon);
		Assertions.assertEquals(OrganizationRole.BRANCH, acmeLyon.form().role());
	}
}

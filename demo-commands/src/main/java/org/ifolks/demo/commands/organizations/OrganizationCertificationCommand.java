package org.ifolks.demo.commands.organizations;

import java.util.Arrays;
import java.util.List;
import org.ifolks.demo.api.interfaces.organizations.OrganizationService;
import org.ifolks.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationFullView;
import org.ifolks.demo.components.mapper.organizations.forms.OrganizationCertificationFormMapper;
import org.ifolks.generator.components.population.commands.interfaces.ServiceCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated bean populator command class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
@Component
public class OrganizationCertificationCommand implements ServiceCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(OrganizationCertificationCommand.class);

@Autowired
private OrganizationService organizationService;

@Autowired
private OrganizationCertificationFormMapper organizationCertificationFormMapper;

@Override
public void execute(List<Object[]> data) {
for (Object[] args:data) {
String message = "execute organizationService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
OrganizationCertificationForm organizationCertificationForm = organizationCertificationFormMapper.toForm(Arrays.copyOfRange(args,1,args.length));

String arg0 = (String)args[0];
OrganizationFullView organizationFullView = organizationService.find(arg0);

this.organizationService.saveOrganizationCertification(organizationFullView.id(), organizationCertificationForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}

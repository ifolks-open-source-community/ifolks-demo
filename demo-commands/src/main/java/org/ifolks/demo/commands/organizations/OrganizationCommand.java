package org.ifolks.demo.commands.organizations;

import java.util.List;
import org.ifolks.demo.api.interfaces.organizations.OrganizationService;
import org.ifolks.demo.api.model.organizations.forms.OrganizationForm;
import org.ifolks.demo.components.mapper.organizations.forms.OrganizationFormMapper;
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
public class OrganizationCommand implements ServiceCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(OrganizationCommand.class);

@Autowired
private OrganizationService organizationService;

@Autowired
private OrganizationFormMapper organizationFormMapper;

@Override
public void execute(List<Object[]> data) {
for (Object[] args : data) {
String message = "execute organizationService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
OrganizationForm organizationForm = organizationFormMapper.toForm(args);

this.organizationService.save(organizationForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}

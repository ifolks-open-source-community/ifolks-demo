package org.ifolks.demo.populator.command.organizations;

import java.util.Arrays;
import org.ifolks.commons.mapper.impl.ObjectArrayToBeanMapperImpl;
import org.ifolks.commons.mapper.impl.StringArrayToBeanMapperImpl;
import org.ifolks.commons.mapper.impl.StringToObjectConverter;
import org.ifolks.commons.mapper.interfaces.ObjectArrayToBeanMapper;
import org.ifolks.demo.api.interfaces.organizations.OrganizationService;
import org.ifolks.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationFullView;
import org.ifolks.generator.persistence.backup.command.interfaces.BackupArgumentsCommand;
import org.ifolks.generator.persistence.backup.reader.model.BackupArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated view command class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
@Component
public class OrganizationCertificationCommand implements BackupArgumentsCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(OrganizationCertificationCommand.class);

@Autowired
private OrganizationService organizationService;

@Override
public void execute(BackupArguments arguments) {
ObjectArrayToBeanMapper<OrganizationCertificationForm> mapper;
if (arguments.isArgumentsTyped()) {
mapper = new ObjectArrayToBeanMapperImpl<OrganizationCertificationForm>(OrganizationCertificationForm.class);
} else {
mapper = new StringArrayToBeanMapperImpl<OrganizationCertificationForm>(OrganizationCertificationForm.class);
}
for (Object[] args:arguments.getArguments()) {
String message = "execute organizationService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
OrganizationCertificationForm organizationCertificationForm = mapper.mapFrom(new OrganizationCertificationForm(), Arrays.copyOfRange(args,1,args.length));

String arg0 = arguments.isArgumentsTyped()?(String)args[0]:(String)(StringToObjectConverter.getObjectFromString((String)args[0], String.class));
OrganizationFullView organizationFullView = organizationService.find(arg0);

this.organizationService.saveOrganizationCertification(organizationFullView.getId(), organizationCertificationForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}

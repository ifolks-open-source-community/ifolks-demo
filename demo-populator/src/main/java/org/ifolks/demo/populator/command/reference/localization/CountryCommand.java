package org.ifolks.demo.populator.command.reference.localization;

import org.ifolks.commons.mapper.impl.ObjectArrayToBeanMapperImpl;
import org.ifolks.commons.mapper.impl.StringArrayToBeanMapperImpl;
import org.ifolks.commons.mapper.interfaces.ObjectArrayToBeanMapper;
import org.ifolks.demo.api.interfaces.reference.localization.CountryService;
import org.ifolks.demo.api.model.reference.localization.forms.CountryForm;
import org.ifolks.generator.persistence.backup.command.interfaces.BackupArgumentsCommand;
import org.ifolks.generator.persistence.backup.reader.model.BackupArguments;
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
public class CountryCommand implements BackupArgumentsCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(CountryCommand.class);

@Autowired
private CountryService countryService;

@Override
public void execute(BackupArguments arguments) {
ObjectArrayToBeanMapper<CountryForm> mapper;
if (arguments.isArgumentsTyped()) {
mapper = new ObjectArrayToBeanMapperImpl<CountryForm>(CountryForm.class);
} else {
mapper = new StringArrayToBeanMapperImpl<CountryForm>(CountryForm.class);
}
for (Object[] args : arguments.getArguments()) {
String message = "execute countryService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
CountryForm countryForm = mapper.mapFrom(new CountryForm(), args);

this.countryService.save(countryForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}

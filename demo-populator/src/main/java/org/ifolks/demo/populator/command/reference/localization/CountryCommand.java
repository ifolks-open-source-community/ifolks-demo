package org.ifolks.demo.populator.command.reference.localization;

import java.util.List;
import org.ifolks.demo.api.interfaces.reference.localization.CountryService;
import org.ifolks.demo.api.model.reference.localization.forms.CountryForm;
import org.ifolks.demo.components.mapper.reference.localization.forms.CountryFormMapper;
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
public class CountryCommand implements ServiceCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(CountryCommand.class);

@Autowired
private CountryService countryService;

@Autowired
private CountryFormMapper countryFormMapper;

@Override
public void execute(List<Object[]> data) {
for (Object[] args : data) {
String message = "execute countryService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
CountryForm countryForm = countryFormMapper.toForm(args);

this.countryService.save(countryForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}

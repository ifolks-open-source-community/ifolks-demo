package org.ifolks.demo.commands.reference.localization;

import java.util.List;
import org.ifolks.demo.api.interfaces.reference.localization.RegionService;
import org.ifolks.demo.api.model.reference.localization.forms.RegionForm;
import org.ifolks.demo.components.mapper.reference.localization.forms.RegionFormMapper;
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
public class RegionCommand implements ServiceCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(RegionCommand.class);

@Autowired
private RegionService regionService;

@Autowired
private RegionFormMapper regionFormMapper;

@Override
public void execute(List<Object[]> data) {
for (Object[] args : data) {
String message = "execute regionService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
RegionForm regionForm = regionFormMapper.toForm(args);

this.regionService.save(regionForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}

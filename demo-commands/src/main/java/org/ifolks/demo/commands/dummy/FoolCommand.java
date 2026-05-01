package org.ifolks.demo.commands.dummy;

import java.util.List;
import org.ifolks.demo.api.interfaces.dummy.FoolService;
import org.ifolks.demo.api.model.dummy.forms.FoolForm;
import org.ifolks.demo.components.mapper.dummy.forms.FoolFormMapper;
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
public class FoolCommand implements ServiceCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(FoolCommand.class);

@Autowired
private FoolService foolService;

@Autowired
private FoolFormMapper foolFormMapper;

@Override
public void execute(List<Object[]> data) {
for (Object[] args : data) {
String message = "execute foolService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
FoolForm foolForm = foolFormMapper.toForm(args);

this.foolService.save(foolForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}

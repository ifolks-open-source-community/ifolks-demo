package org.ifolks.demo.populator.command.dummy;

import java.util.List;
import org.ifolks.demo.api.interfaces.dummy.StupidService;
import org.ifolks.demo.api.model.dummy.forms.StupidForm;
import org.ifolks.demo.components.mapper.dummy.forms.StupidFormMapper;
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
public class StupidCommand implements ServiceCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(StupidCommand.class);

@Autowired
private StupidService stupidService;

@Autowired
private StupidFormMapper stupidFormMapper;

@Override
public void execute(List<Object[]> data) {
for (Object[] args : data) {
String message = "execute stupidService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
StupidForm stupidForm = stupidFormMapper.toForm(args);

this.stupidService.save(stupidForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}

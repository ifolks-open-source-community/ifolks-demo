package org.ifolks.demo.populator.command.reference.time;

import org.ifolks.commons.mapper.impl.ObjectArrayToBeanMapperImpl;
import org.ifolks.commons.mapper.impl.StringArrayToBeanMapperImpl;
import org.ifolks.commons.mapper.interfaces.ObjectArrayToBeanMapper;
import org.ifolks.demo.api.interfaces.reference.time.CalendarService;
import org.ifolks.demo.api.model.reference.time.forms.CalendarForm;
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
public class CalendarCommand implements BackupArgumentsCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(CalendarCommand.class);

@Autowired
private CalendarService calendarService;

@Override
public void execute(BackupArguments arguments) {
ObjectArrayToBeanMapper<CalendarForm> mapper;
if (arguments.isArgumentsTyped()) {
mapper = new ObjectArrayToBeanMapperImpl<CalendarForm>(CalendarForm.class);
} else {
mapper = new StringArrayToBeanMapperImpl<CalendarForm>(CalendarForm.class);
}
for (Object[] args : arguments.getArguments()) {
String message = "execute calendarService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
CalendarForm calendarForm = mapper.mapFrom(new CalendarForm(), args);

this.calendarService.save(calendarForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}

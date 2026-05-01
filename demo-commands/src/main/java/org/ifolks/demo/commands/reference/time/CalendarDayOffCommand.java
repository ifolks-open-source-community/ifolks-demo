package org.ifolks.demo.commands.reference.time;

import java.util.Arrays;
import java.util.List;
import org.ifolks.demo.api.interfaces.reference.time.CalendarService;
import org.ifolks.demo.api.model.reference.time.forms.CalendarDayOffForm;
import org.ifolks.demo.api.model.reference.time.views.full.CalendarFullView;
import org.ifolks.demo.components.mapper.reference.time.forms.CalendarDayOffFormMapper;
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
public class CalendarDayOffCommand implements ServiceCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(CalendarDayOffCommand.class);

@Autowired
private CalendarService calendarService;

@Autowired
private CalendarDayOffFormMapper calendarDayOffFormMapper;

@Override
public void execute(List<Object[]> data) {
for (Object[] args:data) {
String message = "execute calendarService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
CalendarDayOffForm calendarDayOffForm = calendarDayOffFormMapper.toForm(Arrays.copyOfRange(args,1,args.length));

String arg0 = (String)args[0];
CalendarFullView calendarFullView = calendarService.find(arg0);

this.calendarService.saveCalendarDayOff(calendarFullView.id(), calendarDayOffForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}

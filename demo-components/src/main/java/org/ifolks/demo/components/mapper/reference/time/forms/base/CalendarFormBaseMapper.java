package org.ifolks.demo.components.mapper.reference.time.forms.base;

import org.ifolks.commons.mapper.impl.BasicMapperImpl;
import org.ifolks.demo.api.model.reference.time.forms.CalendarForm;
import org.ifolks.demo.model.reference.time.Calendar;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CalendarFormBaseMapper extends BasicMapperImpl<CalendarForm, Calendar> {

public CalendarFormBaseMapper() {
super(CalendarForm.class, Calendar.class);
}

/*
 * properties
 */

/**
 * mapping form from object
 */
@Override
public CalendarForm mapFrom(CalendarForm calendarForm, Calendar calendar) {
calendarForm = super.mapFrom(calendarForm, calendar);
return calendarForm;
}

/**
 * mapping view to object
 */
@Override
public Calendar mapTo(CalendarForm calendarForm, Calendar calendar) {
calendar = super.mapTo(calendarForm, calendar);
return calendar;
}

}

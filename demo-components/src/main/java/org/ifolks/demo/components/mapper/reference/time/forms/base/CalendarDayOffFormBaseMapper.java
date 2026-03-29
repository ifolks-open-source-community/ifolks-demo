package org.ifolks.demo.components.mapper.reference.time.forms.base;

import org.ifolks.commons.mapper.impl.BasicMapperImpl;
import org.ifolks.demo.api.model.reference.time.forms.CalendarDayOffForm;
import org.ifolks.demo.model.reference.time.CalendarDayOff;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CalendarDayOffFormBaseMapper extends BasicMapperImpl<CalendarDayOffForm, CalendarDayOff> {

public CalendarDayOffFormBaseMapper() {
super(CalendarDayOffForm.class, CalendarDayOff.class);
}

/*
 * properties
 */

/**
 * mapping form from object
 */
@Override
public CalendarDayOffForm mapFrom(CalendarDayOffForm calendarDayOffForm, CalendarDayOff calendarDayOff) {
calendarDayOffForm = super.mapFrom(calendarDayOffForm, calendarDayOff);
return calendarDayOffForm;
}

/**
 * mapping view to object
 */
@Override
public CalendarDayOff mapTo(CalendarDayOffForm calendarDayOffForm, CalendarDayOff calendarDayOff) {
calendarDayOff = super.mapTo(calendarDayOffForm, calendarDayOff);
return calendarDayOff;
}

}

package org.ifolks.demo.components.mapper.reference.time.forms.base;

import java.time.LocalDate;

import org.ifolks.demo.api.model.reference.time.forms.CalendarDayOffForm;
import org.ifolks.demo.model.reference.time.CalendarDayOff;
import org.springframework.stereotype.Component;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
@Component
public class CalendarDayOffFormBaseMapper {


/*
 * properties
 */

/**
 * mapping object arry to form
 */
public CalendarDayOffForm toForm(Object[] args) {

return new CalendarDayOffForm (
(LocalDate)args[0],
(String)args[1]);
}

/**
 * mapping entity to form
 */
public CalendarDayOffForm toForm(CalendarDayOff calendarDayOff) {
LocalDate dayOffDate = calendarDayOff.getDayOffDate();
String dayOffLabel = calendarDayOff.getDayOffLabel();

return new CalendarDayOffForm (
dayOffDate,
dayOffLabel);
}

/**
 * mapping form to entity
 */
public CalendarDayOff toEntity(CalendarDayOffForm calendarDayOffForm, CalendarDayOff calendarDayOff) {
calendarDayOff.setDayOffDate(calendarDayOffForm.dayOffDate());
calendarDayOff.setDayOffLabel(calendarDayOffForm.dayOffLabel());
return calendarDayOff;
}

}

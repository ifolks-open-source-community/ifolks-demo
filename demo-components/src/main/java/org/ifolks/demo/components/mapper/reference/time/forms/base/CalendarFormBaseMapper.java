package org.ifolks.demo.components.mapper.reference.time.forms.base;

import org.ifolks.demo.api.model.reference.time.forms.CalendarForm;
import org.ifolks.demo.model.reference.time.Calendar;
import org.springframework.stereotype.Component;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
@Component
public class CalendarFormBaseMapper {


/*
 * properties
 */

/**
 * mapping object arry to form
 */
public CalendarForm toForm(Object[] args) {

return new CalendarForm (
(String)args[0],
(String)args[1]);
}

/**
 * mapping entity to form
 */
public CalendarForm toForm(Calendar calendar) {
String code = calendar.getCode();
String label = calendar.getLabel();

return new CalendarForm (
code,
label);
}

/**
 * mapping form to entity
 */
public Calendar toEntity(CalendarForm calendarForm, Calendar calendar) {
calendar.setCode(calendarForm.code());
calendar.setLabel(calendarForm.label());
return calendar;
}

}

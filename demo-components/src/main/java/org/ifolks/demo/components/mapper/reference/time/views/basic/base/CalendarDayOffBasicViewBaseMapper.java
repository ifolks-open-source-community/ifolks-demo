package org.ifolks.demo.components.mapper.reference.time.views.basic.base;

import java.time.LocalDate;
import org.ifolks.demo.api.model.reference.time.views.basic.CalendarDayOffBasicView;
import org.ifolks.demo.components.rightsmanager.reference.time.CalendarRightsManager;
import org.ifolks.demo.components.statemanager.reference.time.CalendarStateManager;
import org.ifolks.demo.model.reference.time.CalendarDayOff;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base basic view mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CalendarDayOffBasicViewBaseMapper {
/*
 * injections
 */
@Autowired
protected CalendarRightsManager calendarRightsManager;
@Autowired
protected CalendarStateManager calendarStateManager;

/**
 * mapping object to view
 */
public CalendarDayOffBasicView toView(CalendarDayOff calendarDayOff) {
Integer id = calendarDayOff.getId();
boolean selected = false;
boolean canDelete = calendarRightsManager.canDeleteCalendarDayOff(calendarDayOff) && calendarStateManager.canDeleteCalendarDayOff(calendarDayOff);
LocalDate dayOffDate = calendarDayOff.getDayOffDate();
String dayOffLabel = calendarDayOff.getDayOffLabel();

return new CalendarDayOffBasicView (
id,
selected,
canDelete,
dayOffDate,
dayOffLabel);
}

}

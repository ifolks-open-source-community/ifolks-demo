package org.ifolks.demo.components.mapper.reference.time.views.basic.base;

import org.ifolks.demo.api.model.reference.time.views.basic.CalendarBasicView;
import org.ifolks.demo.components.rightsmanager.reference.time.CalendarRightsManager;
import org.ifolks.demo.components.statemanager.reference.time.CalendarStateManager;
import org.ifolks.demo.model.reference.time.Calendar;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base basic view mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CalendarBasicViewBaseMapper {
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
public CalendarBasicView toView(Calendar calendar) {
Integer id = calendar.getId();
boolean selected = false;
boolean canDelete = calendarRightsManager.canDelete(calendar) && calendarStateManager.canDelete(calendar);
String code = calendar.getCode();
String label = calendar.getLabel();

return new CalendarBasicView (
id,
selected,
canDelete,
code,
label);
}

}

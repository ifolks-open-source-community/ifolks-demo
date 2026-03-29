package org.ifolks.demo.components.mapper.reference.time.views.full.base;

import org.ifolks.commons.mapper.impl.FullViewMapper;
import org.ifolks.demo.api.model.reference.time.forms.CalendarDayOffForm;
import org.ifolks.demo.api.model.reference.time.views.full.CalendarDayOffFullView;
import org.ifolks.demo.components.rightsmanager.reference.time.CalendarRightsManager;
import org.ifolks.demo.components.statemanager.reference.time.CalendarStateManager;
import org.ifolks.demo.model.reference.time.CalendarDayOff;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

public class CalendarDayOffFullViewBaseMapper extends FullViewMapper<CalendarDayOffFullView, Integer, CalendarDayOffForm, CalendarDayOff> {

@Autowired
protected CalendarRightsManager calendarRightsManager;
@Autowired
protected CalendarStateManager calendarStateManager;

public CalendarDayOffFullViewBaseMapper() {
super(CalendarDayOffFullView.class, CalendarDayOff.class);
}

@Override
public CalendarDayOffFullView mapFrom(CalendarDayOffFullView calendarDayOffFullView, CalendarDayOff calendarDayOff) {
calendarDayOffFullView = super.mapFrom(calendarDayOffFullView, calendarDayOff);
calendarDayOffFullView.setCanUpdate(calendarRightsManager.canUpdateCalendarDayOff(calendarDayOff) && calendarStateManager.canUpdateCalendarDayOff(calendarDayOff));
calendarDayOffFullView.setCanDelete(calendarRightsManager.canDeleteCalendarDayOff(calendarDayOff) && calendarStateManager.canDeleteCalendarDayOff(calendarDayOff));
return calendarDayOffFullView;
}

}

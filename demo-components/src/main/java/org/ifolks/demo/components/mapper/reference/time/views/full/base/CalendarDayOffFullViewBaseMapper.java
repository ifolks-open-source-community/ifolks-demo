package org.ifolks.demo.components.mapper.reference.time.views.full.base;

import org.ifolks.demo.api.model.reference.time.forms.CalendarDayOffForm;
import org.ifolks.demo.api.model.reference.time.views.full.CalendarDayOffFullView;
import org.ifolks.demo.components.mapper.reference.time.forms.CalendarDayOffFormMapper;
import org.ifolks.demo.components.rightsmanager.reference.time.CalendarRightsManager;
import org.ifolks.demo.components.statemanager.reference.time.CalendarStateManager;
import org.ifolks.demo.model.reference.time.CalendarDayOff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component
public class CalendarDayOffFullViewBaseMapper {

@Autowired
protected CalendarRightsManager calendarRightsManager;
@Autowired
protected CalendarStateManager calendarStateManager;

@Autowired
protected CalendarDayOffFormMapper formMapper;

/**
 * mapping entity to view
 */
public CalendarDayOffFullView toView(CalendarDayOff calendarDayOff) {
Integer id = calendarDayOff.getId();
CalendarDayOffForm form = formMapper.toForm(calendarDayOff);
boolean canUpdate = calendarRightsManager.canUpdateCalendarDayOff(calendarDayOff) && calendarStateManager.canUpdateCalendarDayOff(calendarDayOff);
boolean canDelete = calendarRightsManager.canDeleteCalendarDayOff(calendarDayOff) && calendarStateManager.canDeleteCalendarDayOff(calendarDayOff);
return new CalendarDayOffFullView(id, canUpdate, canDelete, form);
}

}

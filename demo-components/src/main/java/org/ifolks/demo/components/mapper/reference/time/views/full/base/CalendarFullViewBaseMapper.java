package org.ifolks.demo.components.mapper.reference.time.views.full.base;

import org.ifolks.commons.mapper.impl.FullViewMapper;
import org.ifolks.demo.api.model.reference.time.forms.CalendarForm;
import org.ifolks.demo.api.model.reference.time.views.full.CalendarFullView;
import org.ifolks.demo.components.rightsmanager.reference.time.CalendarRightsManager;
import org.ifolks.demo.components.statemanager.reference.time.CalendarStateManager;
import org.ifolks.demo.model.reference.time.Calendar;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

public class CalendarFullViewBaseMapper extends FullViewMapper<CalendarFullView, Integer, CalendarForm, Calendar> {

@Autowired
protected CalendarRightsManager calendarRightsManager;
@Autowired
protected CalendarStateManager calendarStateManager;

public CalendarFullViewBaseMapper() {
super(CalendarFullView.class, Calendar.class);
}

@Override
public CalendarFullView mapFrom(CalendarFullView calendarFullView, Calendar calendar) {
calendarFullView = super.mapFrom(calendarFullView, calendar);
calendarFullView.setCanUpdate(calendarRightsManager.canUpdate(calendar) && calendarStateManager.canUpdate(calendar));
calendarFullView.setCanDelete(calendarRightsManager.canDelete(calendar) && calendarStateManager.canDelete(calendar));
return calendarFullView;
}

}

package org.ifolks.demo.components.mapper.reference.time.views.full.base;

import org.ifolks.demo.api.model.reference.time.forms.CalendarForm;
import org.ifolks.demo.api.model.reference.time.views.full.CalendarFullView;
import org.ifolks.demo.components.mapper.reference.time.forms.CalendarFormMapper;
import org.ifolks.demo.components.rightsmanager.reference.time.CalendarRightsManager;
import org.ifolks.demo.components.statemanager.reference.time.CalendarStateManager;
import org.ifolks.demo.model.reference.time.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component
public class CalendarFullViewBaseMapper {

@Autowired
protected CalendarRightsManager calendarRightsManager;
@Autowired
protected CalendarStateManager calendarStateManager;

@Autowired
protected CalendarFormMapper formMapper;

/**
 * mapping entity to view
 */
public CalendarFullView toView(Calendar calendar) {
Integer id = calendar.getId();
CalendarForm form = formMapper.toForm(calendar);
boolean canUpdate = calendarRightsManager.canUpdate(calendar) && calendarStateManager.canUpdate(calendar);
boolean canDelete = calendarRightsManager.canDelete(calendar) && calendarStateManager.canDelete(calendar);
return new CalendarFullView(id, canUpdate, canDelete, form);
}

}

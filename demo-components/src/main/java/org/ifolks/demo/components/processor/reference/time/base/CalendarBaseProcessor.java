package org.ifolks.demo.components.processor.reference.time.base;

import org.ifolks.demo.model.reference.time.Calendar;
import org.ifolks.demo.model.reference.time.CalendarDayOff;
import org.ifolks.demo.persistence.interfaces.reference.time.CalendarDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CalendarBaseProcessor {

/*
 * properties injected by spring
 */
@Autowired
protected CalendarDao calendarDao;

/**
 * process save
 */
public Integer save(Calendar calendar) {
return calendarDao.save(calendar);
}

/**
 * process save one to many component CalendarDayOff
 */
public void saveCalendarDayOff(CalendarDayOff calendarDayOff,Calendar calendar) {
calendarDao.saveCalendarDayOff(calendar, calendarDayOff);
}

/**
 * process update
 */
public void update(Calendar calendar) {
// Empty by default. Can be overridden
}

/**
 * process update one to many component CalendarDayOff
 */
public void updateCalendarDayOff(CalendarDayOff calendarDayOff) {
// Empty by default. Can be overridden
}

/**
 * process delete
 */
public void delete(Calendar calendar) {
calendarDao.delete(calendar);
}

/**
 * process delete one to many component CalendarDayOff
 */
public void deleteCalendarDayOff(CalendarDayOff calendarDayOff) {
calendarDao.deleteCalendarDayOff(calendarDayOff);
}

}

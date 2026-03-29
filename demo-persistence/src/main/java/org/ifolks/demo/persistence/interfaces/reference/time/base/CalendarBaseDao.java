package org.ifolks.demo.persistence.interfaces.reference.time.base;
import java.util.List;
import org.ifolks.commons.model.patterns.BaseDao;
import org.ifolks.demo.api.model.reference.time.filters.CalendarDayOffFilter;
import org.ifolks.demo.api.model.reference.time.filters.CalendarFilter;
import org.ifolks.demo.api.model.reference.time.sortings.CalendarDayOffSorting;
import org.ifolks.demo.api.model.reference.time.sortings.CalendarSorting;
import org.ifolks.demo.model.reference.time.Calendar;
import org.ifolks.demo.model.reference.time.CalendarDayOff;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface CalendarBaseDao extends BaseDao<Calendar, Integer> {

/**
 * count filtered object list
 */
Long count(CalendarFilter filter);

/**
 * scroll filtered object list
 */
List<Calendar> scroll(CalendarFilter filter, CalendarSorting sorting, Long firstResult, Long maxResults);

/**
 * load one to many component CalendarDayOff list
 */
List<CalendarDayOff> loadCalendarDayOffList(Integer calendarId);

/**
 * count one to many component CalendarDayOff
 */
Long countCalendarDayOff(Integer calendarId);

/**
 * count filtered one to many component CalendarDayOff
 */
Long countCalendarDayOff(Integer calendarId, CalendarDayOffFilter filter);

/**
 * scroll filtered one to many component CalendarDayOff
 */
List<CalendarDayOff> scrollCalendarDayOff(Integer calendarId, CalendarDayOffFilter filter, CalendarDayOffSorting sorting, Long firstResult, Long maxResults);

/**
 * load one to many component CalendarDayOff
 */
CalendarDayOff loadCalendarDayOff(Integer id);

/**
 * exists object
 */
boolean exists(String code);

/**
 * find object or null
 */
Calendar findOrNull(String code);

/**
 * find object
 */
Calendar find(String code);

/**
 * save one to many component CalendarDayOff
 */
void saveCalendarDayOff(Calendar calendar, CalendarDayOff calendarDayOff);

/**
 * delete one to many component CalendarDayOff
 */
void deleteCalendarDayOff(CalendarDayOff calendarDayOff);

}

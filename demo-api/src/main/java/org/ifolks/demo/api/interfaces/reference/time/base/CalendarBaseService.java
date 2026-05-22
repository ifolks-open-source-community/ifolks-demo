package org.ifolks.demo.api.interfaces.reference.time.base;

import java.util.List;

import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.commons.api.model.SelectItem;
import org.ifolks.demo.api.model.reference.time.filters.CalendarDayOffFilter;
import org.ifolks.demo.api.model.reference.time.filters.CalendarFilter;
import org.ifolks.demo.api.model.reference.time.forms.CalendarDayOffForm;
import org.ifolks.demo.api.model.reference.time.forms.CalendarForm;
import org.ifolks.demo.api.model.reference.time.sortings.CalendarDayOffSorting;
import org.ifolks.demo.api.model.reference.time.sortings.CalendarSorting;
import org.ifolks.demo.api.model.reference.time.views.basic.CalendarBasicView;
import org.ifolks.demo.api.model.reference.time.views.basic.CalendarDayOffBasicView;
import org.ifolks.demo.api.model.reference.time.views.full.CalendarDayOffFullView;
import org.ifolks.demo.api.model.reference.time.views.full.CalendarFullView;

/**
 * auto generated base service interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface CalendarBaseService {

/**
 * get options
 */
List<SelectItem> getOptions();
public static final String GET_OPTIONS_URL = "/calendar/options";

/**
 * load object list
 */
List<CalendarBasicView> loadList();
public static final String GET_LIST_URL = "/calendar/list";

/**
 * scroll object list
 */
ScrollView<CalendarBasicView> scroll(ScrollForm<CalendarFilter, CalendarSorting> form);
public static final String SCROLL_URL = "/calendar/scroll";

/**
 * load object
 */
CalendarFullView load(Integer id);
public static final String GET_URL = "/calendar/{id}";

/**
 * find object
 */
public static final String FIND_URL = "/calendar/find";
CalendarFullView find(String code);

/**
 * load one to many component calendarDayOff list
 */
List<CalendarDayOffBasicView> loadCalendarDayOffList(Integer id);
public static final String GET_CALENDAR_DAY_OFF_LIST_URL = "/calendar/{id}/calendar-day-off/list";

/**
 * scroll one to many component calendarDayOff
 */
ScrollView<CalendarDayOffBasicView> scrollCalendarDayOff (Integer calendarId, ScrollForm<CalendarDayOffFilter, CalendarDayOffSorting> form);
public static final String SCROLL_CALENDAR_DAY_OFF_URL = "/calendar/{id}/calendar-day-off/scroll";

/**
 * load one to many component calendarDayOff
 */
CalendarDayOffFullView loadCalendarDayOff(Integer id);
public static final String GET_CALENDAR_DAY_OFF_URL = "/calendar-day-off/{id}";

/**
 * save object
 */
Integer save(CalendarForm calendarForm);
public static final String SAVE_URL = "/calendar";

/**
 * save one to many component calendarDayOff
 */
void saveCalendarDayOff(Integer id, CalendarDayOffForm calendarDayOffForm);
public static final String SAVE_CALENDAR_DAY_OFF_URL = "/calendar/{id}/calendar-day-off";

/**
 * update object
 */
void update(Integer id, CalendarForm calendarForm);
public static final String UPDATE_URL = "/calendar/{id}";

/**
 * update one to many component calendarDayOff
 */
void updateCalendarDayOff(Integer id, CalendarDayOffForm calendarDayOffForm);
public static final String UPDATE_CALENDAR_DAY_OFF_URL = "/calendar-day-off/{id}";

/**
 * delete object
 */
void delete(Integer id);
public static final String DELETE_URL = "/calendar/{id}";

/**
 * delete one to many component calendarDayOff
 */
void deleteCalendarDayOff(Integer id);
public static final String DELETE_CALENDAR_DAY_OFF_URL = "/calendar-day-off/{id}";

}

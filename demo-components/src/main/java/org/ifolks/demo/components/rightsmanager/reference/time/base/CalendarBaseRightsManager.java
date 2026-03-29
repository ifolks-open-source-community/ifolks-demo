package org.ifolks.demo.components.rightsmanager.reference.time.base;

import org.ifolks.commons.api.exception.rights.AccessDeniedException;
import org.ifolks.demo.model.reference.time.Calendar;
import org.ifolks.demo.model.reference.time.CalendarDayOff;

/**
 * auto generated base rights manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CalendarBaseRightsManager {

/**
 * can access all
 */
public boolean canAccess() {
return true;
}

/**
 * check can access all
 */
public void checkCanAccess() {
if (!canAccess()) {
throw new AccessDeniedException("Calendar.accessDenied");
}
}

/**
 * can access
 */
public boolean canAccess(Calendar calendar) {
return true;
}

/**
 * check can access
 */
public void checkCanAccess(Calendar calendar) {
if (!canAccess(calendar)) {
throw new AccessDeniedException("Calendar.accessDenied");
}
}

/**
 * can access one to many component CalendarDayOff
 */
public boolean canAccessCalendarDayOff(Calendar calendar) {
return canAccess(calendar);
}

/**
 * check can access one to many component CalendarDayOff
 */
public void checkCanAccessCalendarDayOff(Calendar calendar) {
if (!canAccessCalendarDayOff(calendar)) {
throw new AccessDeniedException("CalendarDayOff.accessDenied");
}
}

/**
 * can create
 */
public boolean canCreate() {
return true;
}

/**
 * check can create
 */
public void checkCanCreate() {
if (!canCreate()) {
throw new AccessDeniedException("Calendar.create.operationDenied");
}
}

/**
 * can create one to many component CalendarDayOff
 */
public boolean canCreateCalendarDayOff(Calendar calendar) {
return canUpdate(calendar);
}

/**
 * check can create one to many component CalendarDayOff
 */
public void checkCanCreateCalendarDayOff(Calendar calendar) {
if (!canCreateCalendarDayOff(calendar)) {
throw new AccessDeniedException("CalendarDayOff.create.operationDenied");
}
}

/**
 * can save
 */
public boolean canSave(Calendar calendar) {
return true;
}

/**
 * check can save
 */
public void checkCanSave(Calendar calendar) {
if (!canSave(calendar)) {
throw new AccessDeniedException("Calendar.save.operationDenied");
}
}

/**
 * can save one to many component CalendarDayOff
 */
public boolean canSaveCalendarDayOff(CalendarDayOff calendarDayOff,Calendar calendar) {
return canUpdate(calendar);
}

/**
 * check can save one to many component CalendarDayOff
 */
public void checkCanSaveCalendarDayOff(CalendarDayOff calendarDayOff,Calendar calendar) {
if (!canSaveCalendarDayOff(calendarDayOff, calendar)) {
throw new AccessDeniedException("CalendarDayOff.save.operationDenied");
}
}

/**
 * can update
 */
public boolean canUpdate(Calendar calendar) {
return true;
}

/**
 * check can update
 */
public void checkCanUpdate(Calendar calendar) {
if (!canUpdate(calendar)) {
throw new AccessDeniedException("Calendar.update.operationDenied");
}
}

/**
 * can update one to many component CalendarDayOff
 */
public boolean canUpdateCalendarDayOff(CalendarDayOff calendarDayOff) {
return canUpdate(calendarDayOff.getCalendar());
}

/**
 * check can update one to many component CalendarDayOff
 */
public void checkCanUpdateCalendarDayOff(CalendarDayOff calendarDayOff) {
if (!canUpdateCalendarDayOff(calendarDayOff)) {
throw new AccessDeniedException("CalendarDayOff.update.operationDenied");
}
}

/**
 * can delete
 */
public boolean canDelete(Calendar calendar) {
return true;
}

/**
 * check can delete
 */
public void checkCanDelete(Calendar calendar) {
if (!canDelete(calendar)) {
throw new AccessDeniedException("Calendar.delete.operationDenied");
}
}

/**
 * can delete one to many component CalendarDayOff
 */
public boolean canDeleteCalendarDayOff(CalendarDayOff calendarDayOff) {
return canUpdate(calendarDayOff.getCalendar());
}

/**
 * check can delete one to many component CalendarDayOff
 */
public void checkCanDeleteCalendarDayOff(CalendarDayOff calendarDayOff) {
if (!canDeleteCalendarDayOff(calendarDayOff)) {
throw new AccessDeniedException("CalendarDayOff.delete.operationDenied");
}
}

}

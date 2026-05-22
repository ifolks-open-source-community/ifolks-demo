package org.ifolks.demo.services.reference.time.base;

import java.util.ArrayList;
import java.util.List;

import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.commons.api.model.SelectItem;
import org.ifolks.demo.api.interfaces.reference.time.base.CalendarBaseService;
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
import org.ifolks.demo.components.mapper.reference.time.forms.CalendarDayOffFormMapper;
import org.ifolks.demo.components.mapper.reference.time.forms.CalendarFormMapper;
import org.ifolks.demo.components.mapper.reference.time.views.basic.CalendarBasicViewMapper;
import org.ifolks.demo.components.mapper.reference.time.views.basic.CalendarDayOffBasicViewMapper;
import org.ifolks.demo.components.mapper.reference.time.views.full.CalendarDayOffFullViewMapper;
import org.ifolks.demo.components.mapper.reference.time.views.full.CalendarFullViewMapper;
import org.ifolks.demo.components.processor.reference.time.CalendarProcessor;
import org.ifolks.demo.components.rightsmanager.reference.time.CalendarRightsManager;
import org.ifolks.demo.components.statemanager.reference.time.CalendarStateManager;
import org.ifolks.demo.model.reference.time.Calendar;
import org.ifolks.demo.model.reference.time.CalendarDayOff;
import org.ifolks.demo.persistence.interfaces.reference.time.CalendarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated base service class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CalendarBaseServiceImpl implements CalendarBaseService {

/*
 * properties injected by spring
 */
@Autowired
protected CalendarDao calendarDao;
@Autowired
protected CalendarFullViewMapper calendarFullViewMapper;
@Autowired
protected CalendarBasicViewMapper calendarBasicViewMapper;
@Autowired
protected CalendarFormMapper calendarFormMapper;
@Autowired
protected CalendarDayOffFullViewMapper calendarDayOffFullViewMapper;
@Autowired
protected CalendarDayOffBasicViewMapper calendarDayOffBasicViewMapper;
@Autowired
protected CalendarDayOffFormMapper calendarDayOffFormMapper;
@Autowired
protected CalendarStateManager calendarStateManager;
@Autowired
protected CalendarRightsManager calendarRightsManager;
@Autowired
protected CalendarProcessor calendarProcessor;

/**
 * get options
 */
@Override
@Transactional(readOnly=true)
public List<SelectItem> getOptions() {
List<Calendar> calendarList = calendarDao.loadList();
List<SelectItem> result = new ArrayList<>(calendarList.size());
for (Calendar calendar : calendarList) {
result.add(new SelectItem(calendar.getCode(), calendar.getCode()));
}
return result;
}

/**
 * load object list
 */
@Override
@Transactional(readOnly=true)
public List<CalendarBasicView> loadList() {
calendarRightsManager.checkCanAccess();
List<Calendar> calendarList = calendarDao.loadListEagerly();
List<CalendarBasicView> result = new ArrayList<>(calendarList.size());
for (Calendar calendar : calendarList) {
result.add(this.calendarBasicViewMapper.toView(calendar));
}
return result;
}

/**
 * scroll object list
 */
@Override
@Transactional(readOnly=true)
public ScrollView<CalendarBasicView> scroll(ScrollForm<CalendarFilter, CalendarSorting> form) {
calendarRightsManager.checkCanAccess();
Long size = calendarDao.count();
Long count = calendarDao.count(form.filter());
Long numberOfPages = count/form.elementsPerPage() + ((count%form.elementsPerPage()) > 0L?1L:0L);
Long currentPage = Math.max(1L, Math.min(form.page()!=null?form.page():1L, numberOfPages));
List<Calendar> list = calendarDao.scroll(form.filter(), form.sorting(),(currentPage-1)*form.elementsPerPage(), form.elementsPerPage());
List<CalendarBasicView> elements = new ArrayList<>(list.size());
for (Calendar calendar : list) {
elements.add(this.calendarBasicViewMapper.toView(calendar));
}
return new ScrollView<>(size, count, numberOfPages, currentPage, elements);
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public CalendarFullView load(Integer id) {
Calendar calendar = calendarDao.load(id);
calendarRightsManager.checkCanAccess(calendar);
return this.calendarFullViewMapper.toView(calendar);
}

/**
 * find object
 */
@Override
@Transactional(readOnly=true)
public CalendarFullView find(String code) {
Calendar calendar = calendarDao.find(code);
calendarRightsManager.checkCanAccess(calendar);
return this.calendarFullViewMapper.toView(calendar);
}

/**
 * load one to many component calendarDayOff list
 */
@Override
@Transactional(readOnly=true)
public List<CalendarDayOffBasicView> loadCalendarDayOffList(Integer id) {
Calendar calendar = calendarDao.load(id);
calendarRightsManager.checkCanAccessCalendarDayOff(calendar);
List<CalendarDayOff> calendarDayOffList = calendarDao.loadCalendarDayOffList(id);
List<CalendarDayOffBasicView> result = new ArrayList<>(calendarDayOffList.size());
for (CalendarDayOff calendarDayOff:calendarDayOffList){
result.add(this.calendarDayOffBasicViewMapper.toView(calendarDayOff));
}
return result;
}

/**
 * scroll one to many component calendarDayOff
 */
@Override
@Transactional(readOnly=true)
public ScrollView<CalendarDayOffBasicView> scrollCalendarDayOff (Integer calendarId, ScrollForm<CalendarDayOffFilter, CalendarDayOffSorting> form) {
Calendar calendar = calendarDao.load(calendarId);
calendarRightsManager.checkCanAccessCalendarDayOff(calendar);
Long size = calendarDao.countCalendarDayOff(calendarId);
Long count = calendarDao.countCalendarDayOff(calendarId, form.filter());
Long numberOfPages = count/form.elementsPerPage() + ((count%form.elementsPerPage()) > 0L?1L:0L);
Long currentPage = Math.max(1L, Math.min(form.page()!=null?form.page():1L, numberOfPages));
List<CalendarDayOff> list = calendarDao.scrollCalendarDayOff(calendarId, form.filter(), form.sorting(),(currentPage-1)*form.elementsPerPage(), form.elementsPerPage());
List<CalendarDayOffBasicView> elements = new ArrayList<>(list.size());
for (CalendarDayOff calendarDayOff : list) {
elements.add(this.calendarDayOffBasicViewMapper.toView(calendarDayOff));
}
return new ScrollView<>(size, count, numberOfPages, currentPage, elements);
}

/**
 * load one to many component calendarDayOff
 */
@Override
@Transactional(readOnly=true)
public CalendarDayOffFullView loadCalendarDayOff(Integer id) {
CalendarDayOff calendarDayOff = calendarDao.loadCalendarDayOff(id);
calendarRightsManager.checkCanAccessCalendarDayOff(calendarDayOff.getCalendar());
return this.calendarDayOffFullViewMapper.toView(calendarDayOff);
}

/**
 * save object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Integer save(CalendarForm calendarForm) {
Calendar calendar = this.calendarFormMapper.toEntity(calendarForm, new Calendar());
calendarRightsManager.checkCanSave(calendar);
calendarStateManager.checkCanSave(calendar);
return calendarProcessor.save(calendar);
}

/**
 * save one to many component calendarDayOff
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void saveCalendarDayOff(Integer id, CalendarDayOffForm calendarDayOffForm) {
Calendar calendar = this.calendarDao.load(id);
CalendarDayOff calendarDayOff = this.calendarDayOffFormMapper.toEntity(calendarDayOffForm, new CalendarDayOff());
calendarRightsManager.checkCanSaveCalendarDayOff(calendarDayOff,calendar);
calendarStateManager.checkCanSaveCalendarDayOff(calendarDayOff,calendar);
calendarProcessor.saveCalendarDayOff(calendarDayOff,calendar);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(Integer id, CalendarForm calendarForm) {
Calendar calendar = this.calendarDao.load(id);
calendarRightsManager.checkCanUpdate(calendar);
calendarStateManager.checkCanUpdate(calendar);
calendar = this.calendarFormMapper.toEntity(calendarForm, calendar);
calendarProcessor.update(calendar);
}

/**
 * update one to many component calendarDayOff
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void updateCalendarDayOff(Integer id, CalendarDayOffForm calendarDayOffForm) {
CalendarDayOff calendarDayOff = this.calendarDao.loadCalendarDayOff(id);
calendarRightsManager.checkCanUpdateCalendarDayOff(calendarDayOff);
calendarStateManager.checkCanUpdateCalendarDayOff(calendarDayOff);
calendarDayOff = this.calendarDayOffFormMapper.toEntity(calendarDayOffForm, calendarDayOff);
calendarProcessor.updateCalendarDayOff(calendarDayOff);
}


/**
 * delete object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void delete(Integer id) {
Calendar calendar = calendarDao.load(id);
calendarRightsManager.checkCanDelete(calendar);
calendarStateManager.checkCanDelete(calendar);
calendarProcessor.delete(calendar);
}

/**
 * delete one to many component calendarDayOff
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteCalendarDayOff(Integer id) {
CalendarDayOff calendarDayOff = calendarDao.loadCalendarDayOff(id);
calendarRightsManager.checkCanDeleteCalendarDayOff(calendarDayOff);
calendarStateManager.checkCanDeleteCalendarDayOff(calendarDayOff);
this.calendarProcessor.deleteCalendarDayOff(calendarDayOff);
}

}

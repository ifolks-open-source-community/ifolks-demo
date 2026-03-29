package org.ifolks.demo.persistence.impl.reference.time.base;

import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.*;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addBetweenRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addOrder;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addStringStartsWithRestriction;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.ifolks.commons.api.exception.repository.ObjectNotFoundException;
import org.ifolks.commons.api.model.OrderType;
import org.ifolks.commons.model.patterns.BaseDaoImpl;
import org.ifolks.demo.api.model.reference.time.filters.CalendarDayOffFilter;
import org.ifolks.demo.api.model.reference.time.filters.CalendarFilter;
import org.ifolks.demo.api.model.reference.time.sortings.CalendarDayOffSorting;
import org.ifolks.demo.api.model.reference.time.sortings.CalendarSorting;
import org.ifolks.demo.model.reference.time.Calendar;
import org.ifolks.demo.model.reference.time.CalendarDayOff;
import org.ifolks.demo.model.reference.time.CalendarDayOff_;
import org.ifolks.demo.model.reference.time.Calendar_;
import org.ifolks.demo.persistence.interfaces.reference.time.base.CalendarBaseDao;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CalendarBaseDaoImpl extends BaseDaoImpl<Calendar, Integer> implements CalendarBaseDao {

/**
 * constructor
 */
public CalendarBaseDaoImpl() {
super(Calendar.class);
}
/**
 * load object list eagerly
 */
@Override
@SuppressWarnings({"unused","unchecked"})
public List<Calendar> loadListEagerly() {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Calendar> criteria = builder.createQuery(Calendar.class);

Root<Calendar> root = criteria.from(Calendar.class);

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Calendar_.id), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * count filtered object list
 */
@Override
public Long count(CalendarFilter filter) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<Calendar> root = criteria.from(Calendar.class);

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, root.get(Calendar_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, root.get(Calendar_.label), filter.getLabel());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * scroll filtered object list
 */
@Override
@SuppressWarnings("unchecked")
public List<Calendar> scroll(CalendarFilter filter, CalendarSorting sorting, Long firstResult, Long maxResults) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Calendar> criteria = builder.createQuery(Calendar.class);

Root<Calendar> root = criteria.from(Calendar.class);

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, root.get(Calendar_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, root.get(Calendar_.label), filter.getLabel());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Calendar_.code), sorting.getCodeOrderType());
addOrder(builder, orders, root.get(Calendar_.label), sorting.getLabelOrderType());
addOrder(builder, orders, root.get(Calendar_.id), OrderType.DESC);
criteria.orderBy(orders);

Query<Calendar> query = session.createQuery(criteria);
if (firstResult != null){
query.setFirstResult(firstResult.intValue());
}
if (maxResults != null){
query.setMaxResults(maxResults.intValue());
}
return query.getResultList();
}

/**
 * load one to many component CalendarDayOff list
 */
@Override
public List<CalendarDayOff> loadCalendarDayOffList(Integer calendarId) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<CalendarDayOff> criteria = builder.createQuery(CalendarDayOff.class);

Root<CalendarDayOff> root = criteria.from(CalendarDayOff.class);
Join<CalendarDayOff, Calendar> calendar = root.join(CalendarDayOff_.calendar, JoinType.LEFT);

if (calendarId == null){
criteria.where(builder.isNull(calendar.get(Calendar_.id)));
} else {
criteria.where(builder.equal(calendar.get(Calendar_.id), calendarId));
}

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(CalendarDayOff_.id), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * count one to many component CalendarDayOff
 */
@Override
public Long countCalendarDayOff(Integer calendarId) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<CalendarDayOff> root = criteria.from(CalendarDayOff.class);
Join<CalendarDayOff, Calendar> calendar = root.join(CalendarDayOff_.calendar, JoinType.LEFT);

if (calendarId == null){
criteria.where(builder.isNull(calendar.get(Calendar_.id)));
} else {
criteria.where(builder.equal(calendar.get(Calendar_.id), calendarId));
}

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * count filtered one to many component CalendarDayOff
 */
@Override
public Long countCalendarDayOff(Integer calendarId, CalendarDayOffFilter filter) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<CalendarDayOff> root = criteria.from(CalendarDayOff.class);
Join<CalendarDayOff, Calendar> calendar = root.join(CalendarDayOff_.calendar, JoinType.LEFT);

List<Predicate> predicates = new ArrayList<>();
addBetweenRestriction(builder, predicates, root.get(CalendarDayOff_.dayOffDate), filter.getDayOffDateMinValue(), filter.getDayOffDateMaxValue());
addStringStartsWithRestriction(builder, predicates, root.get(CalendarDayOff_.dayOffLabel), filter.getDayOffLabel());
if (calendarId == null){
predicates.add(builder.isNull(calendar.get(Calendar_.id)));
} else {
predicates.add(builder.equal(calendar.get(Calendar_.id), calendarId));
}
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * scroll filtered one to many component CalendarDayOff
 */
@Override
public List<CalendarDayOff> scrollCalendarDayOff(Integer calendarId, CalendarDayOffFilter filter, CalendarDayOffSorting sorting, Long firstResult, Long maxResults) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<CalendarDayOff> criteria = builder.createQuery(CalendarDayOff.class);

Root<CalendarDayOff> root = criteria.from(CalendarDayOff.class);
Join<CalendarDayOff, Calendar> calendar = root.join(CalendarDayOff_.calendar, JoinType.LEFT);

List<Predicate> predicates = new ArrayList<>();
addBetweenRestriction(builder, predicates, root.get(CalendarDayOff_.dayOffDate), filter.getDayOffDateMinValue(), filter.getDayOffDateMaxValue());
addStringStartsWithRestriction(builder, predicates, root.get(CalendarDayOff_.dayOffLabel), filter.getDayOffLabel());
if (calendarId == null){
predicates.add(builder.isNull(calendar.get(Calendar_.id)));
} else {
predicates.add(builder.equal(calendar.get(Calendar_.id), calendarId));
}
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(CalendarDayOff_.dayOffDate), sorting.getDayOffDateOrderType());
addOrder(builder, orders, root.get(CalendarDayOff_.dayOffLabel), sorting.getDayOffLabelOrderType());
addOrder(builder, orders, root.get(CalendarDayOff_.id), OrderType.DESC);
criteria.orderBy(orders);

Query<CalendarDayOff> query = session.createQuery(criteria);
if (firstResult != null){
query.setFirstResult(firstResult.intValue());
}
if (maxResults != null){
query.setMaxResults(maxResults.intValue());
}
return query.getResultList();
}

/**
 * load one to many component CalendarDayOff
 */
@Override
public CalendarDayOff loadCalendarDayOff(Integer id) {
CalendarDayOff calendarDayOff = (CalendarDayOff)this.sessionFactory.getCurrentSession().get(CalendarDayOff.class,id);
if (calendarDayOff == null) {
throw new ObjectNotFoundException("CalendarDayOff.notFound");
} else {
return calendarDayOff;
}
}

/**
 * find object or null
 */
@Override
public Calendar findOrNull(String code) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Calendar> criteria = builder.createQuery(Calendar.class);

Root<Calendar> root = criteria.from(Calendar.class);

List<Predicate> predicates = new ArrayList<>();
addEqualsRestriction(builder, predicates, root.get(Calendar_.code), code);
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);

return session.createQuery(criteria).uniqueResult();
}

/**
 * find object
 */
@Override
public Calendar find(String code) {
if (code == null) {
return null;
}
Calendar calendar = findOrNull(code);
if (calendar == null) {
throw new ObjectNotFoundException("Calendar.notFound");
} else {
return calendar;
}
}

/**
 * exists object
 */
@Override
public boolean exists(String code) {
if (code == null) {
return false;
}
Calendar calendar = findOrNull(code);
return calendar != null;
}

/**
 * save one to many component CalendarDayOff
 */
@Override
public void saveCalendarDayOff(Calendar calendar, CalendarDayOff calendarDayOff) {
calendarDayOff.setCalendar(calendar);
this.sessionFactory.getCurrentSession().save(calendarDayOff);
}

/**
 * delete one to many component CalendarDayOff
 */
@Override
public void deleteCalendarDayOff(CalendarDayOff calendarDayOff) {
calendarDayOff.getCalendar().getCalendarDayOffCollection().remove(calendarDayOff);
this.sessionFactory.getCurrentSession().delete(calendarDayOff);
}

}
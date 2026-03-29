package org.ifolks.demo.persistence.impl.dummy.base;

import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.*;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addOrder;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addStringStartsWithRestriction;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Fetch;
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
import org.ifolks.demo.api.model.dummy.filters.StupidFilter;
import org.ifolks.demo.api.model.dummy.sortings.StupidSorting;
import org.ifolks.demo.model.dummy.Fool;
import org.ifolks.demo.model.dummy.Fool_;
import org.ifolks.demo.model.dummy.Stupid;
import org.ifolks.demo.model.dummy.Stupid_;
import org.ifolks.demo.persistence.interfaces.dummy.base.StupidBaseDao;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class StupidBaseDaoImpl extends BaseDaoImpl<Stupid, Long> implements StupidBaseDao {

/**
 * constructor
 */
public StupidBaseDaoImpl() {
super(Stupid.class);
}
/**
 * load object list eagerly
 */
@Override
@SuppressWarnings({"unused","unchecked"})
public List<Stupid> loadListEagerly() {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Stupid> criteria = builder.createQuery(Stupid.class);

Root<Stupid> root = criteria.from(Stupid.class);
Fetch<Stupid, Fool> foolFetch = root.fetch(Stupid_.fool, JoinType.LEFT);
Join<Stupid, Fool> fool = (Join<Stupid, Fool>)foolFetch;

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Stupid_.id), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * load object list from fool
 */
@Override
public List<Stupid> loadListFromFool(String foolId) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Stupid> criteria = builder.createQuery(Stupid.class);

Root<Stupid> root = criteria.from(Stupid.class);
Join<Stupid, Fool> fool = root.join(Stupid_.fool, JoinType.LEFT);

if (foolId == null){
criteria.where(builder.isNull(fool.get(Fool_.id)));
} else {
criteria.where(builder.equal(fool.get(Fool_.id), foolId));
}

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Stupid_.id), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * load object list eagerly from fool
 */
@Override
@SuppressWarnings({"unused","unchecked"})
public List<Stupid> loadListEagerlyFromFool(String foolId) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Stupid> criteria = builder.createQuery(Stupid.class);

Root<Stupid> root = criteria.from(Stupid.class);
Fetch<Stupid, Fool> foolFetch = root.fetch(Stupid_.fool, JoinType.LEFT);
Join<Stupid, Fool> fool = (Join<Stupid, Fool>)foolFetch;

if (foolId == null){
criteria.where(builder.isNull(fool.get(Fool_.id)));
} else {
criteria.where(builder.equal(fool.get(Fool_.id), foolId));
}

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Stupid_.id), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * count filtered object list
 */
@Override
public Long count(StupidFilter filter) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<Stupid> root = criteria.from(Stupid.class);
Join<Stupid, Fool> fool = root.join(Stupid_.fool, JoinType.LEFT);

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, root.get(Stupid_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, fool.get(Fool_.code), filter.getFoolCode());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * count object list from fool
 */
public Long countFromFool(String foolId) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<Stupid> root = criteria.from(Stupid.class);
Join<Stupid, Fool> fool = root.join(Stupid_.fool, JoinType.LEFT);

if (foolId == null){
criteria.where(builder.isNull(fool.get(Fool_.id)));
} else {
criteria.where(builder.equal(fool.get(Fool_.id), foolId));
}

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * count filtered object list from fool
 */
public Long countFromFool(String foolId, StupidFilter filter) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<Stupid> root = criteria.from(Stupid.class);
Join<Stupid, Fool> fool = root.join(Stupid_.fool, JoinType.LEFT);

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, root.get(Stupid_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, fool.get(Fool_.code), filter.getFoolCode());
if (foolId == null){
predicates.add(builder.isNull(fool.get(Fool_.id)));
} else {
predicates.add(builder.equal(fool.get(Fool_.id), foolId));
}

criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * scroll filtered object list
 */
@Override
@SuppressWarnings("unchecked")
public List<Stupid> scroll(StupidFilter filter, StupidSorting sorting, Long firstResult, Long maxResults) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Stupid> criteria = builder.createQuery(Stupid.class);

Root<Stupid> root = criteria.from(Stupid.class);
Fetch<Stupid, Fool> foolFetch = root.fetch(Stupid_.fool, JoinType.LEFT);
Join<Stupid, Fool> fool = (Join<Stupid, Fool>)foolFetch;

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, root.get(Stupid_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, fool.get(Fool_.code), filter.getFoolCode());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Stupid_.code), sorting.getCodeOrderType());
addOrder(builder, orders, fool.get(Fool_.code), sorting.getFoolCodeOrderType());
addOrder(builder, orders, root.get(Stupid_.id), OrderType.DESC);
criteria.orderBy(orders);

Query<Stupid> query = session.createQuery(criteria);
if (firstResult != null){
query.setFirstResult(firstResult.intValue());
}
if (maxResults != null){
query.setMaxResults(maxResults.intValue());
}
return query.getResultList();
}

/**
 * scroll filtered object list from fool
 */
@Override
@SuppressWarnings("unchecked")
public List<Stupid> scrollFromFool(String foolId, StupidFilter filter, StupidSorting sorting, Long firstResult, Long maxResults) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Stupid> criteria = builder.createQuery(Stupid.class);

Root<Stupid> root = criteria.from(Stupid.class);
Fetch<Stupid, Fool> foolFetch = root.fetch(Stupid_.fool, JoinType.LEFT);
Join<Stupid, Fool> fool = (Join<Stupid, Fool>)foolFetch;

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, root.get(Stupid_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, fool.get(Fool_.code), filter.getFoolCode());
if (foolId == null){
predicates.add(builder.isNull(fool.get(Fool_.id)));
} else {
predicates.add(builder.equal(fool.get(Fool_.id), foolId));
}
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Stupid_.code), sorting.getCodeOrderType());
addOrder(builder, orders, fool.get(Fool_.code), sorting.getFoolCodeOrderType());
addOrder(builder, orders, root.get(Stupid_.id), OrderType.DESC);
criteria.orderBy(orders);

Query<Stupid> query = session.createQuery(criteria);
if (firstResult != null){
query.setFirstResult(firstResult.intValue());
}
if (maxResults != null){
query.setMaxResults(maxResults.intValue());
}
return query.getResultList();
}

/**
 * find object or null
 */
@Override
public Stupid findOrNull(String code) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Stupid> criteria = builder.createQuery(Stupid.class);

Root<Stupid> root = criteria.from(Stupid.class);

List<Predicate> predicates = new ArrayList<>();
addEqualsRestriction(builder, predicates, root.get(Stupid_.code), code);
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);

return session.createQuery(criteria).uniqueResult();
}

/**
 * find object
 */
@Override
public Stupid find(String code) {
if (code == null) {
return null;
}
Stupid stupid = findOrNull(code);
if (stupid == null) {
throw new ObjectNotFoundException("Stupid.notFound");
} else {
return stupid;
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
Stupid stupid = findOrNull(code);
return stupid != null;
}

}
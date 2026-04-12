package org.ifolks.demo.persistence.impl.reference.localization.base;

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
import org.ifolks.demo.api.model.reference.localization.filters.CityFilter;
import org.ifolks.demo.api.model.reference.localization.sortings.CitySorting;
import org.ifolks.demo.model.reference.localization.City;
import org.ifolks.demo.model.reference.localization.City_;
import org.ifolks.demo.model.reference.localization.Country;
import org.ifolks.demo.model.reference.localization.Country_;
import org.ifolks.demo.model.reference.localization.Region;
import org.ifolks.demo.model.reference.localization.Region_;
import org.ifolks.demo.persistence.interfaces.reference.localization.base.CityBaseDao;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CityBaseDaoImpl extends BaseDaoImpl<City, Long> implements CityBaseDao {

/**
 * constructor
 */
public CityBaseDaoImpl() {
super(City.class);
}
/**
 * load object list eagerly
 */
@Override
@SuppressWarnings({"unused","unchecked"})
public List<City> loadListEagerly() {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<City> criteria = builder.createQuery(City.class);

Root<City> root = criteria.from(City.class);
Fetch<City, Region> regionFetch = root.fetch(City_.region, JoinType.LEFT);
Join<City, Region> region = (Join<City, Region>)regionFetch;
Fetch<Region, Country> regionCountryFetch = region.fetch(Region_.country, JoinType.LEFT);
Join<Region, Country> regionCountry = (Join<Region, Country>)regionCountryFetch;

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(City_.id), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * load object list from region
 */
@Override
public List<City> loadListFromRegion(Integer regionId) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<City> criteria = builder.createQuery(City.class);

Root<City> root = criteria.from(City.class);
Join<City, Region> region = root.join(City_.region, JoinType.LEFT);

if (regionId == null){
criteria.where(builder.isNull(region.get(Region_.id)));
} else {
criteria.where(builder.equal(region.get(Region_.id), regionId));
}

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(City_.id), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * load object list eagerly from region
 */
@Override
@SuppressWarnings({"unused","unchecked"})
public List<City> loadListEagerlyFromRegion(Integer regionId) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<City> criteria = builder.createQuery(City.class);

Root<City> root = criteria.from(City.class);
Fetch<City, Region> regionFetch = root.fetch(City_.region, JoinType.LEFT);
Join<City, Region> region = (Join<City, Region>)regionFetch;
Fetch<Region, Country> regionCountryFetch = region.fetch(Region_.country, JoinType.LEFT);
Join<Region, Country> regionCountry = (Join<Region, Country>)regionCountryFetch;

if (regionId == null){
criteria.where(builder.isNull(region.get(Region_.id)));
} else {
criteria.where(builder.equal(region.get(Region_.id), regionId));
}

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(City_.id), OrderType.DESC);
criteria.orderBy(orders);

return session.createQuery(criteria).getResultList();
}

/**
 * count filtered object list
 */
@Override
public Long count(CityFilter filter) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<City> root = criteria.from(City.class);
Join<City, Region> region = root.join(City_.region, JoinType.LEFT);
Join<Region, Country> regionCountry = region.join(Region_.country, JoinType.LEFT);

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, regionCountry.get(Country_.code), filter.getRegionCountryCode());
addStringStartsWithRestriction(builder, predicates, region.get(Region_.code), filter.getRegionCode());
addStringStartsWithRestriction(builder, predicates, root.get(City_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, root.get(City_.label), filter.getLabel());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * count object list from region
 */
public Long countFromRegion(Integer regionId) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<City> root = criteria.from(City.class);
Join<City, Region> region = root.join(City_.region, JoinType.LEFT);

if (regionId == null){
criteria.where(builder.isNull(region.get(Region_.id)));
} else {
criteria.where(builder.equal(region.get(Region_.id), regionId));
}

criteria.select(builder.count(root));
return session.createQuery(criteria).getSingleResult();
}

/**
 * count filtered object list from region
 */
public Long countFromRegion(Integer regionId, CityFilter filter) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<City> root = criteria.from(City.class);
Join<City, Region> region = root.join(City_.region, JoinType.LEFT);
Join<Region, Country> regionCountry = region.join(Region_.country, JoinType.LEFT);

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, regionCountry.get(Country_.code), filter.getRegionCountryCode());
addStringStartsWithRestriction(builder, predicates, region.get(Region_.code), filter.getRegionCode());
addStringStartsWithRestriction(builder, predicates, root.get(City_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, root.get(City_.label), filter.getLabel());
if (regionId == null){
predicates.add(builder.isNull(region.get(Region_.id)));
} else {
predicates.add(builder.equal(region.get(Region_.id), regionId));
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
public List<City> scroll(CityFilter filter, CitySorting sorting, Long firstResult, Long maxResults) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<City> criteria = builder.createQuery(City.class);

Root<City> root = criteria.from(City.class);
Fetch<City, Region> regionFetch = root.fetch(City_.region, JoinType.LEFT);
Join<City, Region> region = (Join<City, Region>)regionFetch;
Fetch<Region, Country> regionCountryFetch = region.fetch(Region_.country, JoinType.LEFT);
Join<Region, Country> regionCountry = (Join<Region, Country>)regionCountryFetch;

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, regionCountry.get(Country_.code), filter.getRegionCountryCode());
addStringStartsWithRestriction(builder, predicates, region.get(Region_.code), filter.getRegionCode());
addStringStartsWithRestriction(builder, predicates, root.get(City_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, root.get(City_.label), filter.getLabel());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, regionCountry.get(Country_.code), sorting.getRegionCountryCodeOrderType());
addOrder(builder, orders, region.get(Region_.code), sorting.getRegionCodeOrderType());
addOrder(builder, orders, root.get(City_.code), sorting.getCodeOrderType());
addOrder(builder, orders, root.get(City_.label), sorting.getLabelOrderType());
addOrder(builder, orders, root.get(City_.id), OrderType.DESC);
criteria.orderBy(orders);

Query<City> query = session.createQuery(criteria);
if (firstResult != null){
query.setFirstResult(firstResult.intValue());
}
if (maxResults != null){
query.setMaxResults(maxResults.intValue());
}
return query.getResultList();
}

/**
 * scroll filtered object list from region
 */
@Override
@SuppressWarnings("unchecked")
public List<City> scrollFromRegion(Integer regionId, CityFilter filter, CitySorting sorting, Long firstResult, Long maxResults) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<City> criteria = builder.createQuery(City.class);

Root<City> root = criteria.from(City.class);
Fetch<City, Region> regionFetch = root.fetch(City_.region, JoinType.LEFT);
Join<City, Region> region = (Join<City, Region>)regionFetch;
Fetch<Region, Country> regionCountryFetch = region.fetch(Region_.country, JoinType.LEFT);
Join<Region, Country> regionCountry = (Join<Region, Country>)regionCountryFetch;

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, regionCountry.get(Country_.code), filter.getRegionCountryCode());
addStringStartsWithRestriction(builder, predicates, region.get(Region_.code), filter.getRegionCode());
addStringStartsWithRestriction(builder, predicates, root.get(City_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, root.get(City_.label), filter.getLabel());
if (regionId == null){
predicates.add(builder.isNull(region.get(Region_.id)));
} else {
predicates.add(builder.equal(region.get(Region_.id), regionId));
}
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, regionCountry.get(Country_.code), sorting.getRegionCountryCodeOrderType());
addOrder(builder, orders, region.get(Region_.code), sorting.getRegionCodeOrderType());
addOrder(builder, orders, root.get(City_.code), sorting.getCodeOrderType());
addOrder(builder, orders, root.get(City_.label), sorting.getLabelOrderType());
addOrder(builder, orders, root.get(City_.id), OrderType.DESC);
criteria.orderBy(orders);

Query<City> query = session.createQuery(criteria);
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
public City findOrNull(String regionCountryCode, String regionCode, String code) {
Session session = this.sessionFactory.getCurrentSession();
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<City> criteria = builder.createQuery(City.class);

Root<City> root = criteria.from(City.class);
Join<City, Region> region = root.join(City_.region, JoinType.LEFT);
Join<Region, Country> regionCountry = region.join(Region_.country, JoinType.LEFT);

List<Predicate> predicates = new ArrayList<>();
addEqualsRestriction(builder, predicates, regionCountry.get(Country_.code), regionCountryCode);
addEqualsRestriction(builder, predicates, region.get(Region_.code), regionCode);
addEqualsRestriction(builder, predicates, root.get(City_.code), code);
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);

return session.createQuery(criteria).uniqueResult();
}

/**
 * find object
 */
@Override
public City find(String regionCountryCode, String regionCode, String code) {
if (regionCountryCode == null && regionCode == null && code == null) {
return null;
}
City city = findOrNull(regionCountryCode, regionCode, code);
if (city == null) {
throw new ObjectNotFoundException("City.notFound");
} else {
return city;
}
}

/**
 * exists object
 */
@Override
public boolean exists(String regionCountryCode, String regionCode, String code) {
if (regionCountryCode == null && regionCode == null && code == null) {
return false;
}
City city = findOrNull(regionCountryCode, regionCode, code);
return city != null;
}

}
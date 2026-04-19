package org.ifolks.demo.persistence.impl.reference.localization.base;

import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addOrder;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addStringStartsWithRestriction;

import jakarta.persistence.TypedQuery;
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
import org.ifolks.commons.api.exception.repository.ObjectNotFoundException;
import org.ifolks.commons.api.model.OrderType;
import org.ifolks.commons.model.patterns.BaseDaoImpl;
import org.ifolks.demo.api.model.reference.localization.filters.RegionFilter;
import org.ifolks.demo.api.model.reference.localization.sortings.RegionSorting;
import org.ifolks.demo.model.reference.localization.Country;
import org.ifolks.demo.model.reference.localization.Country_;
import org.ifolks.demo.model.reference.localization.Region;
import org.ifolks.demo.model.reference.localization.Region_;
import org.ifolks.demo.persistence.interfaces.reference.localization.base.RegionBaseDao;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class RegionBaseDaoImpl extends BaseDaoImpl<Region, Integer> implements RegionBaseDao {

/**
 * constructor
 */
public RegionBaseDaoImpl() {
super(Region.class);
}
/**
 * load object list eagerly
 */
@Override
public List<Region> loadListEagerly() {
CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Region> criteria = builder.createQuery(Region.class);

Root<Region> root = criteria.from(Region.class);
Fetch<Region, Country> countryFetch = root.fetch(Region_.country, JoinType.LEFT);
Join<Region, Country> country = (Join<Region, Country>)countryFetch;

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Region_.id), OrderType.DESC);
criteria.orderBy(orders);

return entityManager.createQuery(criteria).getResultList();
}

/**
 * load object list from country
 */
@Override
public List<Region> loadListFromCountry(Short countryId) {
CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Region> criteria = builder.createQuery(Region.class);

Root<Region> root = criteria.from(Region.class);
Join<Region, Country> country = root.join(Region_.country, JoinType.LEFT);

if (countryId == null){
criteria.where(builder.isNull(country.get(Country_.id)));
} else {
criteria.where(builder.equal(country.get(Country_.id), countryId));
}

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Region_.id), OrderType.DESC);
criteria.orderBy(orders);

return entityManager.createQuery(criteria).getResultList();
}

/**
 * load object list eagerly from country
 */
@Override
public List<Region> loadListEagerlyFromCountry(Short countryId) {
CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Region> criteria = builder.createQuery(Region.class);

Root<Region> root = criteria.from(Region.class);
Fetch<Region, Country> countryFetch = root.fetch(Region_.country, JoinType.LEFT);
Join<Region, Country> country = (Join<Region, Country>)countryFetch;

if (countryId == null){
criteria.where(builder.isNull(country.get(Country_.id)));
} else {
criteria.where(builder.equal(country.get(Country_.id), countryId));
}

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Region_.id), OrderType.DESC);
criteria.orderBy(orders);

return entityManager.createQuery(criteria).getResultList();
}

/**
 * count filtered object list
 */
@Override
public Long count(RegionFilter filter) {
CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<Region> root = criteria.from(Region.class);
Join<Region, Country> country = root.join(Region_.country, JoinType.LEFT);

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, country.get(Country_.code), filter.getCountryCode());
addStringStartsWithRestriction(builder, predicates, root.get(Region_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, root.get(Region_.label), filter.getLabel());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(builder.count(root));
return entityManager.createQuery(criteria).getSingleResult();
}

/**
 * count object list from country
 */
public Long countFromCountry(Short countryId) {
CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<Region> root = criteria.from(Region.class);
Join<Region, Country> country = root.join(Region_.country, JoinType.LEFT);

if (countryId == null){
criteria.where(builder.isNull(country.get(Country_.id)));
} else {
criteria.where(builder.equal(country.get(Country_.id), countryId));
}

criteria.select(builder.count(root));
return entityManager.createQuery(criteria).getSingleResult();
}

/**
 * count filtered object list from country
 */
public Long countFromCountry(Short countryId, RegionFilter filter) {
CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<Region> root = criteria.from(Region.class);
Join<Region, Country> country = root.join(Region_.country, JoinType.LEFT);

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, country.get(Country_.code), filter.getCountryCode());
addStringStartsWithRestriction(builder, predicates, root.get(Region_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, root.get(Region_.label), filter.getLabel());
if (countryId == null){
predicates.add(builder.isNull(country.get(Country_.id)));
} else {
predicates.add(builder.equal(country.get(Country_.id), countryId));
}

criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(builder.count(root));
return entityManager.createQuery(criteria).getSingleResult();
}

/**
 * scroll filtered object list
 */
@Override
public List<Region> scroll(RegionFilter filter, RegionSorting sorting, Long firstResult, Long maxResults) {
CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Region> criteria = builder.createQuery(Region.class);

Root<Region> root = criteria.from(Region.class);
Fetch<Region, Country> countryFetch = root.fetch(Region_.country, JoinType.LEFT);
Join<Region, Country> country = (Join<Region, Country>)countryFetch;

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, country.get(Country_.code), filter.getCountryCode());
addStringStartsWithRestriction(builder, predicates, root.get(Region_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, root.get(Region_.label), filter.getLabel());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, country.get(Country_.code), sorting.getCountryCodeOrderType());
addOrder(builder, orders, root.get(Region_.code), sorting.getCodeOrderType());
addOrder(builder, orders, root.get(Region_.label), sorting.getLabelOrderType());
addOrder(builder, orders, root.get(Region_.id), OrderType.DESC);
criteria.orderBy(orders);

TypedQuery<Region> query = entityManager.createQuery(criteria);
if (firstResult != null){
query.setFirstResult(firstResult.intValue());
}
if (maxResults != null){
query.setMaxResults(maxResults.intValue());
}
return query.getResultList();
}

/**
 * scroll filtered object list from country
 */
@Override
public List<Region> scrollFromCountry(Short countryId, RegionFilter filter, RegionSorting sorting, Long firstResult, Long maxResults) {
CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Region> criteria = builder.createQuery(Region.class);

Root<Region> root = criteria.from(Region.class);
Fetch<Region, Country> countryFetch = root.fetch(Region_.country, JoinType.LEFT);
Join<Region, Country> country = (Join<Region, Country>)countryFetch;

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, country.get(Country_.code), filter.getCountryCode());
addStringStartsWithRestriction(builder, predicates, root.get(Region_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, root.get(Region_.label), filter.getLabel());
if (countryId == null){
predicates.add(builder.isNull(country.get(Country_.id)));
} else {
predicates.add(builder.equal(country.get(Country_.id), countryId));
}
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, country.get(Country_.code), sorting.getCountryCodeOrderType());
addOrder(builder, orders, root.get(Region_.code), sorting.getCodeOrderType());
addOrder(builder, orders, root.get(Region_.label), sorting.getLabelOrderType());
addOrder(builder, orders, root.get(Region_.id), OrderType.DESC);
criteria.orderBy(orders);

TypedQuery<Region> query = entityManager.createQuery(criteria);
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
public Region findOrNull(String countryCode, String code) {
CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Region> criteria = builder.createQuery(Region.class);

Root<Region> root = criteria.from(Region.class);
Join<Region, Country> country = root.join(Region_.country, JoinType.LEFT);

List<Predicate> predicates = new ArrayList<>();
addEqualsRestriction(builder, predicates, country.get(Country_.code), countryCode);
addEqualsRestriction(builder, predicates, root.get(Region_.code), code);
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);

return entityManager.createQuery(criteria).getSingleResult();
}

/**
 * find object
 */
@Override
public Region find(String countryCode, String code) {
if (countryCode == null && code == null) {
return null;
}
Region region = findOrNull(countryCode, code);
if (region == null) {
throw new ObjectNotFoundException("Region.notFound");
} else {
return region;
}
}

/**
 * exists object
 */
@Override
public boolean exists(String countryCode, String code) {
if (countryCode == null && code == null) {
return false;
}
Region region = findOrNull(countryCode, code);
return region != null;
}

}
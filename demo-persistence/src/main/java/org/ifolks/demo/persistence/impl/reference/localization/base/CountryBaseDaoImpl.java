package org.ifolks.demo.persistence.impl.reference.localization.base;

import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addOrder;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addStringStartsWithRestriction;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import org.ifolks.commons.api.exception.repository.ObjectNotFoundException;
import org.ifolks.commons.api.model.OrderType;
import org.ifolks.commons.model.patterns.BaseDaoImpl;
import org.ifolks.demo.api.model.reference.localization.filters.CountryFilter;
import org.ifolks.demo.api.model.reference.localization.sortings.CountrySorting;
import org.ifolks.demo.model.reference.localization.Country;
import org.ifolks.demo.model.reference.localization.Country_;
import org.ifolks.demo.persistence.interfaces.reference.localization.base.CountryBaseDao;

/**
 * auto generated base dao class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CountryBaseDaoImpl extends BaseDaoImpl<Country, Short> implements CountryBaseDao {

/**
 * constructor
 */
public CountryBaseDaoImpl() {
super(Country.class);
}
/**
 * load object list eagerly
 */
@Override
public List<Country> loadListEagerly() {
CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Country> criteria = builder.createQuery(Country.class);

Root<Country> root = criteria.from(Country.class);

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Country_.id), OrderType.DESC);
criteria.orderBy(orders);

return entityManager.createQuery(criteria).getResultList();
}

/**
 * count filtered object list
 */
@Override
public Long count(CountryFilter filter) {
CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

Root<Country> root = criteria.from(Country.class);

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, root.get(Country_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, root.get(Country_.label), filter.getLabel());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(builder.count(root));
return entityManager.createQuery(criteria).getSingleResult();
}

/**
 * scroll filtered object list
 */
@Override
public List<Country> scroll(CountryFilter filter, CountrySorting sorting, Long firstResult, Long maxResults) {
CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Country> criteria = builder.createQuery(Country.class);

Root<Country> root = criteria.from(Country.class);

List<Predicate> predicates = new ArrayList<>();
addStringStartsWithRestriction(builder, predicates, root.get(Country_.code), filter.getCode());
addStringStartsWithRestriction(builder, predicates, root.get(Country_.label), filter.getLabel());
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);
List<Order> orders = new ArrayList<>();
addOrder(builder, orders, root.get(Country_.code), sorting.getCodeOrderType());
addOrder(builder, orders, root.get(Country_.label), sorting.getLabelOrderType());
addOrder(builder, orders, root.get(Country_.id), OrderType.DESC);
criteria.orderBy(orders);

TypedQuery<Country> query = entityManager.createQuery(criteria);
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
public Country findOrNull(String code) {
CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Country> criteria = builder.createQuery(Country.class);

Root<Country> root = criteria.from(Country.class);

List<Predicate> predicates = new ArrayList<>();
addEqualsRestriction(builder, predicates, root.get(Country_.code), code);
criteria.where(predicates.toArray(new Predicate[predicates.size()]));

criteria.select(root);

return entityManager.createQuery(criteria).getSingleResult();
}

/**
 * find object
 */
@Override
public Country find(String code) {
if (code == null) {
return null;
}
Country country = findOrNull(code);
if (country == null) {
throw new ObjectNotFoundException("Country.notFound");
} else {
return country;
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
Country country = findOrNull(code);
return country != null;
}

}
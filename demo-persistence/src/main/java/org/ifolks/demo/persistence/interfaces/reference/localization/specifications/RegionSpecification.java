package org.ifolks.demo.persistence.interfaces.reference.localization.specifications;

import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addStringStartsWithRestriction;

import java.util.ArrayList;
import java.util.List;

import org.ifolks.commons.api.model.OrderType;
import org.ifolks.demo.api.model.reference.localization.filters.RegionFilter;
import org.ifolks.demo.api.model.reference.localization.sortings.RegionSorting;
import org.ifolks.demo.model.reference.localization.Country;
import org.ifolks.demo.model.reference.localization.Country_;
import org.ifolks.demo.model.reference.localization.Region;
import org.ifolks.demo.model.reference.localization.Region_;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;

/**
 * auto generated specifications class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class RegionSpecification {

	public static Specification<Region> filterBy(RegionFilter filter) {
		return (root, query, cb) -> {
			boolean isCountQuery = Long.class.equals(query.getResultType()) || long.class.equals(query.getResultType());
			List<Predicate> predicates = new ArrayList<>();

			Join<Region, Country> country;
			if (isCountQuery) {
				country = root.join(Region_.country, JoinType.LEFT);
			} else {
				country = (Join<Region, Country>)root.fetch(Region_.country, JoinType.LEFT);
			}

			addStringStartsWithRestriction(cb, predicates, country.get(Country_.code), filter.getCountryCode());
			addStringStartsWithRestriction(cb, predicates, root.get(Region_.code), filter.getCode());
			addStringStartsWithRestriction(cb, predicates, root.get(Region_.label), filter.getLabel());
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Specification<Region> filterByCountrySpec(Short parentId) {
		return (root, query, cb) -> {
			boolean isCountQuery = Long.class.equals(query.getResultType()) || long.class.equals(query.getResultType());
			Join<Region, Country> country;
			if (isCountQuery) {
				country = root.join(Region_.country, JoinType.LEFT);
			} else {
				country = (Join<Region, Country>)root.fetch(Region_.country, JoinType.LEFT);
			}
			if (parentId == null) {
				return cb.isNull(country.get(Country_.id));
			} else {
				return cb.equal(country.get(Country_.id), parentId);
			}
		};
	}

	public static Specification<Region> filterByKeySpec(String countryCode, String code) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			Join<Region, Country> country = root.join(Region_.country, JoinType.LEFT);

			addEqualsRestriction(cb, predicates, country.get(Country_.code), countryCode);
			addEqualsRestriction(cb, predicates, root.get(Region_.code), code);

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Sort getSort(RegionSorting sorting) {
		List<Sort.Order> orders = new ArrayList<>();
		if (sorting.getCountryCodeOrderType() != null) {
			orders.add(new Sort.Order(sorting.getCountryCodeOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "countryCode"));
		}
		if (sorting.getCodeOrderType() != null) {
			orders.add(new Sort.Order(sorting.getCodeOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "code"));
		}
		if (sorting.getLabelOrderType() != null) {
			orders.add(new Sort.Order(sorting.getLabelOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "label"));
		}
		orders.add(new Sort.Order(Sort.Direction.DESC, "id"));
		return Sort.by(orders);
	}

/* Specific Code Start */
/* Specific Code End */
}

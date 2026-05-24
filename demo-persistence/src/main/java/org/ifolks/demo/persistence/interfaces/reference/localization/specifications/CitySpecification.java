package org.ifolks.demo.persistence.interfaces.reference.localization.specifications;

import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addStringStartsWithRestriction;

import java.util.ArrayList;
import java.util.List;

import org.ifolks.commons.api.model.OrderType;
import org.ifolks.demo.api.model.reference.localization.filters.CityFilter;
import org.ifolks.demo.api.model.reference.localization.sortings.CitySorting;
import org.ifolks.demo.model.reference.localization.City;
import org.ifolks.demo.model.reference.localization.City_;
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
public class CitySpecification {

	public static Specification<City> filterBy(CityFilter filter) {
		return (root, query, cb) -> {
			boolean isCountQuery = Long.class.equals(query.getResultType()) || long.class.equals(query.getResultType());
			List<Predicate> predicates = new ArrayList<>();

			Join<City, Region> region;
			if (isCountQuery) {
				region = root.join(City_.region, JoinType.LEFT);
			} else {
				region = (Join<City, Region>)root.fetch(City_.region, JoinType.LEFT);
			}

			Join<Region, Country> regionCountry;
			if (isCountQuery) {
				regionCountry = region.join(Region_.country, JoinType.LEFT);
			} else {
				regionCountry = (Join<Region, Country>)region.fetch(Region_.country, JoinType.LEFT);
			}

			addStringStartsWithRestriction(cb, predicates, regionCountry.get(Country_.code), filter.getRegionCountryCode());
			addStringStartsWithRestriction(cb, predicates, region.get(Region_.code), filter.getRegionCode());
			addStringStartsWithRestriction(cb, predicates, root.get(City_.code), filter.getCode());
			addStringStartsWithRestriction(cb, predicates, root.get(City_.label), filter.getLabel());
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Specification<City> filterByRegionSpec(Integer parentId) {
		return (root, query, cb) -> {
			boolean isCountQuery = Long.class.equals(query.getResultType()) || long.class.equals(query.getResultType());
			Join<City, Region> region;
			if (isCountQuery) {
				region = root.join(City_.region, JoinType.LEFT);
			} else {
				region = (Join<City, Region>)root.fetch(City_.region, JoinType.LEFT);
			}
			if (parentId == null) {
				return cb.isNull(region.get(Region_.id));
			} else {
				return cb.equal(region.get(Region_.id), parentId);
			}
		};
	}

	public static Specification<City> filterByKeySpec(String regionCountryCode, String regionCode, String code) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			Join<City, Region> region = root.join(City_.region, JoinType.LEFT);
			Join<Region, Country> regionCountry = region.join(Region_.country, JoinType.LEFT);

			addEqualsRestriction(cb, predicates, regionCountry.get(Country_.code), regionCountryCode);
			addEqualsRestriction(cb, predicates, region.get(Region_.code), regionCode);
			addEqualsRestriction(cb, predicates, root.get(City_.code), code);

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Sort getSort(CitySorting sorting) {
		List<Sort.Order> orders = new ArrayList<>();
		if (sorting.getRegionCountryCodeOrderType() != null) {
			orders.add(new Sort.Order(sorting.getRegionCountryCodeOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "regionCountryCode"));
		}
		if (sorting.getRegionCodeOrderType() != null) {
			orders.add(new Sort.Order(sorting.getRegionCodeOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "regionCode"));
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

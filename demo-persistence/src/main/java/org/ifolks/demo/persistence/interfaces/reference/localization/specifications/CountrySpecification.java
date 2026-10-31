package org.ifolks.demo.persistence.interfaces.reference.localization.specifications;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.ifolks.commons.api.model.OrderType;
import org.ifolks.demo.api.model.reference.localization.filters.CountryFilter;
import org.ifolks.demo.api.model.reference.localization.sortings.CountrySorting;
import org.ifolks.demo.model.reference.localization.Country;
import org.ifolks.demo.model.reference.localization.Country_;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import static org.ifolks.commons.jpa.JpaCriteriaUtils.*;
import static org.ifolks.commons.jpa.JpaCriteriaUtils.addEqualsRestriction;
import static org.ifolks.commons.jpa.JpaCriteriaUtils.addStringStartsWithRestriction;

/**
 * auto generated specifications class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class CountrySpecification {

	public static Specification<Country> filterBy(CountryFilter filter) {
		return (root, query, cb) -> {
			boolean isCountQuery = Long.class.equals(query.getResultType()) || long.class.equals(query.getResultType());
			List<Predicate> predicates = new ArrayList<>();

			addStringStartsWithRestriction(cb, predicates, root.get(Country_.code), filter.getCode());
			addStringStartsWithRestriction(cb, predicates, root.get(Country_.label), filter.getLabel());
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Specification<Country> filterByKeySpec(String code) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			addEqualsRestriction(cb, predicates, root.get(Country_.code), code);

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Sort getSort(CountrySorting sorting) {
		List<Sort.Order> orders = new ArrayList<>();
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

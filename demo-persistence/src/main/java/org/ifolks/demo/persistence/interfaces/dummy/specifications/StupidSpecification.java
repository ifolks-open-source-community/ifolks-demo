package org.ifolks.demo.persistence.interfaces.dummy.specifications;

import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addStringStartsWithRestriction;

import java.util.ArrayList;
import java.util.List;

import org.ifolks.commons.api.model.OrderType;
import org.ifolks.demo.api.model.dummy.filters.StupidFilter;
import org.ifolks.demo.api.model.dummy.sortings.StupidSorting;
import org.ifolks.demo.model.dummy.Fool;
import org.ifolks.demo.model.dummy.Fool_;
import org.ifolks.demo.model.dummy.Stupid;
import org.ifolks.demo.model.dummy.Stupid_;
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
public class StupidSpecification {

	public static Specification<Stupid> filterBy(StupidFilter filter) {
		return (root, query, cb) -> {
			boolean isCountQuery = Long.class.equals(query.getResultType()) || long.class.equals(query.getResultType());
			List<Predicate> predicates = new ArrayList<>();

			Join<Stupid, Fool> fool;
			if (isCountQuery) {
				fool = root.join(Stupid_.fool, JoinType.LEFT);
			} else {
				fool = (Join<Stupid, Fool>)root.fetch(Stupid_.fool, JoinType.LEFT);
			}

			addStringStartsWithRestriction(cb, predicates, root.get(Stupid_.code), filter.getCode());
			addStringStartsWithRestriction(cb, predicates, fool.get(Fool_.code), filter.getFoolCode());
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Specification<Stupid> filterByKeySpec(String code) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			addEqualsRestriction(cb, predicates, root.get(Stupid_.code), code);

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Sort getSort(StupidSorting sorting) {
		List<Sort.Order> orders = new ArrayList<>();
		if (sorting.getCodeOrderType() != null) {
			orders.add(new Sort.Order(sorting.getCodeOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "code"));
		}
		if (sorting.getFoolCodeOrderType() != null) {
			orders.add(new Sort.Order(sorting.getFoolCodeOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "foolCode"));
		}
		orders.add(new Sort.Order(Sort.Direction.DESC, "id"));
		return Sort.by(orders);
	}

/* Specific Code Start */
/* Specific Code End */
}

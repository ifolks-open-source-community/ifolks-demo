package org.ifolks.demo.persistence.interfaces.reference.time.specifications;

import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addStringStartsWithRestriction;

import java.util.ArrayList;
import java.util.List;

import org.ifolks.commons.api.model.OrderType;
import org.ifolks.demo.api.model.reference.time.filters.CalendarFilter;
import org.ifolks.demo.api.model.reference.time.sortings.CalendarDayOffSorting;
import org.ifolks.demo.api.model.reference.time.sortings.CalendarSorting;
import org.ifolks.demo.model.reference.time.Calendar;
import org.ifolks.demo.model.reference.time.Calendar_;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

/**
 * auto generated specifications class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class CalendarSpecification {

	public static Specification<Calendar> filterBy(CalendarFilter filter) {
		return (root, query, cb) -> {
			boolean isCountQuery = Long.class.equals(query.getResultType()) || long.class.equals(query.getResultType());
			List<Predicate> predicates = new ArrayList<>();

			addStringStartsWithRestriction(cb, predicates, root.get(Calendar_.code), filter.getCode());
			addStringStartsWithRestriction(cb, predicates, root.get(Calendar_.label), filter.getLabel());
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Specification<Calendar> filterByKeySpec(String code) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			addEqualsRestriction(cb, predicates, root.get(Calendar_.code), code);

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Sort getSort(CalendarSorting sorting) {
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

	public static Sort getSort(CalendarDayOffSorting sorting) {
		List<Sort.Order> orders = new ArrayList<>();
		if (sorting.getDayOffDateOrderType() != null) {
			orders.add(new Sort.Order(sorting.getDayOffDateOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "dayOffDate"));
		}
		if (sorting.getDayOffLabelOrderType() != null) {
			orders.add(new Sort.Order(sorting.getDayOffLabelOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "dayOffLabel"));
		}
		orders.add(new Sort.Order(Sort.Direction.DESC, "id"));
		return Sort.by(orders);
	}

/* Specific Code Start */
/* Specific Code End */
}

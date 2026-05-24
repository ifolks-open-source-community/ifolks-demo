package org.ifolks.demo.persistence.interfaces.reference.time.specifications;

import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addBetweenRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addStringStartsWithRestriction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.ifolks.commons.api.model.OrderType;
import org.ifolks.demo.api.model.reference.time.filters.CalendarDayOffFilter;
import org.ifolks.demo.api.model.reference.time.sortings.CalendarDayOffSorting;
import org.ifolks.demo.model.reference.time.Calendar;
import org.ifolks.demo.model.reference.time.CalendarDayOff;
import org.ifolks.demo.model.reference.time.CalendarDayOff_;
import org.ifolks.demo.model.reference.time.Calendar_;
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
public class CalendarDayOffSpecification {

	public static Specification<CalendarDayOff> filterBy(CalendarDayOffFilter filter) {
		return (root, query, cb) -> {
			boolean isCountQuery = Long.class.equals(query.getResultType()) || long.class.equals(query.getResultType());
			List<Predicate> predicates = new ArrayList<>();

			addBetweenRestriction(cb, predicates, root.get(CalendarDayOff_.dayOffDate), filter.getDayOffDateMinValue(), filter.getDayOffDateMaxValue());
			addStringStartsWithRestriction(cb, predicates, root.get(CalendarDayOff_.dayOffLabel), filter.getDayOffLabel());
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Specification<CalendarDayOff> filterByCalendarSpec(Integer parentId) {
		return (root, query, cb) -> {
			boolean isCountQuery = Long.class.equals(query.getResultType()) || long.class.equals(query.getResultType());
			Join<CalendarDayOff, Calendar> calendar;
			if (isCountQuery) {
				calendar = root.join(CalendarDayOff_.calendar, JoinType.LEFT);
			} else {
				calendar = (Join<CalendarDayOff, Calendar>)root.fetch(CalendarDayOff_.calendar, JoinType.LEFT);
			}
			if (parentId == null) {
				return cb.isNull(calendar.get(Calendar_.id));
			} else {
				return cb.equal(calendar.get(Calendar_.id), parentId);
			}
		};
	}

	public static Specification<CalendarDayOff> filterByKeySpec(String calendarCode, LocalDate dayOffDate) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			Join<CalendarDayOff, Calendar> calendar = root.join(CalendarDayOff_.calendar, JoinType.LEFT);

			addEqualsRestriction(cb, predicates, calendar.get(Calendar_.code), calendarCode);
			addEqualsRestriction(cb, predicates, root.get(CalendarDayOff_.dayOffDate), dayOffDate);

			return cb.and(predicates.toArray(new Predicate[0]));
		};
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

package org.ifolks.demo.persistence.interfaces.dummy.specifications;

import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addBetweenRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addBooleanRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addStringStartsWithRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.getStringStartsWithRestriction;

import java.util.ArrayList;
import java.util.List;

import org.ifolks.commons.api.model.OrderType;
import org.ifolks.demo.api.model.dummy.filters.FoolFilter;
import org.ifolks.demo.api.model.dummy.sortings.FoolSorting;
import org.ifolks.demo.model.dummy.Fool;
import org.ifolks.demo.model.dummy.Fool_;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate;

/**
 * auto generated specifications class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class FoolSpecification {

	public static Specification<Fool> filterBy(FoolFilter filter) {
		return (root, query, cb) -> {
			boolean isCountQuery = Long.class.equals(query.getResultType()) || long.class.equals(query.getResultType());
			List<Predicate> predicates = new ArrayList<>();

			addStringStartsWithRestriction(cb, predicates, root.get(Fool_.code), filter.getCode());
			addStringStartsWithRestriction(cb, predicates, root.get(Fool_.description), filter.getDescription());
			addBooleanRestriction(cb, predicates, root.get(Fool_.booleanField), filter.getBooleanField());
			addBetweenRestriction(cb, predicates, root.get(Fool_.dateField), filter.getDateFieldMinValue(), filter.getDateFieldMaxValue());
			addBetweenRestriction(cb, predicates, root.get(Fool_.datetimeField), filter.getDatetimeFieldMinValue(), filter.getDatetimeFieldMaxValue());
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Specification<Fool> filterByKeySpec(String code) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			addEqualsRestriction(cb, predicates, root.get(Fool_.code), code);

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Specification<Fool> searchSpec(String arg) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			Predicate predicate = getStringStartsWithRestriction(cb, root.get(Fool_.description), arg);
			if (predicate != null) {
				predicates.add(predicate);
			}
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Sort getSort(FoolSorting sorting) {
		List<Sort.Order> orders = new ArrayList<>();
		if (sorting.getCodeOrderType() != null) {
			orders.add(new Sort.Order(sorting.getCodeOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "code"));
		}
		if (sorting.getDescriptionOrderType() != null) {
			orders.add(new Sort.Order(sorting.getDescriptionOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "description"));
		}
		if (sorting.getLongFieldOrderType() != null) {
			orders.add(new Sort.Order(sorting.getLongFieldOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "longField"));
		}
		if (sorting.getBooleanFieldOrderType() != null) {
			orders.add(new Sort.Order(sorting.getBooleanFieldOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "booleanField"));
		}
		if (sorting.getDoubleFieldOrderType() != null) {
			orders.add(new Sort.Order(sorting.getDoubleFieldOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "doubleField"));
		}
		if (sorting.getDecimalFieldOrderType() != null) {
			orders.add(new Sort.Order(sorting.getDecimalFieldOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "decimalField"));
		}
		if (sorting.getDateFieldOrderType() != null) {
			orders.add(new Sort.Order(sorting.getDateFieldOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "dateField"));
		}
		if (sorting.getDatetimeFieldOrderType() != null) {
			orders.add(new Sort.Order(sorting.getDatetimeFieldOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "datetimeField"));
		}
		orders.add(new Sort.Order(Sort.Direction.DESC, "id"));
		return Sort.by(orders);
	}

/* Specific Code Start */
/* Specific Code End */
}

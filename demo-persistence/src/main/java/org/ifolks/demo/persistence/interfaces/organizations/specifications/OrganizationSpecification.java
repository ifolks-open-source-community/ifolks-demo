package org.ifolks.demo.persistence.interfaces.organizations.specifications;

import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addEqualsRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.addStringStartsWithRestriction;
import static org.ifolks.commons.model.patterns.JpaCriteriaUtils.getStringStartsWithRestriction;

import java.util.ArrayList;
import java.util.List;

import org.ifolks.commons.api.model.OrderType;
import org.ifolks.demo.api.model.organizations.filters.OrganizationFilter;
import org.ifolks.demo.api.model.organizations.sortings.OrganizationSorting;
import org.ifolks.demo.model.organizations.Organization;
import org.ifolks.demo.model.organizations.OrganizationDescription;
import org.ifolks.demo.model.organizations.OrganizationDescription_;
import org.ifolks.demo.model.organizations.Organization_;
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
public class OrganizationSpecification {

	public static Specification<Organization> filterBy(OrganizationFilter filter) {
		return (root, query, cb) -> {
			boolean isCountQuery = Long.class.equals(query.getResultType()) || long.class.equals(query.getResultType());
			List<Predicate> predicates = new ArrayList<>();

			Join<Organization, OrganizationDescription> organizationDescription;
			if (isCountQuery) {
				organizationDescription = root.join(Organization_.organizationDescription, JoinType.LEFT);
			} else {
				organizationDescription = (Join<Organization, OrganizationDescription>)root.fetch(Organization_.organizationDescription, JoinType.LEFT);
			}

			addStringStartsWithRestriction(cb, predicates, root.get(Organization_.code), filter.getCode());
			addStringStartsWithRestriction(cb, predicates, organizationDescription.get(OrganizationDescription_.description), filter.getDescription());
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Specification<Organization> filterByKeySpec(String code) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			addEqualsRestriction(cb, predicates, root.get(Organization_.code), code);

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Specification<Organization> searchSpec(String arg) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			Predicate predicate = getStringStartsWithRestriction(cb, root.get(Organization_.code), arg);
			if (predicate != null) {
				predicates.add(predicate);
			}
			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

	public static Sort getSort(OrganizationSorting sorting) {
		List<Sort.Order> orders = new ArrayList<>();
		if (sorting.getCodeOrderType() != null) {
			orders.add(new Sort.Order(sorting.getCodeOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "code"));
		}
		if (sorting.getDescriptionOrderType() != null) {
			orders.add(new Sort.Order(sorting.getDescriptionOrderType() == OrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, "description"));
		}
		orders.add(new Sort.Order(Sort.Direction.DESC, "id"));
		return Sort.by(orders);
	}

/* Specific Code Start */
/* Specific Code End */
}

package org.ifolks.demo.persistence.interfaces.organizations.base;

import java.util.List;
import java.util.Optional;

import org.ifolks.demo.api.model.organizations.filters.OrganizationFilter;
import org.ifolks.demo.api.model.organizations.sortings.OrganizationSorting;
import org.ifolks.demo.model.organizations.Organization;
import org.ifolks.demo.persistence.interfaces.organizations.specifications.OrganizationSpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * auto generated base repository interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface OrganizationBaseRepository extends JpaRepository<Organization, Integer>, JpaSpecificationExecutor<Organization> {

	default List<Organization> loadAll() {
		return findAll(OrganizationSpecification.filterBy(new OrganizationFilter()));
	}

	default Long count(OrganizationFilter filter) {
		return count(OrganizationSpecification.filterBy(filter));
	}

	default List<Organization> scroll(OrganizationFilter filter, OrganizationSorting sorting, Long firstResult, Long maxResults) {
		int page = (firstResult == null || maxResults == null || maxResults == 0) ? 0 : (int)(firstResult / maxResults);
		int size = (maxResults == null || maxResults == 0) ? Integer.MAX_VALUE : maxResults.intValue();
		Pageable pageable = PageRequest.of(page, size, OrganizationSpecification.getSort(sorting));
		return findAll(OrganizationSpecification.filterBy(filter), pageable).getContent();
	}

	default boolean exists(String code) {
		return findOne(OrganizationSpecification.filterByKeySpec(code)).isPresent();
	}

	default Optional<Organization> find(String code) {
		return findOne(OrganizationSpecification.filterByKeySpec(code));
	}

	default List<Organization> search(String arg) {
		return findAll(OrganizationSpecification.searchSpec(arg), PageRequest.of(0, 20)).getContent();
	}

}

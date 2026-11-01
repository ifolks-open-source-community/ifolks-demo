package org.ifolks.demo.persistence.interfaces.reference.localization.base;

import java.util.List;
import java.util.Optional;

import org.ifolks.demo.api.model.reference.localization.filters.CountryFilter;
import org.ifolks.demo.api.model.reference.localization.sortings.CountrySorting;
import org.ifolks.demo.model.reference.localization.Country;
import org.ifolks.demo.persistence.interfaces.reference.localization.specifications.CountrySpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * auto generated base repository interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface CountryBaseRepository extends JpaRepository<Country, Short>, JpaSpecificationExecutor<Country> {

	default List<Country> loadAll() {
		return findAll(CountrySpecification.filterBy(new CountryFilter()));
	}

	default Long count(CountryFilter filter) {
		return count(CountrySpecification.filterBy(filter));
	}

	default List<Country> scroll(CountryFilter filter, CountrySorting sorting, Long firstResult, Long maxResults) {
		int page = (firstResult == null || maxResults == null || maxResults == 0) ? 0 : (int)(firstResult / maxResults);
		int size = (maxResults == null || maxResults == 0) ? Integer.MAX_VALUE : maxResults.intValue();
		Pageable pageable = PageRequest.of(page, size, CountrySpecification.getSort(sorting));
		return findAll(CountrySpecification.filterBy(filter), pageable).getContent();
	}

	default boolean exists(String code) {
		return findOne(CountrySpecification.filterByKeySpec(code)).isPresent();
	}

	default Optional<Country> find(String code) {
		return findOne(CountrySpecification.filterByKeySpec(code));
	}

}

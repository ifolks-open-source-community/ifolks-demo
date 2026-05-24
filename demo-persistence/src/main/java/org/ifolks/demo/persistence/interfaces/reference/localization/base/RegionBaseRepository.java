package org.ifolks.demo.persistence.interfaces.reference.localization.base;

import java.util.List;
import java.util.Optional;

import org.ifolks.demo.api.model.reference.localization.filters.RegionFilter;
import org.ifolks.demo.api.model.reference.localization.sortings.RegionSorting;
import org.ifolks.demo.model.reference.localization.Region;
import org.ifolks.demo.persistence.interfaces.reference.localization.specifications.RegionSpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * auto generated base repository interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface RegionBaseRepository extends JpaRepository<Region, Integer>, JpaSpecificationExecutor<Region> {

	default List<Region> loadAll() {
		return findAll(RegionSpecification.filterBy(new RegionFilter()));
	}

	default List<Region> loadListFromCountry(Short countryId) {
		return findAll(RegionSpecification.filterByCountrySpec(countryId));
	}

	default Long count(RegionFilter filter) {
		return count(RegionSpecification.filterBy(filter));
	}

	default Long countFromCountry(Short countryId) {
		return count(RegionSpecification.filterByCountrySpec(countryId));
	}

	default Long countFromCountry(Short countryId, RegionFilter filter) {
		Specification<Region> spec = Specification.where(RegionSpecification.filterByCountrySpec(countryId))
			.and(RegionSpecification.filterBy(filter));
		return count(spec);
	}

	default List<Region> scroll(RegionFilter filter, RegionSorting sorting, Long firstResult, Long maxResults) {
		int page = (firstResult == null || maxResults == null || maxResults == 0) ? 0 : (int)(firstResult / maxResults);
		int size = (maxResults == null || maxResults == 0) ? Integer.MAX_VALUE : maxResults.intValue();
		Pageable pageable = PageRequest.of(page, size, RegionSpecification.getSort(sorting));
		return findAll(RegionSpecification.filterBy(filter), pageable).getContent();
	}

	default List<Region> scrollFromCountry(Short countryId, RegionFilter filter, RegionSorting sorting, Long firstResult, Long maxResults) {
		int page = (firstResult == null || maxResults == null || maxResults == 0) ? 0 : (int)(firstResult / maxResults);
		int size = (maxResults == null || maxResults == 0) ? Integer.MAX_VALUE : maxResults.intValue();
		Pageable pageable = PageRequest.of(page, size, RegionSpecification.getSort(sorting));
		Specification<Region> spec = Specification.where(RegionSpecification.filterByCountrySpec(countryId))
			.and(RegionSpecification.filterBy(filter));
		return findAll(spec, pageable).getContent();
	}

	default boolean exists(String countryCode, String code) {
		return findOne(RegionSpecification.filterByKeySpec(countryCode, code)).isPresent();
	}

	default Optional<Region> find(String countryCode, String code) {
		return findOne(RegionSpecification.filterByKeySpec(countryCode, code));
	}

}

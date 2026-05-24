package org.ifolks.demo.persistence.interfaces.reference.localization.base;

import java.util.List;
import java.util.Optional;

import org.ifolks.demo.api.model.reference.localization.filters.CityFilter;
import org.ifolks.demo.api.model.reference.localization.sortings.CitySorting;
import org.ifolks.demo.model.reference.localization.City;
import org.ifolks.demo.persistence.interfaces.reference.localization.specifications.CitySpecification;
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
public interface CityBaseRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {

	default List<City> loadAll() {
		return findAll(CitySpecification.filterBy(new CityFilter()));
	}

	default List<City> loadListFromRegion(Integer regionId) {
		return findAll(CitySpecification.filterByRegionSpec(regionId));
	}

	default Long count(CityFilter filter) {
		return count(CitySpecification.filterBy(filter));
	}

	default Long countFromRegion(Integer regionId) {
		return count(CitySpecification.filterByRegionSpec(regionId));
	}

	default Long countFromRegion(Integer regionId, CityFilter filter) {
		Specification<City> spec = Specification.where(CitySpecification.filterByRegionSpec(regionId))
			.and(CitySpecification.filterBy(filter));
		return count(spec);
	}

	default List<City> scroll(CityFilter filter, CitySorting sorting, Long firstResult, Long maxResults) {
		int page = (firstResult == null || maxResults == null || maxResults == 0) ? 0 : (int)(firstResult / maxResults);
		int size = (maxResults == null || maxResults == 0) ? Integer.MAX_VALUE : maxResults.intValue();
		Pageable pageable = PageRequest.of(page, size, CitySpecification.getSort(sorting));
		return findAll(CitySpecification.filterBy(filter), pageable).getContent();
	}

	default List<City> scrollFromRegion(Integer regionId, CityFilter filter, CitySorting sorting, Long firstResult, Long maxResults) {
		int page = (firstResult == null || maxResults == null || maxResults == 0) ? 0 : (int)(firstResult / maxResults);
		int size = (maxResults == null || maxResults == 0) ? Integer.MAX_VALUE : maxResults.intValue();
		Pageable pageable = PageRequest.of(page, size, CitySpecification.getSort(sorting));
		Specification<City> spec = Specification.where(CitySpecification.filterByRegionSpec(regionId))
			.and(CitySpecification.filterBy(filter));
		return findAll(spec, pageable).getContent();
	}

	default boolean exists(String regionCountryCode, String regionCode, String code) {
		return findOne(CitySpecification.filterByKeySpec(regionCountryCode, regionCode, code)).isPresent();
	}

	default Optional<City> find(String regionCountryCode, String regionCode, String code) {
		return findOne(CitySpecification.filterByKeySpec(regionCountryCode, regionCode, code));
	}

}

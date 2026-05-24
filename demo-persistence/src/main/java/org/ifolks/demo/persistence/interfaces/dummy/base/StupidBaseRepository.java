package org.ifolks.demo.persistence.interfaces.dummy.base;

import java.util.List;
import java.util.Optional;

import org.ifolks.demo.api.model.dummy.filters.StupidFilter;
import org.ifolks.demo.api.model.dummy.sortings.StupidSorting;
import org.ifolks.demo.model.dummy.Stupid;
import org.ifolks.demo.persistence.interfaces.dummy.specifications.StupidSpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * auto generated base repository interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface StupidBaseRepository extends JpaRepository<Stupid, Long>, JpaSpecificationExecutor<Stupid> {

	default List<Stupid> loadAll() {
		return findAll(StupidSpecification.filterBy(new StupidFilter()));
	}

	default Long count(StupidFilter filter) {
		return count(StupidSpecification.filterBy(filter));
	}

	default List<Stupid> scroll(StupidFilter filter, StupidSorting sorting, Long firstResult, Long maxResults) {
		int page = (firstResult == null || maxResults == null || maxResults == 0) ? 0 : (int)(firstResult / maxResults);
		int size = (maxResults == null || maxResults == 0) ? Integer.MAX_VALUE : maxResults.intValue();
		Pageable pageable = PageRequest.of(page, size, StupidSpecification.getSort(sorting));
		return findAll(StupidSpecification.filterBy(filter), pageable).getContent();
	}

	default boolean exists(String code) {
		return findOne(StupidSpecification.filterByKeySpec(code)).isPresent();
	}

	default Optional<Stupid> find(String code) {
		return findOne(StupidSpecification.filterByKeySpec(code));
	}

}

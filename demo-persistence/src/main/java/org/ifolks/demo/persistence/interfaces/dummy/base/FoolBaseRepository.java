package org.ifolks.demo.persistence.interfaces.dummy.base;

import java.util.List;
import java.util.Optional;

import org.ifolks.demo.api.model.dummy.filters.FoolFilter;
import org.ifolks.demo.api.model.dummy.sortings.FoolSorting;
import org.ifolks.demo.model.dummy.Fool;
import org.ifolks.demo.persistence.interfaces.dummy.specifications.FoolSpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * auto generated base repository interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface FoolBaseRepository extends JpaRepository<Fool, String>, JpaSpecificationExecutor<Fool> {

	default List<Fool> loadAll() {
		return findAll(FoolSpecification.filterBy(new FoolFilter()));
	}

	default Long count(FoolFilter filter) {
		return count(FoolSpecification.filterBy(filter));
	}

	default List<Fool> scroll(FoolFilter filter, FoolSorting sorting, Long firstResult, Long maxResults) {
		int page = (firstResult == null || maxResults == null || maxResults == 0) ? 0 : (int)(firstResult / maxResults);
		int size = (maxResults == null || maxResults == 0) ? Integer.MAX_VALUE : maxResults.intValue();
		Pageable pageable = PageRequest.of(page, size, FoolSpecification.getSort(sorting));
		return findAll(FoolSpecification.filterBy(filter), pageable).getContent();
	}

	default boolean exists(String code) {
		return findOne(FoolSpecification.filterByKeySpec(code)).isPresent();
	}

	default Optional<Fool> find(String code) {
		return findOne(FoolSpecification.filterByKeySpec(code));
	}

	default List<Fool> search(String arg) {
		return findAll(FoolSpecification.searchSpec(arg), PageRequest.of(0, 20)).getContent();
	}

}

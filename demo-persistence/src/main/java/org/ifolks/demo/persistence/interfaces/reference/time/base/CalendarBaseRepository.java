package org.ifolks.demo.persistence.interfaces.reference.time.base;

import java.util.List;
import java.util.Optional;

import org.ifolks.demo.api.model.reference.time.filters.CalendarFilter;
import org.ifolks.demo.api.model.reference.time.sortings.CalendarSorting;
import org.ifolks.demo.model.reference.time.Calendar;
import org.ifolks.demo.persistence.interfaces.reference.time.specifications.CalendarSpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * auto generated base repository interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface CalendarBaseRepository extends JpaRepository<Calendar, Integer>, JpaSpecificationExecutor<Calendar> {

	default List<Calendar> loadAll() {
		return findAll(CalendarSpecification.filterBy(new CalendarFilter()));
	}

	default Long count(CalendarFilter filter) {
		return count(CalendarSpecification.filterBy(filter));
	}

	default List<Calendar> scroll(CalendarFilter filter, CalendarSorting sorting, Long firstResult, Long maxResults) {
		int page = (firstResult == null || maxResults == null || maxResults == 0) ? 0 : (int)(firstResult / maxResults);
		int size = (maxResults == null || maxResults == 0) ? Integer.MAX_VALUE : maxResults.intValue();
		Pageable pageable = PageRequest.of(page, size, CalendarSpecification.getSort(sorting));
		return findAll(CalendarSpecification.filterBy(filter), pageable).getContent();
	}

	default boolean exists(String code) {
		return findOne(CalendarSpecification.filterByKeySpec(code)).isPresent();
	}

	default Optional<Calendar> find(String code) {
		return findOne(CalendarSpecification.filterByKeySpec(code));
	}

}

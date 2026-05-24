package org.ifolks.demo.persistence.interfaces.reference.time.base;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.ifolks.demo.api.model.reference.time.filters.CalendarDayOffFilter;
import org.ifolks.demo.api.model.reference.time.sortings.CalendarDayOffSorting;
import org.ifolks.demo.model.reference.time.CalendarDayOff;
import org.ifolks.demo.persistence.interfaces.reference.time.specifications.CalendarDayOffSpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * auto generated base repository interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface CalendarDayOffBaseRepository extends JpaRepository<CalendarDayOff, Integer>, JpaSpecificationExecutor<CalendarDayOff> {

	default List<CalendarDayOff> loadAll() {
		return findAll(CalendarDayOffSpecification.filterBy(new CalendarDayOffFilter()));
	}

	default Long count(CalendarDayOffFilter filter) {
		return count(CalendarDayOffSpecification.filterBy(filter));
	}

	default List<CalendarDayOff> scroll(CalendarDayOffFilter filter, CalendarDayOffSorting sorting, Long firstResult, Long maxResults) {
		int page = (firstResult == null || maxResults == null || maxResults == 0) ? 0 : (int)(firstResult / maxResults);
		int size = (maxResults == null || maxResults == 0) ? Integer.MAX_VALUE : maxResults.intValue();
		Pageable pageable = PageRequest.of(page, size, CalendarDayOffSpecification.getSort(sorting));
		return findAll(CalendarDayOffSpecification.filterBy(filter), pageable).getContent();
	}

	default boolean exists(String calendarCode, LocalDate dayOffDate) {
		return findOne(CalendarDayOffSpecification.filterByKeySpec(calendarCode, dayOffDate)).isPresent();
	}

	default Optional<CalendarDayOff> find(String calendarCode, LocalDate dayOffDate) {
		return findOne(CalendarDayOffSpecification.filterByKeySpec(calendarCode, dayOffDate));
	}

}

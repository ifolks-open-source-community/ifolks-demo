package org.ifolks.demo.persistence.interfaces.reference.localization.base;
import java.util.List;

import org.ifolks.commons.model.patterns.BaseDao;
import org.ifolks.demo.api.model.reference.localization.filters.CountryFilter;
import org.ifolks.demo.api.model.reference.localization.sortings.CountrySorting;
import org.ifolks.demo.model.reference.localization.Country;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface CountryBaseDao extends BaseDao<Country, Short> {

/**
 * count filtered object list
 */
Long count(CountryFilter filter);

/**
 * scroll filtered object list
 */
List<Country> scroll(CountryFilter filter, CountrySorting sorting, Long firstResult, Long maxResults);

/**
 * exists object
 */
boolean exists(String code);

/**
 * find object or null
 */
Country findOrNull(String code);

/**
 * find object
 */
Country find(String code);

}

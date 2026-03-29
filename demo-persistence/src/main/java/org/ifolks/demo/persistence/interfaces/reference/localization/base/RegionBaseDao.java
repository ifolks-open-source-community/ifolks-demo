package org.ifolks.demo.persistence.interfaces.reference.localization.base;
import java.util.List;
import org.ifolks.commons.model.patterns.BaseDao;
import org.ifolks.demo.api.model.reference.localization.filters.RegionFilter;
import org.ifolks.demo.api.model.reference.localization.sortings.RegionSorting;
import org.ifolks.demo.model.reference.localization.Region;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface RegionBaseDao extends BaseDao<Region, Integer> {

/**
 * load object list from country
 */
List<Region> loadListFromCountry(Short countryId);

/**
 * load object list eagerly from country
 */
List<Region> loadListEagerlyFromCountry(Short countryId);

/**
 * count filtered object list
 */
Long count(RegionFilter filter);

/**
 * count object list from country
 */
Long countFromCountry(Short countryId);

/**
 * count filtered object list from country
 */
Long countFromCountry(Short countryId, RegionFilter filter);

/**
 * scroll filtered object list
 */
List<Region> scroll(RegionFilter filter, RegionSorting sorting, Long firstResult, Long maxResults);

/**
 * scroll filtered object from country
 */
List<Region> scrollFromCountry(Short countryId, RegionFilter filter, RegionSorting sorting, Long firstResult, Long maxResults);

/**
 * exists object
 */
boolean exists(String countryCode, String code);

/**
 * find object or null
 */
Region findOrNull(String countryCode, String code);

/**
 * find object
 */
Region find(String countryCode, String code);

}

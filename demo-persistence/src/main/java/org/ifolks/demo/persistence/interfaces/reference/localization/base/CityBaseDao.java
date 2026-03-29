package org.ifolks.demo.persistence.interfaces.reference.localization.base;
import java.util.List;
import org.ifolks.commons.model.patterns.BaseDao;
import org.ifolks.demo.api.model.reference.localization.filters.CityFilter;
import org.ifolks.demo.api.model.reference.localization.sortings.CitySorting;
import org.ifolks.demo.model.reference.localization.City;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface CityBaseDao extends BaseDao<City, Long> {

/**
 * load object list from region
 */
List<City> loadListFromRegion(Integer regionId);

/**
 * load object list eagerly from region
 */
List<City> loadListEagerlyFromRegion(Integer regionId);

/**
 * count filtered object list
 */
Long count(CityFilter filter);

/**
 * count object list from region
 */
Long countFromRegion(Integer regionId);

/**
 * count filtered object list from region
 */
Long countFromRegion(Integer regionId, CityFilter filter);

/**
 * scroll filtered object list
 */
List<City> scroll(CityFilter filter, CitySorting sorting, Long firstResult, Long maxResults);

/**
 * scroll filtered object from region
 */
List<City> scrollFromRegion(Integer regionId, CityFilter filter, CitySorting sorting, Long firstResult, Long maxResults);

/**
 * exists object
 */
boolean exists(String regionCountryCode, String regionCode, String code);

/**
 * find object or null
 */
City findOrNull(String regionCountryCode, String regionCode, String code);

/**
 * find object
 */
City find(String regionCountryCode, String regionCode, String code);

}

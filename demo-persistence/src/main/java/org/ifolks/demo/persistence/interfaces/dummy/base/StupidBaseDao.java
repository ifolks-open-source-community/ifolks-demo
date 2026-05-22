package org.ifolks.demo.persistence.interfaces.dummy.base;
import java.util.List;

import org.ifolks.commons.model.patterns.BaseDao;
import org.ifolks.demo.api.model.dummy.filters.StupidFilter;
import org.ifolks.demo.api.model.dummy.sortings.StupidSorting;
import org.ifolks.demo.model.dummy.Stupid;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface StupidBaseDao extends BaseDao<Stupid, Long> {

/**
 * load object list from fool
 */
List<Stupid> loadListFromFool(String foolId);

/**
 * load object list eagerly from fool
 */
List<Stupid> loadListEagerlyFromFool(String foolId);

/**
 * count filtered object list
 */
Long count(StupidFilter filter);

/**
 * count object list from fool
 */
Long countFromFool(String foolId);

/**
 * count filtered object list from fool
 */
Long countFromFool(String foolId, StupidFilter filter);

/**
 * scroll filtered object list
 */
List<Stupid> scroll(StupidFilter filter, StupidSorting sorting, Long firstResult, Long maxResults);

/**
 * scroll filtered object from fool
 */
List<Stupid> scrollFromFool(String foolId, StupidFilter filter, StupidSorting sorting, Long firstResult, Long maxResults);

/**
 * exists object
 */
boolean exists(String code);

/**
 * find object or null
 */
Stupid findOrNull(String code);

/**
 * find object
 */
Stupid find(String code);

}

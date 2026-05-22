package org.ifolks.demo.api.interfaces.reference.localization.base;

import java.util.List;

import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.demo.api.model.reference.localization.filters.CityFilter;
import org.ifolks.demo.api.model.reference.localization.forms.CityForm;
import org.ifolks.demo.api.model.reference.localization.sortings.CitySorting;
import org.ifolks.demo.api.model.reference.localization.views.basic.CityBasicView;
import org.ifolks.demo.api.model.reference.localization.views.full.CityFullView;

/**
 * auto generated base service interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface CityBaseService {

/**
 * load object list
 */
List<CityBasicView> loadList();
public static final String GET_LIST_URL = "/city/list";

/**
 * load object list from region
 */
List<CityBasicView> loadListFromRegion (Integer regionId);
public static final String GET_LIST_FROM_REGION_URL = "/region/{regionId}/city/list";

/**
 * scroll object list
 */
ScrollView<CityBasicView> scroll(ScrollForm<CityFilter, CitySorting> form);
public static final String SCROLL_URL = "/city/scroll";

/**
 * scroll object list from region
 */
ScrollView<CityBasicView> scrollFromRegion (Integer regionId, ScrollForm<CityFilter, CitySorting> form);
public static final String SCROLL_FROM_REGION_URL = "/region/{regionId}/city/scroll";

/**
 * load object
 */
CityFullView load(Long id);
public static final String GET_URL = "/city/{id}";

/**
 * find object
 */
public static final String FIND_URL = "/city/find";
CityFullView find(String regionCountryCode, String regionCode, String code);

/**
 * save object
 */
Long save(CityForm cityForm);
public static final String SAVE_URL = "/city";

/**
 * update object
 */
void update(Long id, CityForm cityForm);
public static final String UPDATE_URL = "/city/{id}";

/**
 * delete object
 */
void delete(Long id);
public static final String DELETE_URL = "/city/{id}";

}

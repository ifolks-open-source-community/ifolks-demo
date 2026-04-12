package org.ifolks.demo.api.interfaces.reference.localization.base;

import java.util.List;
import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.demo.api.model.reference.localization.filters.RegionFilter;
import org.ifolks.demo.api.model.reference.localization.forms.RegionForm;
import org.ifolks.demo.api.model.reference.localization.sortings.RegionSorting;
import org.ifolks.demo.api.model.reference.localization.views.basic.RegionBasicView;
import org.ifolks.demo.api.model.reference.localization.views.full.RegionFullView;

/**
 * auto generated base service interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface RegionBaseService {

/**
 * load object list
 */
List<RegionBasicView> loadList();
public static final String GET_LIST_URL = "/region/list";

/**
 * load object list from country
 */
List<RegionBasicView> loadListFromCountry (Short countryId);
public static final String GET_LIST_FROM_COUNTRY_URL = "/country/{countryId}/region/list";

/**
 * scroll object list
 */
ScrollView<RegionBasicView> scroll(ScrollForm<RegionFilter, RegionSorting> form);
public static final String SCROLL_URL = "/region/scroll";

/**
 * scroll object list from country
 */
ScrollView<RegionBasicView> scrollFromCountry (Short countryId, ScrollForm<RegionFilter, RegionSorting> form);
public static final String SCROLL_FROM_COUNTRY_URL = "/country/{countryId}/region/scroll";

/**
 * load object
 */
RegionFullView load(Integer id);
public static final String GET_URL = "/region/{id}";

/**
 * find object
 */
public static final String FIND_URL = "/region/find";
RegionFullView find(String countryCode, String code);

/**
 * save object
 */
Integer save(RegionForm regionForm);
public static final String SAVE_URL = "/region";

/**
 * update object
 */
void update(Integer id, RegionForm regionForm);
public static final String UPDATE_URL = "/region/{id}";

/**
 * delete object
 */
void delete(Integer id);
public static final String DELETE_URL = "/region/{id}";

}

package org.ifolks.demo.api.interfaces.dummy.base;

import java.util.List;
import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.commons.api.model.SelectItem;
import org.ifolks.demo.api.model.dummy.filters.FoolFilter;
import org.ifolks.demo.api.model.dummy.forms.FoolForm;
import org.ifolks.demo.api.model.dummy.sortings.FoolSorting;
import org.ifolks.demo.api.model.dummy.views.basic.FoolBasicView;
import org.ifolks.demo.api.model.dummy.views.full.FoolFullView;

/**
 * auto generated base service interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface FoolBaseService {

/**
 * search options
 */
List<SelectItem> searchOptions(String arg);
public static final String SEARCH_OPTIONS_URL = "/fool/options/search";

/**
 * load object list
 */
List<FoolBasicView> loadList();
public static final String GET_LIST_URL = "/fool/list";

/**
 * scroll object list
 */
ScrollView<FoolBasicView> scroll(ScrollForm<FoolFilter, FoolSorting> form);
public static final String SCROLL_URL = "/fool/scroll";

/**
 * load object
 */
FoolFullView load(String id);
public static final String GET_URL = "/fool/{id}";

/**
 * find object
 */
public static final String FIND_URL = "/fool/find";
FoolFullView find(String code);

/**
 * save object
 */
String save(FoolForm foolForm);
public static final String SAVE_URL = "/fool";

/**
 * update object
 */
void update(String id, FoolForm foolForm);
public static final String UPDATE_URL = "/fool/{id}";

/**
 * delete object
 */
void delete(String id);
public static final String DELETE_URL = "/fool/{id}";

}

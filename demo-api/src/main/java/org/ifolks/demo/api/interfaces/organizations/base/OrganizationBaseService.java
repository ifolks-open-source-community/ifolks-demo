package org.ifolks.demo.api.interfaces.organizations.base;

import java.util.List;

import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.commons.api.model.SelectItem;
import org.ifolks.demo.api.model.organizations.filters.OrganizationFilter;
import org.ifolks.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.ifolks.demo.api.model.organizations.forms.OrganizationForm;
import org.ifolks.demo.api.model.organizations.sortings.OrganizationSorting;
import org.ifolks.demo.api.model.organizations.views.basic.OrganizationBasicView;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationCertificationFullView;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationFullView;

/**
 * auto generated base service interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface OrganizationBaseService {

/**
 * search options
 */
List<SelectItem> searchOptions(String arg);
public static final String SEARCH_OPTIONS_URL = "/organization/options/search";

/**
 * load object list
 */
List<OrganizationBasicView> loadList();
public static final String GET_LIST_URL = "/organization/list";

/**
 * scroll object list
 */
ScrollView<OrganizationBasicView> scroll(ScrollForm<OrganizationFilter, OrganizationSorting> form);
public static final String SCROLL_URL = "/organization/scroll";

/**
 * load object
 */
OrganizationFullView load(Integer id);
public static final String GET_URL = "/organization/{id}";

/**
 * find object
 */
public static final String FIND_URL = "/organization/find";
OrganizationFullView find(String code);

/**
 * load one to one component organizationCertification
 */
OrganizationCertificationFullView loadOrganizationCertification(Integer id);
public static final String GET_ORGANIZATION_CERTIFICATION_URL = "/organization/{id}/organization-certification";

/**
 * save object
 */
Integer save(OrganizationForm organizationForm);
public static final String SAVE_URL = "/organization";

/**
 * save one to one component organizationCertification
 */
public void saveOrganizationCertification(Integer id, OrganizationCertificationForm organizationCertificationForm);
public static final String SAVE_ORGANIZATION_CERTIFICATION_URL = "/organization/{id}/organization-certification";

/**
 * update object
 */
void update(Integer id, OrganizationForm organizationForm);
public static final String UPDATE_URL = "/organization/{id}";

/**
 * update one to one component organizationCertification
 */
void updateOrganizationCertification(Integer id, OrganizationCertificationForm organizationCertificationForm);
public static final String UPDATE_ORGANIZATION_CERTIFICATION_URL = "/organization/{id}/organization-certification";

/**
 * delete object
 */
void delete(Integer id);
public static final String DELETE_URL = "/organization/{id}";

/**
 * delete one to one component organizationCertification
 */
public void deleteOrganizationCertification(Integer id);
public static final String DELETE_ORGANIZATION_CERTIFICATION_URL = "/organization/{id}/organization-certification";

}

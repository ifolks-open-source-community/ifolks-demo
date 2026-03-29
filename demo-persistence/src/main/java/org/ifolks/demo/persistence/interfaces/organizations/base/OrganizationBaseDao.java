package org.ifolks.demo.persistence.interfaces.organizations.base;
import java.util.List;
import org.ifolks.commons.model.patterns.BaseDao;
import org.ifolks.demo.api.model.organizations.filters.OrganizationFilter;
import org.ifolks.demo.api.model.organizations.sortings.OrganizationSorting;
import org.ifolks.demo.model.organizations.Organization;
import org.ifolks.demo.model.organizations.OrganizationCertification;
/**
 * auto generated base dao interface file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public interface OrganizationBaseDao extends BaseDao<Organization, Integer> {

/**
 * count filtered object list
 */
Long count(OrganizationFilter filter);

/**
 * scroll filtered object list
 */
List<Organization> scroll(OrganizationFilter filter, OrganizationSorting sorting, Long firstResult, Long maxResults);

/**
 * exists object
 */
boolean exists(String code);

/**
 * find object or null
 */
Organization findOrNull(String code);

/**
 * find object
 */
Organization find(String code);

/**
 * search
 */
List<Organization> search(String arg);

/**
 * save one to one component OrganizationCertification
 */
void saveOrganizationCertification(Organization organization, OrganizationCertification organizationCertification);

/**
 * delete one to one component OrganizationCertification
 */
void deleteOrganizationCertification(OrganizationCertification organizationCertification);

}

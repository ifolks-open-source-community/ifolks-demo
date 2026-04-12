package org.ifolks.demo.components.mapper.organizations.views.full.base;

import org.ifolks.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationCertificationFullView;
import org.ifolks.demo.components.mapper.organizations.forms.OrganizationCertificationFormMapper;
import org.ifolks.demo.components.rightsmanager.organizations.OrganizationRightsManager;
import org.ifolks.demo.components.statemanager.organizations.OrganizationStateManager;
import org.ifolks.demo.model.organizations.OrganizationCertification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component
public class OrganizationCertificationFullViewBaseMapper {

@Autowired
protected OrganizationRightsManager organizationRightsManager;
@Autowired
protected OrganizationStateManager organizationStateManager;

@Autowired
protected OrganizationCertificationFormMapper formMapper;

/**
 * mapping entity to view
 */
public OrganizationCertificationFullView toView(OrganizationCertification organizationCertification) {
String id = organizationCertification.getId();
OrganizationCertificationForm form = formMapper.toForm(organizationCertification);
boolean canUpdate = organizationRightsManager.canUpdateOrganizationCertification(organizationCertification) && organizationStateManager.canUpdateOrganizationCertification(organizationCertification);
boolean canDelete = organizationRightsManager.canDeleteOrganizationCertification(organizationCertification) && organizationStateManager.canDeleteOrganizationCertification(organizationCertification);
return new OrganizationCertificationFullView(id, canUpdate, canDelete, form);
}

}

package org.ifolks.demo.components.mapper.organizations.views.full.base;

import org.ifolks.commons.mapper.impl.FullViewMapper;
import org.ifolks.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationCertificationFullView;
import org.ifolks.demo.components.rightsmanager.organizations.OrganizationRightsManager;
import org.ifolks.demo.components.statemanager.organizations.OrganizationStateManager;
import org.ifolks.demo.model.organizations.OrganizationCertification;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

public class OrganizationCertificationFullViewBaseMapper extends FullViewMapper<OrganizationCertificationFullView, String, OrganizationCertificationForm, OrganizationCertification> {

@Autowired
protected OrganizationRightsManager organizationRightsManager;
@Autowired
protected OrganizationStateManager organizationStateManager;

public OrganizationCertificationFullViewBaseMapper() {
super(OrganizationCertificationFullView.class, OrganizationCertification.class);
}

@Override
public OrganizationCertificationFullView mapFrom(OrganizationCertificationFullView organizationCertificationFullView, OrganizationCertification organizationCertification) {
organizationCertificationFullView = super.mapFrom(organizationCertificationFullView, organizationCertification);
organizationCertificationFullView.setCanUpdate(organizationRightsManager.canUpdateOrganizationCertification(organizationCertification) && organizationStateManager.canUpdateOrganizationCertification(organizationCertification));
organizationCertificationFullView.setCanDelete(organizationRightsManager.canDeleteOrganizationCertification(organizationCertification) && organizationStateManager.canDeleteOrganizationCertification(organizationCertification));
return organizationCertificationFullView;
}

}

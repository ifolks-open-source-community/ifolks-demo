package org.ifolks.demo.components.mapper.organizations.views.full.base;

import org.ifolks.commons.mapper.impl.FullViewMapper;
import org.ifolks.demo.api.model.organizations.forms.OrganizationForm;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationFullView;
import org.ifolks.demo.components.rightsmanager.organizations.OrganizationRightsManager;
import org.ifolks.demo.components.statemanager.organizations.OrganizationStateManager;
import org.ifolks.demo.model.organizations.Organization;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

public class OrganizationFullViewBaseMapper extends FullViewMapper<OrganizationFullView, Integer, OrganizationForm, Organization> {

@Autowired
protected OrganizationRightsManager organizationRightsManager;
@Autowired
protected OrganizationStateManager organizationStateManager;

public OrganizationFullViewBaseMapper() {
super(OrganizationFullView.class, Organization.class);
}

@Override
public OrganizationFullView mapFrom(OrganizationFullView organizationFullView, Organization organization) {
organizationFullView = super.mapFrom(organizationFullView, organization);
organizationFullView.setCanUpdate(organizationRightsManager.canUpdate(organization) && organizationStateManager.canUpdate(organization));
organizationFullView.setCanDelete(organizationRightsManager.canDelete(organization) && organizationStateManager.canDelete(organization));
return organizationFullView;
}

}

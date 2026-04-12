package org.ifolks.demo.components.mapper.organizations.views.full.base;

import org.ifolks.demo.api.model.organizations.forms.OrganizationForm;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationFullView;
import org.ifolks.demo.components.mapper.organizations.forms.OrganizationFormMapper;
import org.ifolks.demo.components.rightsmanager.organizations.OrganizationRightsManager;
import org.ifolks.demo.components.statemanager.organizations.OrganizationStateManager;
import org.ifolks.demo.model.organizations.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component
public class OrganizationFullViewBaseMapper {

@Autowired
protected OrganizationRightsManager organizationRightsManager;
@Autowired
protected OrganizationStateManager organizationStateManager;

@Autowired
protected OrganizationFormMapper formMapper;

/**
 * mapping entity to view
 */
public OrganizationFullView toView(Organization organization) {
Integer id = organization.getId();
OrganizationForm form = formMapper.toForm(organization);
boolean canUpdate = organizationRightsManager.canUpdate(organization) && organizationStateManager.canUpdate(organization);
boolean canDelete = organizationRightsManager.canDelete(organization) && organizationStateManager.canDelete(organization);
return new OrganizationFullView(id, canUpdate, canDelete, form);
}

}

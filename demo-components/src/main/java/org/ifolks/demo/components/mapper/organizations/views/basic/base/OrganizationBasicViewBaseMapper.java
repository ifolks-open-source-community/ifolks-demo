package org.ifolks.demo.components.mapper.organizations.views.basic.base;

import org.ifolks.demo.api.model.organizations.views.basic.OrganizationBasicView;
import org.ifolks.demo.components.rightsmanager.organizations.OrganizationRightsManager;
import org.ifolks.demo.components.statemanager.organizations.OrganizationStateManager;
import org.ifolks.demo.model.organizations.Organization;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base basic view mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class OrganizationBasicViewBaseMapper {
/*
 * injections
 */
@Autowired
protected OrganizationRightsManager organizationRightsManager;
@Autowired
protected OrganizationStateManager organizationStateManager;

/**
 * mapping object to view
 */
public OrganizationBasicView toView(Organization organization) {
Integer id = organization.getId();
boolean selected = false;
boolean canDelete = organizationRightsManager.canDelete(organization) && organizationStateManager.canDelete(organization);
String code = organization.getCode();
String description = organization.getOrganizationDescription().getDescription();

return new OrganizationBasicView (
id,
selected,
canDelete,
code,
description);
}

}

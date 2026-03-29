package org.ifolks.demo.components.mapper.organizations.forms.base;

import org.ifolks.commons.mapper.impl.BasicMapperImpl;
import org.ifolks.demo.api.model.organizations.forms.OrganizationForm;
import org.ifolks.demo.model.organizations.Organization;
import org.ifolks.demo.model.organizations.OrganizationDescription;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class OrganizationFormBaseMapper extends BasicMapperImpl<OrganizationForm, Organization> {

public OrganizationFormBaseMapper() {
super(OrganizationForm.class, Organization.class);
}

/*
 * properties
 */

/**
 * mapping form from object
 */
@Override
public OrganizationForm mapFrom(OrganizationForm organizationForm, Organization organization) {
organizationForm = super.mapFrom(organizationForm, organization);
organizationForm.setDescription(organization.getOrganizationDescription().getDescription());
return organizationForm;
}

/**
 * mapping view to object
 */
@Override
public Organization mapTo(OrganizationForm organizationForm, Organization organization) {
organization = super.mapTo(organizationForm, organization);
OrganizationDescription organizationDescription = organization.getOrganizationDescription();
if (organizationDescription == null) {
organizationDescription = new OrganizationDescription();
organization.setOrganizationDescription(organizationDescription);
}
organizationDescription.setDescription(organizationForm.getDescription());
return organization;
}

}

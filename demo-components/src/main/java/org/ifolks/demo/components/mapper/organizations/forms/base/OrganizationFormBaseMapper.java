package org.ifolks.demo.components.mapper.organizations.forms.base;

import org.ifolks.demo.api.model.organizations.forms.OrganizationForm;
import org.ifolks.demo.model.organizations.Organization;
import org.ifolks.demo.model.organizations.OrganizationDescription;
import org.springframework.stereotype.Component;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
@Component
public class OrganizationFormBaseMapper {


/*
 * properties
 */

/**
 * mapping object arry to form
 */
public OrganizationForm toForm(Object[] args) {

return new OrganizationForm (
(String)args[0],
(String)args[1]);
}

/**
 * mapping entity to form
 */
public OrganizationForm toForm(Organization organization) {
String code = organization.getCode();
String description = organization.getOrganizationDescription().getDescription();

return new OrganizationForm (
code,
description);
}

/**
 * mapping form to entity
 */
public Organization toEntity(OrganizationForm organizationForm, Organization organization) {
organization.setCode(organizationForm.code());
OrganizationDescription organizationDescription = organization.getOrganizationDescription();
if (organizationDescription == null) {
organizationDescription = new OrganizationDescription();
organization.setOrganizationDescription(organizationDescription);
}
organizationDescription.setDescription(organizationForm.description());
return organization;
}

}

package org.ifolks.demo.components.mapper.organizations.forms.base;

import org.ifolks.demo.api.model.organizations.enums.OrganizationRole;
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
(args[1] != null ? (OrganizationRole) (args[1] instanceof OrganizationRole ? args[1] : OrganizationRole.valueOf(args[1].toString())) : null),
(String)args[2]);
}

/**
 * mapping entity to form
 */
public OrganizationForm toForm(Organization organization) {
String code = organization.getCode();
OrganizationRole role = organization.getRole();
String description = organization.getOrganizationDescription().getDescription();

return new OrganizationForm (
code,
role,
description);
}

/**
 * mapping form to entity
 */
public Organization toEntity(OrganizationForm organizationForm, Organization organization) {
organization.setCode(organizationForm.code());
organization.setRole(organizationForm.role());
OrganizationDescription organizationDescription = organization.getOrganizationDescription();
if (organizationDescription == null) {
organizationDescription = new OrganizationDescription();
organization.setOrganizationDescription(organizationDescription);
}
organizationDescription.setDescription(organizationForm.description());
return organization;
}

}

package org.ifolks.demo.components.mapper.organizations.forms.base;

import org.ifolks.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.ifolks.demo.model.organizations.OrganizationCertification;
import org.springframework.stereotype.Component;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
@Component
public class OrganizationCertificationFormBaseMapper {


/*
 * properties
 */

/**
 * mapping object arry to form
 */
public OrganizationCertificationForm toForm(Object[] args) {

return new OrganizationCertificationForm (
(Boolean)args[0]);
}

/**
 * mapping entity to form
 */
public OrganizationCertificationForm toForm(OrganizationCertification organizationCertification) {
Boolean certified = organizationCertification.getCertified();

return new OrganizationCertificationForm (
certified);
}

/**
 * mapping form to entity
 */
public OrganizationCertification toEntity(OrganizationCertificationForm organizationCertificationForm, OrganizationCertification organizationCertification) {
organizationCertification.setCertified(organizationCertificationForm.certified());
return organizationCertification;
}

}

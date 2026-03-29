package org.ifolks.demo.components.mapper.organizations.forms.base;

import org.ifolks.commons.mapper.impl.BasicMapperImpl;
import org.ifolks.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.ifolks.demo.model.organizations.OrganizationCertification;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class OrganizationCertificationFormBaseMapper extends BasicMapperImpl<OrganizationCertificationForm, OrganizationCertification> {

public OrganizationCertificationFormBaseMapper() {
super(OrganizationCertificationForm.class, OrganizationCertification.class);
}

/*
 * properties
 */

/**
 * mapping form from object
 */
@Override
public OrganizationCertificationForm mapFrom(OrganizationCertificationForm organizationCertificationForm, OrganizationCertification organizationCertification) {
organizationCertificationForm = super.mapFrom(organizationCertificationForm, organizationCertification);
return organizationCertificationForm;
}

/**
 * mapping view to object
 */
@Override
public OrganizationCertification mapTo(OrganizationCertificationForm organizationCertificationForm, OrganizationCertification organizationCertification) {
organizationCertification = super.mapTo(organizationCertificationForm, organizationCertification);
return organizationCertification;
}

}

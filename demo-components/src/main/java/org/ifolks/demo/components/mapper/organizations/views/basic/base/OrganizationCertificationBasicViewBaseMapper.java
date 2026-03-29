package org.ifolks.demo.components.mapper.organizations.views.basic.base;

import org.ifolks.demo.api.model.organizations.views.basic.OrganizationCertificationBasicView;
import org.ifolks.demo.components.rightsmanager.organizations.OrganizationRightsManager;
import org.ifolks.demo.components.statemanager.organizations.OrganizationStateManager;
import org.ifolks.demo.model.organizations.OrganizationCertification;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base basic view mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class OrganizationCertificationBasicViewBaseMapper {
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
public OrganizationCertificationBasicView toView(OrganizationCertification organizationCertification) {
String id = organizationCertification.getId();
boolean selected = false;
boolean canDelete = organizationRightsManager.canDeleteOrganizationCertification(organizationCertification) && organizationStateManager.canDeleteOrganizationCertification(organizationCertification);
Boolean certified = organizationCertification.getCertified();

return new OrganizationCertificationBasicView (
id,
selected,
canDelete,
certified);
}

}

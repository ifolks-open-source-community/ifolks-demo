package org.ifolks.demo.components.processor.organizations.base;

import org.ifolks.demo.model.organizations.Organization;
import org.ifolks.demo.model.organizations.OrganizationCertification;
import org.ifolks.demo.persistence.interfaces.organizations.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class OrganizationBaseProcessor {

/*
 * properties injected by spring
 */
@Autowired
protected OrganizationRepository organizationRepository;

/**
 * process save
 */
public Integer save(Organization organization) {
return organizationRepository.saveAndFlush(organization).getId();
}

/**
 * process save one to one component OrganizationCertification
 */
public void saveOrganizationCertification(OrganizationCertification organizationCertification,Organization organization) {
organization.setOrganizationCertification(organizationCertification);
organizationCertification.setOrganization(organization);
this.organizationRepository.save(organization);
}

/**
 * process update
 */
public void update(Organization organization) {
// Empty by default. Can be overridden
}

/**
 * process update one to one component OrganizationCertification
 */
public void updateOrganizationCertification(OrganizationCertification organizationCertification) {
// Empty by default. Can be overridden
}

/**
 * process delete
 */
public void delete(Organization organization) {
organizationRepository.delete(organization);
}

/**
 * process delete one to one component OrganizationCertification
 */
public void deleteOrganizationCertification(OrganizationCertification organizationCertification) {
Organization organization = organizationCertification.getOrganization();
if (organization != null) {
    organization.setOrganizationCertification(null);
    organizationCertification.setOrganization(null);
    this.organizationRepository.save(organization);
}
}

}

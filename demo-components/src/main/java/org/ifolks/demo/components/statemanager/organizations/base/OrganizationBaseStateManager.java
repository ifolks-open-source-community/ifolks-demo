package org.ifolks.demo.components.statemanager.organizations.base;

import org.ifolks.commons.api.exception.state.InvalidStateException;
import org.ifolks.demo.model.organizations.Organization;
import org.ifolks.demo.model.organizations.OrganizationCertification;

/**
 * auto generated base state manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class OrganizationBaseStateManager {

/**
 * can save
 */
public boolean canSave(Organization organization) {
return true;
}

/**
 * check can save
 */
public void checkCanSave(Organization organization) {
if (!canSave(organization)) {
throw new InvalidStateException("Organization.save.invalidState");
}
}

/**
 * can save one to one component OrganizationCertification
 */
public boolean canSaveOrganizationCertification(OrganizationCertification organizationCertification,Organization organization) {
return true;
}

/**
 * check can save one to one component OrganizationCertification
 */
public void checkCanSaveOrganizationCertification(OrganizationCertification organizationCertification,Organization organization) {
if (!canSaveOrganizationCertification(organizationCertification, organization)) {
throw new InvalidStateException("OrganizationCertification.save.invalidState");
}
}

/**
 * can update
 */
public boolean canUpdate(Organization organization) {
return true;
}

/**
 * check can update
 */
public void checkCanUpdate(Organization organization) {
if (!canUpdate(organization)) {
throw new InvalidStateException("Organization.update.invalidState");
}
}

/**
 * can update one to one component OrganizationCertification
 */
public boolean canUpdateOrganizationCertification(OrganizationCertification organizationCertification) {
return true;
}

/**
 * check can update one to one component OrganizationCertification
 */
public void checkCanUpdateOrganizationCertification(OrganizationCertification organizationCertification) {
if (!canUpdateOrganizationCertification(organizationCertification)) {
throw new InvalidStateException("OrganizationCertification.update.invalidState");
}
}

/**
 * can delete
 */
public boolean canDelete(Organization organization) {
return true;
}

/**
 * check can delete
 */
public void checkCanDelete(Organization organization) {
if (!canDelete(organization)) {
throw new InvalidStateException("Organization.delete.invalidState");
}
}

/**
 * can delete one to one component OrganizationCertification
 */
public boolean canDeleteOrganizationCertification(OrganizationCertification organizationCertification) {
return true;
}

/**
 * check can delete one to one component OrganizationCertification
 */
public void checkCanDeleteOrganizationCertification(OrganizationCertification organizationCertification) {
if (!canDeleteOrganizationCertification(organizationCertification)) {
throw new InvalidStateException("OrganizationCertification.delete.invalidState");
}
}

}

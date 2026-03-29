package org.ifolks.demo.components.rightsmanager.organizations.base;

import org.ifolks.commons.api.exception.rights.AccessDeniedException;
import org.ifolks.demo.model.organizations.Organization;
import org.ifolks.demo.model.organizations.OrganizationCertification;

/**
 * auto generated base rights manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class OrganizationBaseRightsManager {

/**
 * can access all
 */
public boolean canAccess() {
return true;
}

/**
 * check can access all
 */
public void checkCanAccess() {
if (!canAccess()) {
throw new AccessDeniedException("Organization.accessDenied");
}
}

/**
 * can access
 */
public boolean canAccess(Organization organization) {
return true;
}

/**
 * check can access
 */
public void checkCanAccess(Organization organization) {
if (!canAccess(organization)) {
throw new AccessDeniedException("Organization.accessDenied");
}
}

/**
 * can access one to one component OrganizationCertification
 */
public boolean canAccessOrganizationCertification(Organization organization) {
return canAccess(organization);
}

/**
 * check can access one to one component OrganizationCertification
 */
public void checkCanAccessOrganizationCertification(Organization organization) {
if (!canAccessOrganizationCertification(organization)) {
throw new AccessDeniedException("OrganizationCertification.accessDenied");
}
}

/**
 * can create
 */
public boolean canCreate() {
return true;
}

/**
 * check can create
 */
public void checkCanCreate() {
if (!canCreate()) {
throw new AccessDeniedException("Organization.create.operationDenied");
}
}

/**
 * can create one to one component OrganizationCertification
 */
public boolean canCreateOrganizationCertification(Organization organization) {
return canUpdate(organization);
}

/**
 * check can create one to one component OrganizationCertification
 */
public void checkCanCreateOrganizationCertification(Organization organization) {
if (!canCreateOrganizationCertification(organization)) {
throw new AccessDeniedException("OrganizationCertification.create.operationDenied");
}
}

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
throw new AccessDeniedException("Organization.save.operationDenied");
}
}

/**
 * can save one to one component OrganizationCertification
 */
public boolean canSaveOrganizationCertification(OrganizationCertification organizationCertification,Organization organization) {
return canUpdate(organization);
}

/**
 * check can save one to one component OrganizationCertification
 */
public void checkCanSaveOrganizationCertification(OrganizationCertification organizationCertification,Organization organization) {
if (!canSaveOrganizationCertification(organizationCertification, organization)) {
throw new AccessDeniedException("OrganizationCertification.save.operationDenied");
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
throw new AccessDeniedException("Organization.update.operationDenied");
}
}

/**
 * can update one to one component OrganizationCertification
 */
public boolean canUpdateOrganizationCertification(OrganizationCertification organizationCertification) {
return canUpdate(organizationCertification.getOrganization());
}

/**
 * check can update one to one component OrganizationCertification
 */
public void checkCanUpdateOrganizationCertification(OrganizationCertification organizationCertification) {
if (!canUpdateOrganizationCertification(organizationCertification)) {
throw new AccessDeniedException("OrganizationCertification.update.operationDenied");
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
throw new AccessDeniedException("Organization.delete.operationDenied");
}
}

/**
 * can delete one to one component OrganizationCertification
 */
public boolean canDeleteOrganizationCertification(OrganizationCertification organizationCertification) {
return canUpdate(organizationCertification.getOrganization());
}

/**
 * check can delete one to one component OrganizationCertification
 */
public void checkCanDeleteOrganizationCertification(OrganizationCertification organizationCertification) {
if (!canDeleteOrganizationCertification(organizationCertification)) {
throw new AccessDeniedException("OrganizationCertification.delete.operationDenied");
}
}

}

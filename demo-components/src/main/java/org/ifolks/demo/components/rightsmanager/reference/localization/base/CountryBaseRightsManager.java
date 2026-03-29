package org.ifolks.demo.components.rightsmanager.reference.localization.base;

import org.ifolks.commons.api.exception.rights.AccessDeniedException;
import org.ifolks.demo.model.reference.localization.Country;

/**
 * auto generated base rights manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CountryBaseRightsManager {

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
throw new AccessDeniedException("Country.accessDenied");
}
}

/**
 * can access
 */
public boolean canAccess(Country country) {
return true;
}

/**
 * check can access
 */
public void checkCanAccess(Country country) {
if (!canAccess(country)) {
throw new AccessDeniedException("Country.accessDenied");
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
throw new AccessDeniedException("Country.create.operationDenied");
}
}

/**
 * can save
 */
public boolean canSave(Country country) {
return true;
}

/**
 * check can save
 */
public void checkCanSave(Country country) {
if (!canSave(country)) {
throw new AccessDeniedException("Country.save.operationDenied");
}
}

/**
 * can update
 */
public boolean canUpdate(Country country) {
return true;
}

/**
 * check can update
 */
public void checkCanUpdate(Country country) {
if (!canUpdate(country)) {
throw new AccessDeniedException("Country.update.operationDenied");
}
}

/**
 * can delete
 */
public boolean canDelete(Country country) {
return true;
}

/**
 * check can delete
 */
public void checkCanDelete(Country country) {
if (!canDelete(country)) {
throw new AccessDeniedException("Country.delete.operationDenied");
}
}

}

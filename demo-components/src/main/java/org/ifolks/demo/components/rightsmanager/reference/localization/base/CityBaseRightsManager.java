package org.ifolks.demo.components.rightsmanager.reference.localization.base;

import org.ifolks.commons.api.exception.rights.AccessDeniedException;
import org.ifolks.demo.model.reference.localization.City;

/**
 * auto generated base rights manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CityBaseRightsManager {

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
throw new AccessDeniedException("City.accessDenied");
}
}

/**
 * can access
 */
public boolean canAccess(City city) {
return true;
}

/**
 * check can access
 */
public void checkCanAccess(City city) {
if (!canAccess(city)) {
throw new AccessDeniedException("City.accessDenied");
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
throw new AccessDeniedException("City.create.operationDenied");
}
}

/**
 * can save
 */
public boolean canSave(City city) {
return true;
}

/**
 * check can save
 */
public void checkCanSave(City city) {
if (!canSave(city)) {
throw new AccessDeniedException("City.save.operationDenied");
}
}

/**
 * can update
 */
public boolean canUpdate(City city) {
return true;
}

/**
 * check can update
 */
public void checkCanUpdate(City city) {
if (!canUpdate(city)) {
throw new AccessDeniedException("City.update.operationDenied");
}
}

/**
 * can delete
 */
public boolean canDelete(City city) {
return true;
}

/**
 * check can delete
 */
public void checkCanDelete(City city) {
if (!canDelete(city)) {
throw new AccessDeniedException("City.delete.operationDenied");
}
}

}

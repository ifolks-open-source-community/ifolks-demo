package org.ifolks.demo.components.rightsmanager.reference.localization.base;

import org.ifolks.commons.api.exception.rights.AccessDeniedException;
import org.ifolks.demo.model.reference.localization.Region;

/**
 * auto generated base rights manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class RegionBaseRightsManager {

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
throw new AccessDeniedException("Region.accessDenied");
}
}

/**
 * can access
 */
public boolean canAccess(Region region) {
return true;
}

/**
 * check can access
 */
public void checkCanAccess(Region region) {
if (!canAccess(region)) {
throw new AccessDeniedException("Region.accessDenied");
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
throw new AccessDeniedException("Region.create.operationDenied");
}
}

/**
 * can save
 */
public boolean canSave(Region region) {
return true;
}

/**
 * check can save
 */
public void checkCanSave(Region region) {
if (!canSave(region)) {
throw new AccessDeniedException("Region.save.operationDenied");
}
}

/**
 * can update
 */
public boolean canUpdate(Region region) {
return true;
}

/**
 * check can update
 */
public void checkCanUpdate(Region region) {
if (!canUpdate(region)) {
throw new AccessDeniedException("Region.update.operationDenied");
}
}

/**
 * can delete
 */
public boolean canDelete(Region region) {
return true;
}

/**
 * check can delete
 */
public void checkCanDelete(Region region) {
if (!canDelete(region)) {
throw new AccessDeniedException("Region.delete.operationDenied");
}
}

}

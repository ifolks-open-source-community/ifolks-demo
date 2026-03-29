package org.ifolks.demo.components.rightsmanager.dummy.base;

import org.ifolks.commons.api.exception.rights.AccessDeniedException;
import org.ifolks.demo.model.dummy.Stupid;

/**
 * auto generated base rights manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class StupidBaseRightsManager {

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
throw new AccessDeniedException("Stupid.accessDenied");
}
}

/**
 * can access
 */
public boolean canAccess(Stupid stupid) {
return true;
}

/**
 * check can access
 */
public void checkCanAccess(Stupid stupid) {
if (!canAccess(stupid)) {
throw new AccessDeniedException("Stupid.accessDenied");
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
throw new AccessDeniedException("Stupid.create.operationDenied");
}
}

/**
 * can save
 */
public boolean canSave(Stupid stupid) {
return true;
}

/**
 * check can save
 */
public void checkCanSave(Stupid stupid) {
if (!canSave(stupid)) {
throw new AccessDeniedException("Stupid.save.operationDenied");
}
}

/**
 * can update
 */
public boolean canUpdate(Stupid stupid) {
return true;
}

/**
 * check can update
 */
public void checkCanUpdate(Stupid stupid) {
if (!canUpdate(stupid)) {
throw new AccessDeniedException("Stupid.update.operationDenied");
}
}

/**
 * can delete
 */
public boolean canDelete(Stupid stupid) {
return true;
}

/**
 * check can delete
 */
public void checkCanDelete(Stupid stupid) {
if (!canDelete(stupid)) {
throw new AccessDeniedException("Stupid.delete.operationDenied");
}
}

}

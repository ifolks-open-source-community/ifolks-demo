package org.ifolks.demo.components.statemanager.dummy.base;

import org.ifolks.commons.api.exception.state.InvalidStateException;
import org.ifolks.demo.model.dummy.Stupid;

/**
 * auto generated base state manager class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class StupidBaseStateManager {

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
throw new InvalidStateException("Stupid.save.invalidState");
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
throw new InvalidStateException("Stupid.update.invalidState");
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
throw new InvalidStateException("Stupid.delete.invalidState");
}
}

}

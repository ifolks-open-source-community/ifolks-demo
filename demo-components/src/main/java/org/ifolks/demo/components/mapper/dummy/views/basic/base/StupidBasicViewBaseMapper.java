package org.ifolks.demo.components.mapper.dummy.views.basic.base;

import org.ifolks.demo.api.model.dummy.views.basic.StupidBasicView;
import org.ifolks.demo.components.rightsmanager.dummy.StupidRightsManager;
import org.ifolks.demo.components.statemanager.dummy.StupidStateManager;
import org.ifolks.demo.model.dummy.Stupid;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base basic view mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class StupidBasicViewBaseMapper {
/*
 * injections
 */
@Autowired
protected StupidRightsManager stupidRightsManager;
@Autowired
protected StupidStateManager stupidStateManager;

/**
 * mapping entity to view
 */
public StupidBasicView toView(Stupid stupid) {
Long id = stupid.getId();
boolean selected = false;
boolean canDelete = stupidRightsManager.canDelete(stupid) && stupidStateManager.canDelete(stupid);
String code = stupid.getCode();
String foolCode = stupid.getFool().getCode();

return new StupidBasicView (
id,
selected,
canDelete,
code,
foolCode);
}

}

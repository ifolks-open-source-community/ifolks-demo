package org.ifolks.demo.components.mapper.dummy.views.full.base;

import org.ifolks.demo.api.model.dummy.forms.StupidForm;
import org.ifolks.demo.api.model.dummy.views.full.StupidFullView;
import org.ifolks.demo.components.mapper.dummy.forms.StupidFormMapper;
import org.ifolks.demo.components.rightsmanager.dummy.StupidRightsManager;
import org.ifolks.demo.components.statemanager.dummy.StupidStateManager;
import org.ifolks.demo.model.dummy.Stupid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component
public class StupidFullViewBaseMapper {

@Autowired
protected StupidRightsManager stupidRightsManager;
@Autowired
protected StupidStateManager stupidStateManager;

@Autowired
protected StupidFormMapper formMapper;

/**
 * mapping entity to view
 */
public StupidFullView toView(Stupid stupid) {
Long id = stupid.getId();
StupidForm form = formMapper.toForm(stupid);
boolean canUpdate = stupidRightsManager.canUpdate(stupid) && stupidStateManager.canUpdate(stupid);
boolean canDelete = stupidRightsManager.canDelete(stupid) && stupidStateManager.canDelete(stupid);
return new StupidFullView(id, canUpdate, canDelete, form);
}

}

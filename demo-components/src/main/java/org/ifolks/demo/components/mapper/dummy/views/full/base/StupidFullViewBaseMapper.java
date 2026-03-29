package org.ifolks.demo.components.mapper.dummy.views.full.base;

import org.ifolks.commons.mapper.impl.FullViewMapper;
import org.ifolks.demo.api.model.dummy.forms.StupidForm;
import org.ifolks.demo.api.model.dummy.views.full.StupidFullView;
import org.ifolks.demo.components.rightsmanager.dummy.StupidRightsManager;
import org.ifolks.demo.components.statemanager.dummy.StupidStateManager;
import org.ifolks.demo.model.dummy.Stupid;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

public class StupidFullViewBaseMapper extends FullViewMapper<StupidFullView, Long, StupidForm, Stupid> {

@Autowired
protected StupidRightsManager stupidRightsManager;
@Autowired
protected StupidStateManager stupidStateManager;

public StupidFullViewBaseMapper() {
super(StupidFullView.class, Stupid.class);
}

@Override
public StupidFullView mapFrom(StupidFullView stupidFullView, Stupid stupid) {
stupidFullView = super.mapFrom(stupidFullView, stupid);
stupidFullView.setCanUpdate(stupidRightsManager.canUpdate(stupid) && stupidStateManager.canUpdate(stupid));
stupidFullView.setCanDelete(stupidRightsManager.canDelete(stupid) && stupidStateManager.canDelete(stupid));
return stupidFullView;
}

}

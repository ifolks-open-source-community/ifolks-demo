package org.ifolks.demo.components.mapper.reference.localization.views.full.base;

import org.ifolks.commons.mapper.impl.FullViewMapper;
import org.ifolks.demo.api.model.reference.localization.forms.RegionForm;
import org.ifolks.demo.api.model.reference.localization.views.full.RegionFullView;
import org.ifolks.demo.components.rightsmanager.reference.localization.RegionRightsManager;
import org.ifolks.demo.components.statemanager.reference.localization.RegionStateManager;
import org.ifolks.demo.model.reference.localization.Region;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

public class RegionFullViewBaseMapper extends FullViewMapper<RegionFullView, Integer, RegionForm, Region> {

@Autowired
protected RegionRightsManager regionRightsManager;
@Autowired
protected RegionStateManager regionStateManager;

public RegionFullViewBaseMapper() {
super(RegionFullView.class, Region.class);
}

@Override
public RegionFullView mapFrom(RegionFullView regionFullView, Region region) {
regionFullView = super.mapFrom(regionFullView, region);
regionFullView.setCanUpdate(regionRightsManager.canUpdate(region) && regionStateManager.canUpdate(region));
regionFullView.setCanDelete(regionRightsManager.canDelete(region) && regionStateManager.canDelete(region));
return regionFullView;
}

}

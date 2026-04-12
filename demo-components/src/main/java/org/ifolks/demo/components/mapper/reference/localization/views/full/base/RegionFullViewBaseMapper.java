package org.ifolks.demo.components.mapper.reference.localization.views.full.base;

import org.ifolks.demo.api.model.reference.localization.forms.RegionForm;
import org.ifolks.demo.api.model.reference.localization.views.full.RegionFullView;
import org.ifolks.demo.components.mapper.reference.localization.forms.RegionFormMapper;
import org.ifolks.demo.components.rightsmanager.reference.localization.RegionRightsManager;
import org.ifolks.demo.components.statemanager.reference.localization.RegionStateManager;
import org.ifolks.demo.model.reference.localization.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component
public class RegionFullViewBaseMapper {

@Autowired
protected RegionRightsManager regionRightsManager;
@Autowired
protected RegionStateManager regionStateManager;

@Autowired
protected RegionFormMapper formMapper;

/**
 * mapping entity to view
 */
public RegionFullView toView(Region region) {
Integer id = region.getId();
RegionForm form = formMapper.toForm(region);
boolean canUpdate = regionRightsManager.canUpdate(region) && regionStateManager.canUpdate(region);
boolean canDelete = regionRightsManager.canDelete(region) && regionStateManager.canDelete(region);
return new RegionFullView(id, canUpdate, canDelete, form);
}

}

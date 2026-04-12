package org.ifolks.demo.components.mapper.reference.localization.views.basic.base;

import org.ifolks.demo.api.model.reference.localization.views.basic.RegionBasicView;
import org.ifolks.demo.components.rightsmanager.reference.localization.RegionRightsManager;
import org.ifolks.demo.components.statemanager.reference.localization.RegionStateManager;
import org.ifolks.demo.model.reference.localization.Region;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base basic view mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class RegionBasicViewBaseMapper {
/*
 * injections
 */
@Autowired
protected RegionRightsManager regionRightsManager;
@Autowired
protected RegionStateManager regionStateManager;

/**
 * mapping entity to view
 */
public RegionBasicView toView(Region region) {
Integer id = region.getId();
boolean selected = false;
boolean canDelete = regionRightsManager.canDelete(region) && regionStateManager.canDelete(region);
String countryCode = region.getCountry().getCode();
String code = region.getCode();
String label = region.getLabel();

return new RegionBasicView (
id,
selected,
canDelete,
countryCode,
code,
label);
}

}

package org.ifolks.demo.components.mapper.reference.localization.views.basic.base;

import org.springframework.beans.factory.annotation.Autowired;

import org.ifolks.demo.api.model.reference.localization.views.basic.CityBasicView;
import org.ifolks.demo.components.rightsmanager.reference.localization.CityRightsManager;
import org.ifolks.demo.components.statemanager.reference.localization.CityStateManager;
import org.ifolks.demo.model.reference.localization.City;

/**
 * auto generated base basic view mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CityBasicViewBaseMapper {
/*
 * injections
 */
@Autowired
protected CityRightsManager cityRightsManager;
@Autowired
protected CityStateManager cityStateManager;

/**
 * mapping entity to view
 */
public CityBasicView toView(City city) {

Long id = city.getId();
boolean selected = false;
boolean canDelete = cityRightsManager.canDelete(city) && cityStateManager.canDelete(city);
String regionCountryCode = (city.getRegion() != null && city.getRegion().getCountry() != null) ? city.getRegion().getCountry().getCode() : null;
String regionCode = city.getRegion() != null ? city.getRegion().getCode() : null;
String code = city.getCode();
String label = city.getLabel();

return new CityBasicView (
id,
selected,
canDelete,
regionCountryCode,
regionCode,
code,
label);
}

}

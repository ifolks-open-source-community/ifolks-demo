package org.ifolks.demo.components.mapper.reference.localization.views.basic.base;

import org.ifolks.demo.api.model.reference.localization.views.basic.CountryBasicView;
import org.ifolks.demo.components.rightsmanager.reference.localization.CountryRightsManager;
import org.ifolks.demo.components.statemanager.reference.localization.CountryStateManager;
import org.ifolks.demo.model.reference.localization.Country;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base basic view mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CountryBasicViewBaseMapper {
/*
 * injections
 */
@Autowired
protected CountryRightsManager countryRightsManager;
@Autowired
protected CountryStateManager countryStateManager;

/**
 * mapping entity to view
 */
public CountryBasicView toView(Country country) {
Short id = country.getId();
boolean selected = false;
boolean canDelete = countryRightsManager.canDelete(country) && countryStateManager.canDelete(country);
String code = country.getCode();
String label = country.getLabel();

return new CountryBasicView (
id,
selected,
canDelete,
code,
label);
}

}

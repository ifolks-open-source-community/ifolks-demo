package org.ifolks.demo.components.mapper.reference.localization.views.full.base;

import org.ifolks.commons.mapper.impl.FullViewMapper;
import org.ifolks.demo.api.model.reference.localization.forms.CountryForm;
import org.ifolks.demo.api.model.reference.localization.views.full.CountryFullView;
import org.ifolks.demo.components.rightsmanager.reference.localization.CountryRightsManager;
import org.ifolks.demo.components.statemanager.reference.localization.CountryStateManager;
import org.ifolks.demo.model.reference.localization.Country;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

public class CountryFullViewBaseMapper extends FullViewMapper<CountryFullView, Short, CountryForm, Country> {

@Autowired
protected CountryRightsManager countryRightsManager;
@Autowired
protected CountryStateManager countryStateManager;

public CountryFullViewBaseMapper() {
super(CountryFullView.class, Country.class);
}

@Override
public CountryFullView mapFrom(CountryFullView countryFullView, Country country) {
countryFullView = super.mapFrom(countryFullView, country);
countryFullView.setCanUpdate(countryRightsManager.canUpdate(country) && countryStateManager.canUpdate(country));
countryFullView.setCanDelete(countryRightsManager.canDelete(country) && countryStateManager.canDelete(country));
return countryFullView;
}

}

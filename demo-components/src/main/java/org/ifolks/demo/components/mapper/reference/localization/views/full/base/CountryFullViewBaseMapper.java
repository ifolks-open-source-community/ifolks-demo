package org.ifolks.demo.components.mapper.reference.localization.views.full.base;

import org.ifolks.demo.api.model.reference.localization.forms.CountryForm;
import org.ifolks.demo.api.model.reference.localization.views.full.CountryFullView;
import org.ifolks.demo.components.mapper.reference.localization.forms.CountryFormMapper;
import org.ifolks.demo.components.rightsmanager.reference.localization.CountryRightsManager;
import org.ifolks.demo.components.statemanager.reference.localization.CountryStateManager;
import org.ifolks.demo.model.reference.localization.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component
public class CountryFullViewBaseMapper {

@Autowired
protected CountryRightsManager countryRightsManager;
@Autowired
protected CountryStateManager countryStateManager;

@Autowired
protected CountryFormMapper formMapper;

/**
 * mapping entity to view
 */
public CountryFullView toView(Country country) {
Short id = country.getId();
CountryForm form = formMapper.toForm(country);
boolean canUpdate = countryRightsManager.canUpdate(country) && countryStateManager.canUpdate(country);
boolean canDelete = countryRightsManager.canDelete(country) && countryStateManager.canDelete(country);
return new CountryFullView(id, canUpdate, canDelete, form);
}

}

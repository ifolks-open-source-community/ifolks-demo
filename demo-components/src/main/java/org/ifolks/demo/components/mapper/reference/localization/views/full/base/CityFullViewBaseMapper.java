package org.ifolks.demo.components.mapper.reference.localization.views.full.base;

import org.ifolks.demo.api.model.reference.localization.forms.CityForm;
import org.ifolks.demo.api.model.reference.localization.views.full.CityFullView;
import org.ifolks.demo.components.mapper.reference.localization.forms.CityFormMapper;
import org.ifolks.demo.components.rightsmanager.reference.localization.CityRightsManager;
import org.ifolks.demo.components.statemanager.reference.localization.CityStateManager;
import org.ifolks.demo.model.reference.localization.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component
public class CityFullViewBaseMapper {

@Autowired
protected CityRightsManager cityRightsManager;
@Autowired
protected CityStateManager cityStateManager;

@Autowired
protected CityFormMapper formMapper;

/**
 * mapping entity to view
 */
public CityFullView toView(City city) {
Long id = city.getId();
CityForm form = formMapper.toForm(city);
boolean canUpdate = cityRightsManager.canUpdate(city) && cityStateManager.canUpdate(city);
boolean canDelete = cityRightsManager.canDelete(city) && cityStateManager.canDelete(city);
return new CityFullView(id, canUpdate, canDelete, form);
}

}

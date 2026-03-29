package org.ifolks.demo.components.mapper.reference.localization.views.full.base;

import org.ifolks.commons.mapper.impl.FullViewMapper;
import org.ifolks.demo.api.model.reference.localization.forms.CityForm;
import org.ifolks.demo.api.model.reference.localization.views.full.CityFullView;
import org.ifolks.demo.components.rightsmanager.reference.localization.CityRightsManager;
import org.ifolks.demo.components.statemanager.reference.localization.CityStateManager;
import org.ifolks.demo.model.reference.localization.City;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

public class CityFullViewBaseMapper extends FullViewMapper<CityFullView, Long, CityForm, City> {

@Autowired
protected CityRightsManager cityRightsManager;
@Autowired
protected CityStateManager cityStateManager;

public CityFullViewBaseMapper() {
super(CityFullView.class, City.class);
}

@Override
public CityFullView mapFrom(CityFullView cityFullView, City city) {
cityFullView = super.mapFrom(cityFullView, city);
cityFullView.setCanUpdate(cityRightsManager.canUpdate(city) && cityStateManager.canUpdate(city));
cityFullView.setCanDelete(cityRightsManager.canDelete(city) && cityStateManager.canDelete(city));
return cityFullView;
}

}

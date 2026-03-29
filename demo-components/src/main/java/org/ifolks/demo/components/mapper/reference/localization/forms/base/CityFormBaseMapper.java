package org.ifolks.demo.components.mapper.reference.localization.forms.base;

import org.ifolks.commons.mapper.impl.BasicMapperImpl;
import org.ifolks.demo.api.model.reference.localization.forms.CityForm;
import org.ifolks.demo.model.reference.localization.City;
import org.ifolks.demo.persistence.interfaces.reference.localization.RegionDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CityFormBaseMapper extends BasicMapperImpl<CityForm, City> {

public CityFormBaseMapper() {
super(CityForm.class, City.class);
}

/*
 * properties
 */
@Autowired
protected RegionDao regionDao;

/**
 * mapping form from object
 */
@Override
public CityForm mapFrom(CityForm cityForm, City city) {
cityForm = super.mapFrom(cityForm, city);
cityForm.setRegionCountryCode(city.getRegion().getCountry().getCode());
cityForm.setRegionCode(city.getRegion().getCode());
return cityForm;
}

/**
 * mapping view to object
 */
@Override
public City mapTo(CityForm cityForm, City city) {
city = super.mapTo(cityForm, city);
city.setRegion(regionDao.find(cityForm.getRegionCountryCode(), cityForm.getRegionCode()));
return city;
}

}

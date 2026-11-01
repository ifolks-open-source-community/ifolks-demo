package org.ifolks.demo.components.mapper.reference.localization.forms.base;

import org.ifolks.commons.api.exception.repository.ObjectNotFoundException;
import org.ifolks.demo.api.model.reference.localization.forms.CityForm;
import org.ifolks.demo.model.reference.localization.City;
import org.ifolks.demo.persistence.interfaces.reference.localization.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
@Component
public class CityFormBaseMapper {


/*
 * properties
 */
@Autowired
protected RegionRepository regionRepository;

/**
 * mapping object arry to form
 */
public CityForm toForm(Object[] args) {

return new CityForm (
(String)args[0],
(String)args[1],
(String)args[2],
(String)args[3]);
}

/**
 * mapping entity to form
 */
public CityForm toForm(City city) {
String regionCountryCode = city.getRegion().getCountry().getCode();
String regionCode = city.getRegion().getCode();
String code = city.getCode();
String label = city.getLabel();

return new CityForm (
regionCountryCode,
regionCode,
code,
label);
}

/**
 * mapping form to entity
 */
public City toEntity(CityForm cityForm, City city) {
city.setRegion(regionRepository.find(cityForm.regionCountryCode(), cityForm.regionCode()).orElseThrow(() -> new ObjectNotFoundException("Region.notFound")));
city.setCode(cityForm.code());
city.setLabel(cityForm.label());
return city;
}

}

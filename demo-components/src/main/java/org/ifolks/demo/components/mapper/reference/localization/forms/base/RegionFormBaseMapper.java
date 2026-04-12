package org.ifolks.demo.components.mapper.reference.localization.forms.base;

import org.ifolks.demo.api.model.reference.localization.forms.RegionForm;
import org.ifolks.demo.model.reference.localization.Region;
import org.ifolks.demo.persistence.interfaces.reference.localization.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
@Component
public class RegionFormBaseMapper {


/*
 * properties
 */
@Autowired
protected CountryDao countryDao;

/**
 * mapping object arry to form
 */
public RegionForm toForm(Object[] args) {

return new RegionForm (
(String)args[0],
(String)args[1],
(String)args[2]);
}

/**
 * mapping entity to form
 */
public RegionForm toForm(Region region) {
String countryCode = region.getCountry().getCode();
String code = region.getCode();
String label = region.getLabel();

return new RegionForm (
countryCode,
code,
label);
}

/**
 * mapping form to entity
 */
public Region toEntity(RegionForm regionForm, Region region) {
region.setCountry(countryDao.find(regionForm.countryCode()));
region.setCode(regionForm.code());
region.setLabel(regionForm.label());
return region;
}

}

package org.ifolks.demo.components.mapper.reference.localization.forms.base;

import org.ifolks.commons.mapper.impl.BasicMapperImpl;
import org.ifolks.demo.api.model.reference.localization.forms.RegionForm;
import org.ifolks.demo.model.reference.localization.Region;
import org.ifolks.demo.persistence.interfaces.reference.localization.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class RegionFormBaseMapper extends BasicMapperImpl<RegionForm, Region> {

public RegionFormBaseMapper() {
super(RegionForm.class, Region.class);
}

/*
 * properties
 */
@Autowired
protected CountryDao countryDao;

/**
 * mapping form from object
 */
@Override
public RegionForm mapFrom(RegionForm regionForm, Region region) {
regionForm = super.mapFrom(regionForm, region);
regionForm.setCountryCode(region.getCountry().getCode());
return regionForm;
}

/**
 * mapping view to object
 */
@Override
public Region mapTo(RegionForm regionForm, Region region) {
region = super.mapTo(regionForm, region);
region.setCountry(countryDao.find(regionForm.getCountryCode()));
return region;
}

}

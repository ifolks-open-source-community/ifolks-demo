package org.ifolks.demo.components.mapper.reference.localization.forms.base;

import org.ifolks.commons.mapper.impl.BasicMapperImpl;
import org.ifolks.demo.api.model.reference.localization.forms.CountryForm;
import org.ifolks.demo.model.reference.localization.Country;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CountryFormBaseMapper extends BasicMapperImpl<CountryForm, Country> {

public CountryFormBaseMapper() {
super(CountryForm.class, Country.class);
}

/*
 * properties
 */

/**
 * mapping form from object
 */
@Override
public CountryForm mapFrom(CountryForm countryForm, Country country) {
countryForm = super.mapFrom(countryForm, country);
return countryForm;
}

/**
 * mapping view to object
 */
@Override
public Country mapTo(CountryForm countryForm, Country country) {
country = super.mapTo(countryForm, country);
return country;
}

}

package org.ifolks.demo.components.mapper.reference.localization.forms.base;

import org.ifolks.demo.api.model.reference.localization.forms.CountryForm;
import org.ifolks.demo.model.reference.localization.Country;
import org.springframework.stereotype.Component;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
@Component
public class CountryFormBaseMapper {


/*
 * properties
 */

/**
 * mapping object arry to form
 */
public CountryForm toForm(Object[] args) {

return new CountryForm (
(String)args[0],
(String)args[1]);
}

/**
 * mapping entity to form
 */
public CountryForm toForm(Country country) {
String code = country.getCode();
String label = country.getLabel();

return new CountryForm (
code,
label);
}

/**
 * mapping form to entity
 */
public Country toEntity(CountryForm countryForm, Country country) {
country.setCode(countryForm.code());
country.setLabel(countryForm.label());
return country;
}

}

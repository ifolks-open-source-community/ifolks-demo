package org.ifolks.demo.components.mapper.dummy.forms.base;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import org.ifolks.demo.api.model.dummy.forms.FoolForm;
import org.ifolks.demo.model.dummy.Fool;
import org.springframework.stereotype.Component;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
@Component
public class FoolFormBaseMapper {


/*
 * properties
 */

/**
 * mapping object arry to form
 */
public FoolForm toForm(Object[] args) {

return new FoolForm (
(String)args[0],
(String)args[1],
(Long)args[2],
(Boolean)args[3],
(Double)args[4],
(BigDecimal)args[5],
(LocalDate)args[6],
(OffsetDateTime)args[7]);
}

/**
 * mapping entity to form
 */
public FoolForm toForm(Fool fool) {
String code = fool.getCode();
String description = fool.getDescription();
Long longField = fool.getLongField();
Boolean booleanField = fool.getBooleanField();
Double doubleField = fool.getDoubleField();
BigDecimal decimalField = fool.getDecimalField();
LocalDate dateField = fool.getDateField();
OffsetDateTime datetimeField = fool.getDatetimeField();

return new FoolForm (
code,
description,
longField,
booleanField,
doubleField,
decimalField,
dateField,
datetimeField);
}

/**
 * mapping form to entity
 */
public Fool toEntity(FoolForm foolForm, Fool fool) {
fool.setCode(foolForm.code());
fool.setDescription(foolForm.description());
fool.setLongField(foolForm.longField());
fool.setBooleanField(foolForm.booleanField());
fool.setDoubleField(foolForm.doubleField());
fool.setDecimalField(foolForm.decimalField());
fool.setDateField(foolForm.dateField());
fool.setDatetimeField(foolForm.datetimeField());
return fool;
}

}

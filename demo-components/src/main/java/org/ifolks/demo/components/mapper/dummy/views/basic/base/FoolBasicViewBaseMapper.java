package org.ifolks.demo.components.mapper.dummy.views.basic.base;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import org.ifolks.demo.api.model.dummy.views.basic.FoolBasicView;
import org.ifolks.demo.components.rightsmanager.dummy.FoolRightsManager;
import org.ifolks.demo.components.statemanager.dummy.FoolStateManager;
import org.ifolks.demo.model.dummy.Fool;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base basic view mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class FoolBasicViewBaseMapper {
/*
 * injections
 */
@Autowired
protected FoolRightsManager foolRightsManager;
@Autowired
protected FoolStateManager foolStateManager;

/**
 * mapping entity to view
 */
public FoolBasicView toView(Fool fool) {
String id = fool.getId();
boolean selected = false;
boolean canDelete = foolRightsManager.canDelete(fool) && foolStateManager.canDelete(fool);
String code = fool.getCode();
String description = fool.getDescription();
Long longField = fool.getLongField();
Boolean booleanField = fool.getBooleanField();
Double doubleField = fool.getDoubleField();
BigDecimal decimalField = fool.getDecimalField();
LocalDate dateField = fool.getDateField();
Date datetimeField = fool.getDatetimeField();

return new FoolBasicView (
id,
selected,
canDelete,
code,
description,
longField,
booleanField,
doubleField,
decimalField,
dateField,
datetimeField);
}

}

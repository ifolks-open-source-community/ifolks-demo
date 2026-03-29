package org.ifolks.demo.components.mapper.dummy.forms.base;

import org.ifolks.commons.mapper.impl.BasicMapperImpl;
import org.ifolks.demo.api.model.dummy.forms.FoolForm;
import org.ifolks.demo.model.dummy.Fool;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class FoolFormBaseMapper extends BasicMapperImpl<FoolForm, Fool> {

public FoolFormBaseMapper() {
super(FoolForm.class, Fool.class);
}

/*
 * properties
 */

/**
 * mapping form from object
 */
@Override
public FoolForm mapFrom(FoolForm foolForm, Fool fool) {
foolForm = super.mapFrom(foolForm, fool);
return foolForm;
}

/**
 * mapping view to object
 */
@Override
public Fool mapTo(FoolForm foolForm, Fool fool) {
fool = super.mapTo(foolForm, fool);
return fool;
}

}

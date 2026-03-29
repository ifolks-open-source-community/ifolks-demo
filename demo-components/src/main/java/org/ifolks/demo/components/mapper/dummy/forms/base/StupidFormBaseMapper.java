package org.ifolks.demo.components.mapper.dummy.forms.base;

import org.ifolks.commons.mapper.impl.BasicMapperImpl;
import org.ifolks.demo.api.model.dummy.forms.StupidForm;
import org.ifolks.demo.model.dummy.Stupid;
import org.ifolks.demo.persistence.interfaces.dummy.FoolDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class StupidFormBaseMapper extends BasicMapperImpl<StupidForm, Stupid> {

public StupidFormBaseMapper() {
super(StupidForm.class, Stupid.class);
}

/*
 * properties
 */
@Autowired
protected FoolDao foolDao;

/**
 * mapping form from object
 */
@Override
public StupidForm mapFrom(StupidForm stupidForm, Stupid stupid) {
stupidForm = super.mapFrom(stupidForm, stupid);
stupidForm.setFoolCode(stupid.getFool().getCode());
return stupidForm;
}

/**
 * mapping view to object
 */
@Override
public Stupid mapTo(StupidForm stupidForm, Stupid stupid) {
stupid = super.mapTo(stupidForm, stupid);
stupid.setFool(foolDao.find(stupidForm.getFoolCode()));
return stupid;
}

}

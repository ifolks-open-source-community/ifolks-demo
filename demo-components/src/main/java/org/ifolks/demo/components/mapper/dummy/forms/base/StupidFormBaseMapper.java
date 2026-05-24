package org.ifolks.demo.components.mapper.dummy.forms.base;

import org.ifolks.commons.api.exception.repository.ObjectNotFoundException;
import org.ifolks.demo.api.model.dummy.forms.StupidForm;
import org.ifolks.demo.model.dummy.Stupid;
import org.ifolks.demo.persistence.interfaces.dummy.FoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated base mapper class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
@Component
public class StupidFormBaseMapper {


/*
 * properties
 */
@Autowired
protected FoolRepository foolRepository;

/**
 * mapping object arry to form
 */
public StupidForm toForm(Object[] args) {

return new StupidForm (
(String)args[0],
(String)args[1]);
}

/**
 * mapping entity to form
 */
public StupidForm toForm(Stupid stupid) {
String code = stupid.getCode();
String foolCode = stupid.getFool().getCode();

return new StupidForm (
code,
foolCode);
}

/**
 * mapping form to entity
 */
public Stupid toEntity(StupidForm stupidForm, Stupid stupid) {
stupid.setCode(stupidForm.code());
stupid.setFool(foolRepository.find(stupidForm.foolCode()).orElseThrow(() -> new ObjectNotFoundException("Fool.notFound")));
return stupid;
}

}

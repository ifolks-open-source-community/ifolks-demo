package org.ifolks.demo.components.processor.dummy.base;

import org.ifolks.demo.model.dummy.Fool;
import org.ifolks.demo.persistence.interfaces.dummy.FoolRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class FoolBaseProcessor {

/*
 * properties injected by spring
 */
@Autowired
protected FoolRepository foolRepository;

/**
 * process save
 */
public String save(Fool fool) {
return foolRepository.saveAndFlush(fool).getId();
}

/**
 * process update
 */
public void update(Fool fool) {
// Empty by default. Can be overridden
}

/**
 * process delete
 */
public void delete(Fool fool) {
foolRepository.delete(fool);
}

}

package org.ifolks.demo.components.processor.dummy.base;

import org.ifolks.demo.model.dummy.Stupid;
import org.ifolks.demo.persistence.interfaces.dummy.StupidDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class StupidBaseProcessor {

/*
 * properties injected by spring
 */
@Autowired
protected StupidDao stupidDao;

/**
 * process save
 */
public Long save(Stupid stupid) {
return stupidDao.save(stupid);
}

/**
 * process update
 */
public void update(Stupid stupid) {
// Empty by default. Can be overridden
}

/**
 * process delete
 */
public void delete(Stupid stupid) {
stupidDao.delete(stupid);
}

}

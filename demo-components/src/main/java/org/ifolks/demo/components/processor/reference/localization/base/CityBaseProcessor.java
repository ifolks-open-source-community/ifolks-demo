package org.ifolks.demo.components.processor.reference.localization.base;

import org.ifolks.demo.model.reference.localization.City;
import org.ifolks.demo.persistence.interfaces.reference.localization.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CityBaseProcessor {

/*
 * properties injected by spring
 */
@Autowired
protected CityRepository cityRepository;

/**
 * process save
 */
public Long save(City city) {
return cityRepository.saveAndFlush(city).getId();
}

/**
 * process update
 */
public void update(City city) {
// Empty by default. Can be overridden
}

/**
 * process delete
 */
public void delete(City city) {
cityRepository.delete(city);
}

}

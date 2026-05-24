package org.ifolks.demo.components.processor.reference.localization.base;

import org.ifolks.demo.model.reference.localization.Region;
import org.ifolks.demo.persistence.interfaces.reference.localization.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * auto generated base processor class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class RegionBaseProcessor {

/*
 * properties injected by spring
 */
@Autowired
protected RegionRepository regionRepository;

/**
 * process save
 */
public Integer save(Region region) {
return regionRepository.saveAndFlush(region).getId();
}

/**
 * process update
 */
public void update(Region region) {
// Empty by default. Can be overridden
}

/**
 * process delete
 */
public void delete(Region region) {
regionRepository.delete(region);
}

}

package org.ifolks.demo.services.reference.localization.base;

import java.util.ArrayList;
import java.util.List;

import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.demo.api.interfaces.reference.localization.base.RegionBaseService;
import org.ifolks.demo.api.model.reference.localization.filters.RegionFilter;
import org.ifolks.demo.api.model.reference.localization.forms.RegionForm;
import org.ifolks.demo.api.model.reference.localization.sortings.RegionSorting;
import org.ifolks.demo.api.model.reference.localization.views.basic.RegionBasicView;
import org.ifolks.demo.api.model.reference.localization.views.full.RegionFullView;
import org.ifolks.demo.components.mapper.reference.localization.forms.RegionFormMapper;
import org.ifolks.demo.components.mapper.reference.localization.views.basic.RegionBasicViewMapper;
import org.ifolks.demo.components.mapper.reference.localization.views.full.RegionFullViewMapper;
import org.ifolks.demo.components.processor.reference.localization.RegionProcessor;
import org.ifolks.demo.components.rightsmanager.reference.localization.RegionRightsManager;
import org.ifolks.demo.components.statemanager.reference.localization.RegionStateManager;
import org.ifolks.demo.model.reference.localization.Region;
import org.ifolks.demo.persistence.interfaces.reference.localization.CountryDao;
import org.ifolks.demo.persistence.interfaces.reference.localization.RegionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated base service class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class RegionBaseServiceImpl implements RegionBaseService {

/*
 * properties injected by spring
 */
@Autowired
protected RegionDao regionDao;
@Autowired
protected CountryDao countryDao;
@Autowired
protected RegionFullViewMapper regionFullViewMapper;
@Autowired
protected RegionBasicViewMapper regionBasicViewMapper;
@Autowired
protected RegionFormMapper regionFormMapper;
@Autowired
protected RegionStateManager regionStateManager;
@Autowired
protected RegionRightsManager regionRightsManager;
@Autowired
protected RegionProcessor regionProcessor;

/**
 * load object list
 */
@Override
@Transactional(readOnly=true)
public List<RegionBasicView> loadList() {
regionRightsManager.checkCanAccess();
List<Region> regionList = regionDao.loadListEagerly();
List<RegionBasicView> result = new ArrayList<>(regionList.size());
for (Region region : regionList) {
result.add(this.regionBasicViewMapper.toView(region));
}
return result;
}

/**
 * load object list from country
 */
@Override
@Transactional(readOnly=true)
public List<RegionBasicView> loadListFromCountry (Short countryId) {
regionRightsManager.checkCanAccess();
List<Region> regionList = regionDao.loadListEagerlyFromCountry(countryId);
List<RegionBasicView> result = new ArrayList<>(regionList.size());
for (Region region : regionList) {
result.add(this.regionBasicViewMapper.toView(region));
}
return result;
}

/**
 * scroll object list
 */
@Override
@Transactional(readOnly=true)
public ScrollView<RegionBasicView> scroll(ScrollForm<RegionFilter, RegionSorting> form) {
regionRightsManager.checkCanAccess();
Long size = regionDao.count();
Long count = regionDao.count(form.filter());
Long numberOfPages = count/form.elementsPerPage() + ((count%form.elementsPerPage()) > 0L?1L:0L);
Long currentPage = Math.max(1L, Math.min(form.page()!=null?form.page():1L, numberOfPages));
List<Region> list = regionDao.scroll(form.filter(), form.sorting(),(currentPage-1)*form.elementsPerPage(), form.elementsPerPage());
List<RegionBasicView> elements = new ArrayList<>(list.size());
for (Region region : list) {
elements.add(this.regionBasicViewMapper.toView(region));
}
return new ScrollView<>(size, count, numberOfPages, currentPage, elements);
}

/**
 * scroll object list from country
 */
@Override
@Transactional(readOnly=true)
public ScrollView<RegionBasicView> scrollFromCountry (Short countryId, ScrollForm<RegionFilter, RegionSorting> form) {
regionRightsManager.checkCanAccess();
Long size = regionDao.countFromCountry(countryId);
Long count = regionDao.countFromCountry(countryId, form.filter());
Long numberOfPages = count/form.elementsPerPage() + ((count%form.elementsPerPage()) > 0L?1L:0L);
Long currentPage = Math.max(1L, Math.min(form.page()!=null?form.page():1L, numberOfPages));
List<Region> list = regionDao.scrollFromCountry(countryId, form.filter(), form.sorting(),(currentPage-1)*form.elementsPerPage(), form.elementsPerPage());
List<RegionBasicView> elements = new ArrayList<>(list.size());
for (Region region : list) {
elements.add(this.regionBasicViewMapper.toView(region));
}
return new ScrollView<>(size, count, numberOfPages, currentPage, elements);
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public RegionFullView load(Integer id) {
Region region = regionDao.load(id);
regionRightsManager.checkCanAccess(region);
return this.regionFullViewMapper.toView(region);
}

/**
 * find object
 */
@Override
@Transactional(readOnly=true)
public RegionFullView find(String countryCode, String code) {
Region region = regionDao.find(countryCode, code);
regionRightsManager.checkCanAccess(region);
return this.regionFullViewMapper.toView(region);
}

/**
 * save object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Integer save(RegionForm regionForm) {
Region region = this.regionFormMapper.toEntity(regionForm, new Region());
regionRightsManager.checkCanSave(region);
regionStateManager.checkCanSave(region);
return regionProcessor.save(region);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(Integer id, RegionForm regionForm) {
Region region = this.regionDao.load(id);
regionRightsManager.checkCanUpdate(region);
regionStateManager.checkCanUpdate(region);
region = this.regionFormMapper.toEntity(regionForm, region);
regionProcessor.update(region);
}

/**
 * delete object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void delete(Integer id) {
Region region = regionDao.load(id);
regionRightsManager.checkCanDelete(region);
regionStateManager.checkCanDelete(region);
regionProcessor.delete(region);
}

}

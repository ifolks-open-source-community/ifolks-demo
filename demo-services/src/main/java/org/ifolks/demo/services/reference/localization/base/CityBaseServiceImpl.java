package org.ifolks.demo.services.reference.localization.base;

import java.util.ArrayList;
import java.util.List;
import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.demo.api.interfaces.reference.localization.base.CityBaseService;
import org.ifolks.demo.api.model.reference.localization.filters.CityFilter;
import org.ifolks.demo.api.model.reference.localization.forms.CityForm;
import org.ifolks.demo.api.model.reference.localization.sortings.CitySorting;
import org.ifolks.demo.api.model.reference.localization.views.basic.CityBasicView;
import org.ifolks.demo.api.model.reference.localization.views.full.CityFullView;
import org.ifolks.demo.components.mapper.reference.localization.forms.CityFormMapper;
import org.ifolks.demo.components.mapper.reference.localization.views.basic.CityBasicViewMapper;
import org.ifolks.demo.components.mapper.reference.localization.views.full.CityFullViewMapper;
import org.ifolks.demo.components.processor.reference.localization.CityProcessor;
import org.ifolks.demo.components.rightsmanager.reference.localization.CityRightsManager;
import org.ifolks.demo.components.statemanager.reference.localization.CityStateManager;
import org.ifolks.demo.model.reference.localization.City;
import org.ifolks.demo.persistence.interfaces.reference.localization.CityDao;
import org.ifolks.demo.persistence.interfaces.reference.localization.RegionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated base service class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CityBaseServiceImpl implements CityBaseService {

/*
 * properties injected by spring
 */
@Autowired
protected CityDao cityDao;
@Autowired
protected RegionDao regionDao;
@Autowired
protected CityFullViewMapper cityFullViewMapper;
@Autowired
protected CityBasicViewMapper cityBasicViewMapper;
@Autowired
protected CityFormMapper cityFormMapper;
@Autowired
protected CityStateManager cityStateManager;
@Autowired
protected CityRightsManager cityRightsManager;
@Autowired
protected CityProcessor cityProcessor;

/**
 * load object list
 */
@Override
@Transactional(readOnly=true)
public List<CityBasicView> loadList() {
cityRightsManager.checkCanAccess();
List<City> cityList = cityDao.loadListEagerly();
List<CityBasicView> result = new ArrayList<>(cityList.size());
for (City city : cityList) {
result.add(this.cityBasicViewMapper.toView(city));
}
return result;
}

/**
 * load object list from region
 */
@Override
@Transactional(readOnly=true)
public List<CityBasicView> loadListFromRegion (Integer regionId) {
cityRightsManager.checkCanAccess();
List<City> cityList = cityDao.loadListEagerlyFromRegion(regionId);
List<CityBasicView> result = new ArrayList<>(cityList.size());
for (City city : cityList) {
result.add(this.cityBasicViewMapper.toView(city));
}
return result;
}

/**
 * scroll object list
 */
@Override
@Transactional(readOnly=true)
public ScrollView<CityBasicView> scroll(ScrollForm<CityFilter, CitySorting> form) {
cityRightsManager.checkCanAccess();
Long size = cityDao.count();
Long count = cityDao.count(form.filter());
Long numberOfPages = count/form.elementsPerPage() + ((count%form.elementsPerPage()) > 0L?1L:0L);
Long currentPage = Math.max(1L, Math.min(form.page()!=null?form.page():1L, numberOfPages));
List<City> list = cityDao.scroll(form.filter(), form.sorting(),(currentPage-1)*form.elementsPerPage(), form.elementsPerPage());
List<CityBasicView> elements = new ArrayList<>(list.size());
for (City city : list) {
elements.add(this.cityBasicViewMapper.toView(city));
}
return new ScrollView<>(size, count, numberOfPages, currentPage, elements);
}

/**
 * scroll object list from region
 */
@Override
@Transactional(readOnly=true)
public ScrollView<CityBasicView> scrollFromRegion (Integer regionId, ScrollForm<CityFilter, CitySorting> form) {
cityRightsManager.checkCanAccess();
Long size = cityDao.countFromRegion(regionId);
Long count = cityDao.countFromRegion(regionId, form.filter());
Long numberOfPages = count/form.elementsPerPage() + ((count%form.elementsPerPage()) > 0L?1L:0L);
Long currentPage = Math.max(1L, Math.min(form.page()!=null?form.page():1L, numberOfPages));
List<City> list = cityDao.scrollFromRegion(regionId, form.filter(), form.sorting(),(currentPage-1)*form.elementsPerPage(), form.elementsPerPage());
List<CityBasicView> elements = new ArrayList<>(list.size());
for (City city : list) {
elements.add(this.cityBasicViewMapper.toView(city));
}
return new ScrollView<>(size, count, numberOfPages, currentPage, elements);
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public CityFullView load(Long id) {
City city = cityDao.load(id);
cityRightsManager.checkCanAccess(city);
return this.cityFullViewMapper.toView(city);
}

/**
 * find object
 */
@Override
@Transactional(readOnly=true)
public CityFullView find(String regionCountryCode, String regionCode, String code) {
City city = cityDao.find(regionCountryCode, regionCode, code);
cityRightsManager.checkCanAccess(city);
return this.cityFullViewMapper.toView(city);
}

/**
 * save object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Long save(CityForm cityForm) {
City city = this.cityFormMapper.toEntity(cityForm, new City());
cityRightsManager.checkCanSave(city);
cityStateManager.checkCanSave(city);
return cityProcessor.save(city);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(Long id, CityForm cityForm) {
City city = this.cityDao.load(id);
cityRightsManager.checkCanUpdate(city);
cityStateManager.checkCanUpdate(city);
city = this.cityFormMapper.toEntity(cityForm, city);
cityProcessor.update(city);
}

/**
 * delete object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void delete(Long id) {
City city = cityDao.load(id);
cityRightsManager.checkCanDelete(city);
cityStateManager.checkCanDelete(city);
cityProcessor.delete(city);
}

}

package org.ifolks.demo.services.reference.localization.base;

import java.util.ArrayList;
import java.util.List;
import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.commons.api.model.SelectItem;
import org.ifolks.demo.api.interfaces.reference.localization.base.CountryBaseService;
import org.ifolks.demo.api.model.reference.localization.filters.CountryFilter;
import org.ifolks.demo.api.model.reference.localization.forms.CountryForm;
import org.ifolks.demo.api.model.reference.localization.sortings.CountrySorting;
import org.ifolks.demo.api.model.reference.localization.views.basic.CountryBasicView;
import org.ifolks.demo.api.model.reference.localization.views.full.CountryFullView;
import org.ifolks.demo.components.mapper.reference.localization.forms.CountryFormMapper;
import org.ifolks.demo.components.mapper.reference.localization.views.basic.CountryBasicViewMapper;
import org.ifolks.demo.components.mapper.reference.localization.views.full.CountryFullViewMapper;
import org.ifolks.demo.components.processor.reference.localization.CountryProcessor;
import org.ifolks.demo.components.rightsmanager.reference.localization.CountryRightsManager;
import org.ifolks.demo.components.statemanager.reference.localization.CountryStateManager;
import org.ifolks.demo.model.reference.localization.Country;
import org.ifolks.demo.persistence.interfaces.reference.localization.CountryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated base service class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class CountryBaseServiceImpl implements CountryBaseService {

/*
 * properties injected by spring
 */
@Autowired
protected CountryDao countryDao;
@Autowired
protected CountryFullViewMapper countryFullViewMapper;
@Autowired
protected CountryBasicViewMapper countryBasicViewMapper;
@Autowired
protected CountryFormMapper countryFormMapper;
@Autowired
protected CountryStateManager countryStateManager;
@Autowired
protected CountryRightsManager countryRightsManager;
@Autowired
protected CountryProcessor countryProcessor;

/**
 * get options
 */
@Override
@Transactional(readOnly=true)
public List<SelectItem> getOptions() {
List<Country> countryList = countryDao.loadList();
List<SelectItem> result = new ArrayList<>(countryList.size());
for (Country country : countryList) {
result.add(new SelectItem(country.getCode(), country.getCode()));
}
return result;
}

/**
 * load object list
 */
@Override
@Transactional(readOnly=true)
public List<CountryBasicView> loadList() {
countryRightsManager.checkCanAccess();
List<Country> countryList = countryDao.loadListEagerly();
List<CountryBasicView> result = new ArrayList<>(countryList.size());
for (Country country : countryList) {
result.add(this.countryBasicViewMapper.toView(country));
}
return result;
}

/**
 * scroll object list
 */
@Override
@Transactional(readOnly=true)
public ScrollView<CountryBasicView> scroll(ScrollForm<CountryFilter, CountrySorting> form) {
countryRightsManager.checkCanAccess();
Long size = countryDao.count();
Long count = countryDao.count(form.getFilter());
Long numberOfPages = count/form.getElementsPerPage() + ((count%form.getElementsPerPage()) > 0L?1L:0L);
Long currentPage = Math.max(1L, Math.min(form.getPage()!=null?form.getPage():1L, numberOfPages));
List<Country> list = countryDao.scroll(form.getFilter(), form.getSorting(),(currentPage-1)*form.getElementsPerPage(), form.getElementsPerPage());
List<CountryBasicView> elements = new ArrayList<>(list.size());
for (Country country : list) {
elements.add(this.countryBasicViewMapper.toView(country));
}
return new ScrollView<>(size, count, numberOfPages, currentPage, elements);
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public CountryFullView load(Short id) {
Country country = countryDao.load(id);
countryRightsManager.checkCanAccess(country);
return this.countryFullViewMapper.mapFrom(new CountryFullView(),country);
}

/**
 * find object
 */
@Override
@Transactional(readOnly=true)
public CountryFullView find(String code) {
Country country = countryDao.find(code);
countryRightsManager.checkCanAccess(country);
return this.countryFullViewMapper.mapFrom(new CountryFullView(), country);
}

/**
 * create object
 */
@Override
public CountryFullView create() {
countryRightsManager.checkCanCreate();
return new CountryFullView();
}

/**
 * save object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Short save(CountryForm countryForm) {
Country country = this.countryFormMapper.mapTo(countryForm, new Country());
countryRightsManager.checkCanSave(country);
countryStateManager.checkCanSave(country);
return countryProcessor.save(country);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(Short id, CountryForm countryForm) {
Country country = this.countryDao.load(id);
countryRightsManager.checkCanUpdate(country);
countryStateManager.checkCanUpdate(country);
country = this.countryFormMapper.mapTo(countryForm, country);
countryProcessor.update(country);
}

/**
 * delete object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void delete(Short id) {
Country country = countryDao.load(id);
countryRightsManager.checkCanDelete(country);
countryStateManager.checkCanDelete(country);
countryProcessor.delete(country);
}

/**
 * delete object list
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteList(List<Short> idList) {
Country country;
if (idList != null){
for (Short id:idList){
country = countryDao.load(id);
countryRightsManager.checkCanDelete(country);
countryStateManager.checkCanDelete(country);
countryProcessor.delete(country);
}
}
}

}

package org.ifolks.demo.services.dummy.base;

import java.util.ArrayList;
import java.util.List;

import org.ifolks.commons.api.exception.repository.ObjectNotFoundException;
import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.commons.api.model.SelectItem;
import org.ifolks.demo.api.interfaces.dummy.base.FoolBaseService;
import org.ifolks.demo.api.model.dummy.filters.FoolFilter;
import org.ifolks.demo.api.model.dummy.forms.FoolForm;
import org.ifolks.demo.api.model.dummy.sortings.FoolSorting;
import org.ifolks.demo.api.model.dummy.views.basic.FoolBasicView;
import org.ifolks.demo.api.model.dummy.views.full.FoolFullView;
import org.ifolks.demo.components.mapper.dummy.forms.FoolFormMapper;
import org.ifolks.demo.components.mapper.dummy.views.basic.FoolBasicViewMapper;
import org.ifolks.demo.components.mapper.dummy.views.full.FoolFullViewMapper;
import org.ifolks.demo.components.processor.dummy.FoolProcessor;
import org.ifolks.demo.components.rightsmanager.dummy.FoolRightsManager;
import org.ifolks.demo.components.statemanager.dummy.FoolStateManager;
import org.ifolks.demo.model.dummy.Fool;
import org.ifolks.demo.persistence.interfaces.dummy.FoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated base service class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class FoolBaseServiceImpl implements FoolBaseService {

/*
 * properties injected by spring
 */
@Autowired
protected FoolRepository foolRepository;
@Autowired
protected FoolFullViewMapper foolFullViewMapper;
@Autowired
protected FoolBasicViewMapper foolBasicViewMapper;
@Autowired
protected FoolFormMapper foolFormMapper;
@Autowired
protected FoolStateManager foolStateManager;
@Autowired
protected FoolRightsManager foolRightsManager;
@Autowired
protected FoolProcessor foolProcessor;

/**
 * search options
 */
@Override
@Transactional(readOnly=true)
public List<SelectItem> searchOptions(String arg) {
List<Fool> foolList = foolRepository.search(arg);
List<SelectItem> result = new ArrayList<>(foolList.size());
for (Fool fool : foolList) {
result.add(new SelectItem(fool.getCode(), fool.getDescription()));
}
return result;
}

/**
 * load object list
 */
@Override
@Transactional(readOnly=true)
public List<FoolBasicView> loadList() {
foolRightsManager.checkCanAccess();
List<Fool> foolList = foolRepository.loadAll();
List<FoolBasicView> result = new ArrayList<>(foolList.size());
for (Fool fool : foolList) {
result.add(this.foolBasicViewMapper.toView(fool));
}
return result;
}

/**
 * scroll object list
 */
@Override
@Transactional(readOnly=true)
public ScrollView<FoolBasicView> scroll(ScrollForm<FoolFilter, FoolSorting> form) {
foolRightsManager.checkCanAccess();
Long size = foolRepository.count();
Long count = foolRepository.count(form.filter());
Long numberOfPages = count/form.elementsPerPage() + ((count%form.elementsPerPage()) > 0L?1L:0L);
Long currentPage = Math.max(1L, Math.min(form.page()!=null?form.page():1L, numberOfPages));
List<Fool> list = foolRepository.scroll(form.filter(), form.sorting(),(currentPage-1)*form.elementsPerPage(), form.elementsPerPage());
List<FoolBasicView> elements = new ArrayList<>(list.size());
for (Fool fool : list) {
elements.add(this.foolBasicViewMapper.toView(fool));
}
return new ScrollView<>(size, count, numberOfPages, currentPage, elements);
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public FoolFullView load(String id) {
Fool fool = foolRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Fool.notFound"));
foolRightsManager.checkCanAccess(fool);
return this.foolFullViewMapper.toView(fool);
}

/**
 * find object
 */
@Override
@Transactional(readOnly=true)
public FoolFullView find(String code) {
Fool fool = foolRepository.find(code).orElseThrow(() -> new ObjectNotFoundException("Fool.notFound"));
foolRightsManager.checkCanAccess(fool);
return this.foolFullViewMapper.toView(fool);
}

/**
 * save object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public String save(FoolForm foolForm) {
Fool fool = this.foolFormMapper.toEntity(foolForm, new Fool());
foolRightsManager.checkCanSave(fool);
foolStateManager.checkCanSave(fool);
return foolProcessor.save(fool);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(String id, FoolForm foolForm) {
Fool fool = this.foolRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Fool.notFound"));
foolRightsManager.checkCanUpdate(fool);
foolStateManager.checkCanUpdate(fool);
fool = this.foolFormMapper.toEntity(foolForm, fool);
foolProcessor.update(fool);
}

/**
 * delete object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void delete(String id) {
Fool fool = foolRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Fool.notFound"));
foolRightsManager.checkCanDelete(fool);
foolStateManager.checkCanDelete(fool);
foolProcessor.delete(fool);
}

}

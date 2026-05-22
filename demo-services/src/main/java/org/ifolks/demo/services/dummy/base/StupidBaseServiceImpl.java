package org.ifolks.demo.services.dummy.base;

import java.util.ArrayList;
import java.util.List;

import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.demo.api.interfaces.dummy.base.StupidBaseService;
import org.ifolks.demo.api.model.dummy.filters.StupidFilter;
import org.ifolks.demo.api.model.dummy.forms.StupidForm;
import org.ifolks.demo.api.model.dummy.sortings.StupidSorting;
import org.ifolks.demo.api.model.dummy.views.basic.StupidBasicView;
import org.ifolks.demo.api.model.dummy.views.full.StupidFullView;
import org.ifolks.demo.components.mapper.dummy.forms.StupidFormMapper;
import org.ifolks.demo.components.mapper.dummy.views.basic.StupidBasicViewMapper;
import org.ifolks.demo.components.mapper.dummy.views.full.StupidFullViewMapper;
import org.ifolks.demo.components.processor.dummy.StupidProcessor;
import org.ifolks.demo.components.rightsmanager.dummy.StupidRightsManager;
import org.ifolks.demo.components.statemanager.dummy.StupidStateManager;
import org.ifolks.demo.model.dummy.Stupid;
import org.ifolks.demo.persistence.interfaces.dummy.FoolDao;
import org.ifolks.demo.persistence.interfaces.dummy.StupidDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated base service class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class StupidBaseServiceImpl implements StupidBaseService {

/*
 * properties injected by spring
 */
@Autowired
protected StupidDao stupidDao;
@Autowired
protected FoolDao foolDao;
@Autowired
protected StupidFullViewMapper stupidFullViewMapper;
@Autowired
protected StupidBasicViewMapper stupidBasicViewMapper;
@Autowired
protected StupidFormMapper stupidFormMapper;
@Autowired
protected StupidStateManager stupidStateManager;
@Autowired
protected StupidRightsManager stupidRightsManager;
@Autowired
protected StupidProcessor stupidProcessor;

/**
 * load object list
 */
@Override
@Transactional(readOnly=true)
public List<StupidBasicView> loadList() {
stupidRightsManager.checkCanAccess();
List<Stupid> stupidList = stupidDao.loadListEagerly();
List<StupidBasicView> result = new ArrayList<>(stupidList.size());
for (Stupid stupid : stupidList) {
result.add(this.stupidBasicViewMapper.toView(stupid));
}
return result;
}

/**
 * load object list from fool
 */
@Override
@Transactional(readOnly=true)
public List<StupidBasicView> loadListFromFool (String foolId) {
stupidRightsManager.checkCanAccess();
List<Stupid> stupidList = stupidDao.loadListEagerlyFromFool(foolId);
List<StupidBasicView> result = new ArrayList<>(stupidList.size());
for (Stupid stupid : stupidList) {
result.add(this.stupidBasicViewMapper.toView(stupid));
}
return result;
}

/**
 * scroll object list
 */
@Override
@Transactional(readOnly=true)
public ScrollView<StupidBasicView> scroll(ScrollForm<StupidFilter, StupidSorting> form) {
stupidRightsManager.checkCanAccess();
Long size = stupidDao.count();
Long count = stupidDao.count(form.filter());
Long numberOfPages = count/form.elementsPerPage() + ((count%form.elementsPerPage()) > 0L?1L:0L);
Long currentPage = Math.max(1L, Math.min(form.page()!=null?form.page():1L, numberOfPages));
List<Stupid> list = stupidDao.scroll(form.filter(), form.sorting(),(currentPage-1)*form.elementsPerPage(), form.elementsPerPage());
List<StupidBasicView> elements = new ArrayList<>(list.size());
for (Stupid stupid : list) {
elements.add(this.stupidBasicViewMapper.toView(stupid));
}
return new ScrollView<>(size, count, numberOfPages, currentPage, elements);
}

/**
 * scroll object list from fool
 */
@Override
@Transactional(readOnly=true)
public ScrollView<StupidBasicView> scrollFromFool (String foolId, ScrollForm<StupidFilter, StupidSorting> form) {
stupidRightsManager.checkCanAccess();
Long size = stupidDao.countFromFool(foolId);
Long count = stupidDao.countFromFool(foolId, form.filter());
Long numberOfPages = count/form.elementsPerPage() + ((count%form.elementsPerPage()) > 0L?1L:0L);
Long currentPage = Math.max(1L, Math.min(form.page()!=null?form.page():1L, numberOfPages));
List<Stupid> list = stupidDao.scrollFromFool(foolId, form.filter(), form.sorting(),(currentPage-1)*form.elementsPerPage(), form.elementsPerPage());
List<StupidBasicView> elements = new ArrayList<>(list.size());
for (Stupid stupid : list) {
elements.add(this.stupidBasicViewMapper.toView(stupid));
}
return new ScrollView<>(size, count, numberOfPages, currentPage, elements);
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public StupidFullView load(Long id) {
Stupid stupid = stupidDao.load(id);
stupidRightsManager.checkCanAccess(stupid);
return this.stupidFullViewMapper.toView(stupid);
}

/**
 * find object
 */
@Override
@Transactional(readOnly=true)
public StupidFullView find(String code) {
Stupid stupid = stupidDao.find(code);
stupidRightsManager.checkCanAccess(stupid);
return this.stupidFullViewMapper.toView(stupid);
}

/**
 * save object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Long save(StupidForm stupidForm) {
Stupid stupid = this.stupidFormMapper.toEntity(stupidForm, new Stupid());
stupidRightsManager.checkCanSave(stupid);
stupidStateManager.checkCanSave(stupid);
return stupidProcessor.save(stupid);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(Long id, StupidForm stupidForm) {
Stupid stupid = this.stupidDao.load(id);
stupidRightsManager.checkCanUpdate(stupid);
stupidStateManager.checkCanUpdate(stupid);
stupid = this.stupidFormMapper.toEntity(stupidForm, stupid);
stupidProcessor.update(stupid);
}

/**
 * delete object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void delete(Long id) {
Stupid stupid = stupidDao.load(id);
stupidRightsManager.checkCanDelete(stupid);
stupidStateManager.checkCanDelete(stupid);
stupidProcessor.delete(stupid);
}

}

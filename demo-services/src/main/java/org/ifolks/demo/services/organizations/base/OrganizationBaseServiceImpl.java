package org.ifolks.demo.services.organizations.base;

import java.util.ArrayList;
import java.util.List;

import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.commons.api.model.SelectItem;
import org.ifolks.demo.api.interfaces.organizations.base.OrganizationBaseService;
import org.ifolks.demo.api.model.organizations.filters.OrganizationFilter;
import org.ifolks.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.ifolks.demo.api.model.organizations.forms.OrganizationForm;
import org.ifolks.demo.api.model.organizations.sortings.OrganizationSorting;
import org.ifolks.demo.api.model.organizations.views.basic.OrganizationBasicView;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationCertificationFullView;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationFullView;
import org.ifolks.demo.components.mapper.organizations.forms.OrganizationCertificationFormMapper;
import org.ifolks.demo.components.mapper.organizations.forms.OrganizationFormMapper;
import org.ifolks.demo.components.mapper.organizations.views.basic.OrganizationBasicViewMapper;
import org.ifolks.demo.components.mapper.organizations.views.full.OrganizationCertificationFullViewMapper;
import org.ifolks.demo.components.mapper.organizations.views.full.OrganizationFullViewMapper;
import org.ifolks.demo.components.processor.organizations.OrganizationProcessor;
import org.ifolks.demo.components.rightsmanager.organizations.OrganizationRightsManager;
import org.ifolks.demo.components.statemanager.organizations.OrganizationStateManager;
import org.ifolks.demo.model.organizations.Organization;
import org.ifolks.demo.model.organizations.OrganizationCertification;
import org.ifolks.demo.persistence.interfaces.organizations.OrganizationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * auto generated base service class file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class OrganizationBaseServiceImpl implements OrganizationBaseService {

/*
 * properties injected by spring
 */
@Autowired
protected OrganizationDao organizationDao;
@Autowired
protected OrganizationFullViewMapper organizationFullViewMapper;
@Autowired
protected OrganizationBasicViewMapper organizationBasicViewMapper;
@Autowired
protected OrganizationFormMapper organizationFormMapper;
@Autowired
protected OrganizationCertificationFullViewMapper organizationCertificationFullViewMapper;
@Autowired
protected OrganizationCertificationFormMapper organizationCertificationFormMapper;
@Autowired
protected OrganizationStateManager organizationStateManager;
@Autowired
protected OrganizationRightsManager organizationRightsManager;
@Autowired
protected OrganizationProcessor organizationProcessor;

/**
 * search options
 */
@Override
@Transactional(readOnly=true)
public List<SelectItem> searchOptions(String arg) {
List<Organization> organizationList = organizationDao.search(arg);
List<SelectItem> result = new ArrayList<>(organizationList.size());
for (Organization organization : organizationList) {
result.add(new SelectItem(organization.getCode(), organization.getCode()));
}
return result;
}

/**
 * load object list
 */
@Override
@Transactional(readOnly=true)
public List<OrganizationBasicView> loadList() {
organizationRightsManager.checkCanAccess();
List<Organization> organizationList = organizationDao.loadListEagerly();
List<OrganizationBasicView> result = new ArrayList<>(organizationList.size());
for (Organization organization : organizationList) {
result.add(this.organizationBasicViewMapper.toView(organization));
}
return result;
}

/**
 * scroll object list
 */
@Override
@Transactional(readOnly=true)
public ScrollView<OrganizationBasicView> scroll(ScrollForm<OrganizationFilter, OrganizationSorting> form) {
organizationRightsManager.checkCanAccess();
Long size = organizationDao.count();
Long count = organizationDao.count(form.filter());
Long numberOfPages = count/form.elementsPerPage() + ((count%form.elementsPerPage()) > 0L?1L:0L);
Long currentPage = Math.max(1L, Math.min(form.page()!=null?form.page():1L, numberOfPages));
List<Organization> list = organizationDao.scroll(form.filter(), form.sorting(),(currentPage-1)*form.elementsPerPage(), form.elementsPerPage());
List<OrganizationBasicView> elements = new ArrayList<>(list.size());
for (Organization organization : list) {
elements.add(this.organizationBasicViewMapper.toView(organization));
}
return new ScrollView<>(size, count, numberOfPages, currentPage, elements);
}

/**
 * load object
 */
@Override
@Transactional(readOnly=true)
public OrganizationFullView load(Integer id) {
Organization organization = organizationDao.load(id);
organizationRightsManager.checkCanAccess(organization);
return this.organizationFullViewMapper.toView(organization);
}

/**
 * find object
 */
@Override
@Transactional(readOnly=true)
public OrganizationFullView find(String code) {
Organization organization = organizationDao.find(code);
organizationRightsManager.checkCanAccess(organization);
return this.organizationFullViewMapper.toView(organization);
}

/**
 * load one to one component organizationCertification
 */
@Override
@Transactional(readOnly=true)
public OrganizationCertificationFullView loadOrganizationCertification(Integer id) {
Organization organization = organizationDao.load(id);
organizationRightsManager.checkCanAccessOrganizationCertification(organization);
OrganizationCertification organizationCertification = organization.getOrganizationCertification();
if (organizationCertification==null) {
return null;
} else {
return this.organizationCertificationFullViewMapper.toView(organizationCertification);
}
}

/**
 * save object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public Integer save(OrganizationForm organizationForm) {
Organization organization = this.organizationFormMapper.toEntity(organizationForm, new Organization());
organizationRightsManager.checkCanSave(organization);
organizationStateManager.checkCanSave(organization);
return organizationProcessor.save(organization);
}

/**
 * save one to one component organizationCertification
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void saveOrganizationCertification(Integer id, OrganizationCertificationForm organizationCertificationForm) {
Organization organization = this.organizationDao.load(id);
OrganizationCertification organizationCertification = this.organizationCertificationFormMapper.toEntity(organizationCertificationForm, new OrganizationCertification());
organizationRightsManager.checkCanSaveOrganizationCertification(organizationCertification,organization);
organizationStateManager.checkCanSaveOrganizationCertification(organizationCertification,organization);
organizationProcessor.saveOrganizationCertification(organizationCertification, organization);
}

/**
 * update object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void update(Integer id, OrganizationForm organizationForm) {
Organization organization = this.organizationDao.load(id);
organizationRightsManager.checkCanUpdate(organization);
organizationStateManager.checkCanUpdate(organization);
organization = this.organizationFormMapper.toEntity(organizationForm, organization);
organizationProcessor.update(organization);
}

/**
 * update one to one component organizationCertification
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void updateOrganizationCertification(Integer id, OrganizationCertificationForm organizationCertificationForm) {
Organization organization = this.organizationDao.load(id);
OrganizationCertification organizationCertification = organization.getOrganizationCertification();
organizationRightsManager.checkCanUpdateOrganizationCertification(organizationCertification);
organizationStateManager.checkCanUpdateOrganizationCertification(organizationCertification);
organization.setOrganizationCertification(this.organizationCertificationFormMapper.toEntity(organizationCertificationForm, organizationCertification));
organizationProcessor.updateOrganizationCertification(organizationCertification);
}

/**
 * delete object
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void delete(Integer id) {
Organization organization = organizationDao.load(id);
organizationRightsManager.checkCanDelete(organization);
organizationStateManager.checkCanDelete(organization);
organizationProcessor.delete(organization);
}

/**
 * delete one to one component organizationCertification
 */
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteOrganizationCertification(Integer id) {
Organization organization = this.organizationDao.load(id);
OrganizationCertification organizationCertification = organization.getOrganizationCertification();
organizationRightsManager.checkCanDeleteOrganizationCertification(organizationCertification);
organizationStateManager.checkCanDeleteOrganizationCertification(organizationCertification);
this.organizationProcessor.deleteOrganizationCertification(organizationCertification);
}

}

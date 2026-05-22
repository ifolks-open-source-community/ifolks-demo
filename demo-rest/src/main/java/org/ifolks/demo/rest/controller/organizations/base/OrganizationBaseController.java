package org.ifolks.demo.rest.controller.organizations.base;

import java.util.List;

import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.commons.api.model.SelectItem;
import org.ifolks.demo.api.interfaces.organizations.OrganizationService;
import org.ifolks.demo.api.model.organizations.filters.OrganizationFilter;
import org.ifolks.demo.api.model.organizations.forms.OrganizationCertificationForm;
import org.ifolks.demo.api.model.organizations.forms.OrganizationForm;
import org.ifolks.demo.api.model.organizations.sortings.OrganizationSorting;
import org.ifolks.demo.api.model.organizations.views.basic.OrganizationBasicView;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationCertificationFullView;
import org.ifolks.demo.api.model.organizations.views.full.OrganizationFullView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;

/**
 * auto generated base rest controller file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class OrganizationBaseController {

/*
 * services injected by spring
 */
@Autowired
protected OrganizationService organizationService;

/**
 * search options
 */
@RequestMapping(value = {OrganizationService.SEARCH_OPTIONS_URL }, method = RequestMethod.GET)
public @ResponseBody List<SelectItem> searchOptions(@RequestParam("arg") String arg) {
return organizationService.searchOptions(arg);
}

/**
 * load object list
 */
@RequestMapping(value = {OrganizationService.GET_LIST_URL}, method = RequestMethod.GET)
public @ResponseBody List<OrganizationBasicView> loadList() {
return organizationService.loadList();
}

/**
 * scroll object list
 */
@RequestMapping(value = {OrganizationService.SCROLL_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<OrganizationBasicView> scroll(@RequestBody ScrollForm<OrganizationFilter, OrganizationSorting> form) {
return organizationService.scroll(form);
}

/**
 * load object
 */
@RequestMapping(value = {OrganizationService.GET_URL}, method = RequestMethod.GET)
public @ResponseBody OrganizationFullView load(@PathVariable("id") Integer id) {
return organizationService.load(id);
}
/**
 * find object
 */
@RequestMapping(value = {OrganizationService.FIND_URL}, method = RequestMethod.GET)
public @ResponseBody OrganizationFullView find(@RequestParam("code") String code) {
return organizationService.find(code);
}

/**
 * load one to one component organizationCertification
 */
@RequestMapping(value = {OrganizationService.GET_ORGANIZATION_CERTIFICATION_URL}, method = RequestMethod.GET)
public @ResponseBody OrganizationCertificationFullView loadOrganizationCertification(@PathVariable("id") Integer id) {
return organizationService.loadOrganizationCertification(id);
}

/**
 * save object
 */
@RequestMapping(value = {OrganizationService.SAVE_URL}, method = RequestMethod.POST)
public @ResponseBody Integer save(@Valid @RequestBody OrganizationForm form) {
return organizationService.save(form);
}

/**
 * save one to one component organizationCertification
 */
@RequestMapping(value = {OrganizationService.SAVE_ORGANIZATION_CERTIFICATION_URL}, method = RequestMethod.POST)
public @ResponseBody void saveOrganizationCertification(@PathVariable("id") Integer id, @Valid @RequestBody OrganizationCertificationForm form) {
organizationService.saveOrganizationCertification(id, form);
}

/**
 * update object
 */
@RequestMapping(value = {OrganizationService.UPDATE_URL}, method = RequestMethod.PUT)
public @ResponseBody void update(@PathVariable("id") Integer id, @Valid @RequestBody OrganizationForm form) {
organizationService.update(id, form);
}

/**
 * update one to one component organizationCertification
 */
@RequestMapping(value = {OrganizationService.UPDATE_ORGANIZATION_CERTIFICATION_URL}, method = RequestMethod.PUT)
public @ResponseBody void updateOrganizationCertification(@PathVariable("id") Integer id, @Valid @RequestBody OrganizationCertificationForm form) {
organizationService.updateOrganizationCertification(id, form);
}

/**
 * delete object
 */
@RequestMapping(value = {OrganizationService.DELETE_URL}, method = RequestMethod.DELETE)
public @ResponseBody void delete(@PathVariable("id") Integer id) {
organizationService.delete(id);
}

/**
 * delete one to one component organizationCertification
 */
@RequestMapping(value = {OrganizationService.DELETE_ORGANIZATION_CERTIFICATION_URL}, method = RequestMethod.DELETE)
public @ResponseBody void deleteOrganizationCertification(@PathVariable("id")Integer id) {
organizationService.deleteOrganizationCertification(id);
}

}

package org.ifolks.demo.rest.controller.reference.localization.base;

import java.util.List;
import javax.validation.Valid;
import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.demo.api.interfaces.reference.localization.RegionService;
import org.ifolks.demo.api.model.reference.localization.filters.RegionFilter;
import org.ifolks.demo.api.model.reference.localization.forms.RegionForm;
import org.ifolks.demo.api.model.reference.localization.sortings.RegionSorting;
import org.ifolks.demo.api.model.reference.localization.views.basic.RegionBasicView;
import org.ifolks.demo.api.model.reference.localization.views.full.RegionFullView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * auto generated base rest controller file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
public class RegionBaseController {

/*
 * services injected by spring
 */
@Autowired
protected RegionService regionService;

/**
 * load object list
 */
@RequestMapping(value = {RegionService.GET_LIST_URL}, method = RequestMethod.GET)
public @ResponseBody List<RegionBasicView> loadList() {
return regionService.loadList();
}

/**
 * load object list from country
 */
@RequestMapping(value = {RegionService.GET_LIST_FROM_COUNTRY_URL}, method = RequestMethod.GET)
public @ResponseBody List<RegionBasicView> loadListFromCountry (@PathVariable("countryId") Short countryId) {
return regionService.loadListFromCountry(countryId);
}
/**
 * scroll object list
 */
@RequestMapping(value = {RegionService.SCROLL_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<RegionBasicView> scroll(@RequestBody ScrollForm<RegionFilter, RegionSorting> form) {
return regionService.scroll(form);
}

/**
 * scroll object list from country
 */
@RequestMapping(value = {RegionService.SCROLL_FROM_COUNTRY_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<RegionBasicView> scrollFromCountry (@PathVariable("countryId") Short countryId, @RequestBody ScrollForm<RegionFilter, RegionSorting> form) {
return regionService.scrollFromCountry(countryId, form);
}
/**
 * load object
 */
@RequestMapping(value = {RegionService.GET_URL}, method = RequestMethod.GET)
public @ResponseBody RegionFullView load(@PathVariable("id") Integer id) {
return regionService.load(id);
}
/**
 * find object
 */
@RequestMapping(value = {RegionService.FIND_URL}, method = RequestMethod.GET)
public @ResponseBody RegionFullView find(@RequestParam("countryCode") String countryCode, @RequestParam("code") String code) {
return regionService.find(countryCode, code);
}

/**
 * create object
 */
@RequestMapping(value = {RegionService.GET_NEW_URL}, method = RequestMethod.GET)
public @ResponseBody RegionFullView create() {
return regionService.create();
}

/**
 * save object
 */
@RequestMapping(value = {RegionService.SAVE_URL}, method = RequestMethod.POST)
public @ResponseBody Integer save(@Valid @RequestBody RegionForm form) {
return regionService.save(form);
}

/**
 * update object
 */
@RequestMapping(value = {RegionService.UPDATE_URL}, method = RequestMethod.PUT)
public @ResponseBody void update(@PathVariable("id") Integer id, @Valid @RequestBody RegionForm form) {
regionService.update(id, form);
}

/**
 * delete object
 */
@RequestMapping(value = {RegionService.DELETE_URL}, method = RequestMethod.DELETE)
public @ResponseBody void delete(@PathVariable("id") Integer id) {
regionService.delete(id);
}

/**
 * delete object list
 */
@RequestMapping(value = {RegionService.DELETE_LIST_URL}, method = RequestMethod.POST)
public @ResponseBody void deleteList(@RequestBody List<Integer> idList) {
regionService.deleteList(idList);
}

}

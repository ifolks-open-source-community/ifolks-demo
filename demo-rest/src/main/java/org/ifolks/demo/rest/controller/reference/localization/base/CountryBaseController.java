package org.ifolks.demo.rest.controller.reference.localization.base;

import jakarta.validation.Valid;
import java.util.List;
import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.commons.api.model.SelectItem;
import org.ifolks.demo.api.interfaces.reference.localization.CountryService;
import org.ifolks.demo.api.model.reference.localization.filters.CountryFilter;
import org.ifolks.demo.api.model.reference.localization.forms.CountryForm;
import org.ifolks.demo.api.model.reference.localization.sortings.CountrySorting;
import org.ifolks.demo.api.model.reference.localization.views.basic.CountryBasicView;
import org.ifolks.demo.api.model.reference.localization.views.full.CountryFullView;
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
public class CountryBaseController {

/*
 * services injected by spring
 */
@Autowired
protected CountryService countryService;

/**
 * get options
 */
@RequestMapping(value = {CountryService.GET_OPTIONS_URL}, method = RequestMethod.GET)
public @ResponseBody List<SelectItem> getOptions() {
return countryService.getOptions();
}

/**
 * load object list
 */
@RequestMapping(value = {CountryService.GET_LIST_URL}, method = RequestMethod.GET)
public @ResponseBody List<CountryBasicView> loadList() {
return countryService.loadList();
}

/**
 * scroll object list
 */
@RequestMapping(value = {CountryService.SCROLL_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<CountryBasicView> scroll(@RequestBody ScrollForm<CountryFilter, CountrySorting> form) {
return countryService.scroll(form);
}

/**
 * load object
 */
@RequestMapping(value = {CountryService.GET_URL}, method = RequestMethod.GET)
public @ResponseBody CountryFullView load(@PathVariable("id") Short id) {
return countryService.load(id);
}
/**
 * find object
 */
@RequestMapping(value = {CountryService.FIND_URL}, method = RequestMethod.GET)
public @ResponseBody CountryFullView find(@RequestParam("code") String code) {
return countryService.find(code);
}

/**
 * save object
 */
@RequestMapping(value = {CountryService.SAVE_URL}, method = RequestMethod.POST)
public @ResponseBody Short save(@Valid @RequestBody CountryForm form) {
return countryService.save(form);
}

/**
 * update object
 */
@RequestMapping(value = {CountryService.UPDATE_URL}, method = RequestMethod.PUT)
public @ResponseBody void update(@PathVariable("id") Short id, @Valid @RequestBody CountryForm form) {
countryService.update(id, form);
}

/**
 * delete object
 */
@RequestMapping(value = {CountryService.DELETE_URL}, method = RequestMethod.DELETE)
public @ResponseBody void delete(@PathVariable("id") Short id) {
countryService.delete(id);
}

}

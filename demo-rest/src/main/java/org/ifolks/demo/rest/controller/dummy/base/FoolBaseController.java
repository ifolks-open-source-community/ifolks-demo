package org.ifolks.demo.rest.controller.dummy.base;

import java.util.List;
import javax.validation.Valid;
import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.commons.api.model.SelectItem;
import org.ifolks.demo.api.interfaces.dummy.FoolService;
import org.ifolks.demo.api.model.dummy.filters.FoolFilter;
import org.ifolks.demo.api.model.dummy.forms.FoolForm;
import org.ifolks.demo.api.model.dummy.sortings.FoolSorting;
import org.ifolks.demo.api.model.dummy.views.basic.FoolBasicView;
import org.ifolks.demo.api.model.dummy.views.full.FoolFullView;
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
public class FoolBaseController {

/*
 * services injected by spring
 */
@Autowired
protected FoolService foolService;

/**
 * search options
 */
@RequestMapping(value = {FoolService.SEARCH_OPTIONS_URL }, method = RequestMethod.GET)
public @ResponseBody List<SelectItem> searchOptions(@RequestParam("arg") String arg) {
return foolService.searchOptions(arg);
}

/**
 * load object list
 */
@RequestMapping(value = {FoolService.GET_LIST_URL}, method = RequestMethod.GET)
public @ResponseBody List<FoolBasicView> loadList() {
return foolService.loadList();
}

/**
 * scroll object list
 */
@RequestMapping(value = {FoolService.SCROLL_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<FoolBasicView> scroll(@RequestBody ScrollForm<FoolFilter, FoolSorting> form) {
return foolService.scroll(form);
}

/**
 * load object
 */
@RequestMapping(value = {FoolService.GET_URL}, method = RequestMethod.GET)
public @ResponseBody FoolFullView load(@PathVariable("id") String id) {
return foolService.load(id);
}
/**
 * find object
 */
@RequestMapping(value = {FoolService.FIND_URL}, method = RequestMethod.GET)
public @ResponseBody FoolFullView find(@RequestParam("code") String code) {
return foolService.find(code);
}

/**
 * save object
 */
@RequestMapping(value = {FoolService.SAVE_URL}, method = RequestMethod.POST)
public @ResponseBody String save(@Valid @RequestBody FoolForm form) {
return foolService.save(form);
}

/**
 * update object
 */
@RequestMapping(value = {FoolService.UPDATE_URL}, method = RequestMethod.PUT)
public @ResponseBody void update(@PathVariable("id") String id, @Valid @RequestBody FoolForm form) {
foolService.update(id, form);
}

/**
 * delete object
 */
@RequestMapping(value = {FoolService.DELETE_URL}, method = RequestMethod.DELETE)
public @ResponseBody void delete(@PathVariable("id") String id) {
foolService.delete(id);
}

}

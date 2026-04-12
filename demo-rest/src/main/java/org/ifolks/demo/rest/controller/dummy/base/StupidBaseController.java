package org.ifolks.demo.rest.controller.dummy.base;

import java.util.List;
import javax.validation.Valid;
import org.ifolks.commons.api.model.ScrollForm;
import org.ifolks.commons.api.model.ScrollView;
import org.ifolks.demo.api.interfaces.dummy.StupidService;
import org.ifolks.demo.api.model.dummy.filters.StupidFilter;
import org.ifolks.demo.api.model.dummy.forms.StupidForm;
import org.ifolks.demo.api.model.dummy.sortings.StupidSorting;
import org.ifolks.demo.api.model.dummy.views.basic.StupidBasicView;
import org.ifolks.demo.api.model.dummy.views.full.StupidFullView;
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
public class StupidBaseController {

/*
 * services injected by spring
 */
@Autowired
protected StupidService stupidService;

/**
 * load object list
 */
@RequestMapping(value = {StupidService.GET_LIST_URL}, method = RequestMethod.GET)
public @ResponseBody List<StupidBasicView> loadList() {
return stupidService.loadList();
}

/**
 * load object list from fool
 */
@RequestMapping(value = {StupidService.GET_LIST_FROM_FOOL_URL}, method = RequestMethod.GET)
public @ResponseBody List<StupidBasicView> loadListFromFool (@PathVariable("foolId") String foolId) {
return stupidService.loadListFromFool(foolId);
}
/**
 * scroll object list
 */
@RequestMapping(value = {StupidService.SCROLL_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<StupidBasicView> scroll(@RequestBody ScrollForm<StupidFilter, StupidSorting> form) {
return stupidService.scroll(form);
}

/**
 * scroll object list from fool
 */
@RequestMapping(value = {StupidService.SCROLL_FROM_FOOL_URL}, method = RequestMethod.POST)
public @ResponseBody ScrollView<StupidBasicView> scrollFromFool (@PathVariable("foolId") String foolId, @RequestBody ScrollForm<StupidFilter, StupidSorting> form) {
return stupidService.scrollFromFool(foolId, form);
}
/**
 * load object
 */
@RequestMapping(value = {StupidService.GET_URL}, method = RequestMethod.GET)
public @ResponseBody StupidFullView load(@PathVariable("id") Long id) {
return stupidService.load(id);
}
/**
 * find object
 */
@RequestMapping(value = {StupidService.FIND_URL}, method = RequestMethod.GET)
public @ResponseBody StupidFullView find(@RequestParam("code") String code) {
return stupidService.find(code);
}

/**
 * save object
 */
@RequestMapping(value = {StupidService.SAVE_URL}, method = RequestMethod.POST)
public @ResponseBody Long save(@Valid @RequestBody StupidForm form) {
return stupidService.save(form);
}

/**
 * update object
 */
@RequestMapping(value = {StupidService.UPDATE_URL}, method = RequestMethod.PUT)
public @ResponseBody void update(@PathVariable("id") Long id, @Valid @RequestBody StupidForm form) {
stupidService.update(id, form);
}

/**
 * delete object
 */
@RequestMapping(value = {StupidService.DELETE_URL}, method = RequestMethod.DELETE)
public @ResponseBody void delete(@PathVariable("id") Long id) {
stupidService.delete(id);
}

}

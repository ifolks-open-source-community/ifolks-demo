package org.ifolks.demo.api.model.reference.localization.sortings;

import java.io.Serializable;

import org.ifolks.commons.api.model.OrderType;

/**
 * auto generated ordering class file
 * <br/>basic representation of filter used along with jsf datatable
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class CitySorting implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private OrderType regionCountryCodeOrderType;
private OrderType regionCodeOrderType;
private OrderType codeOrderType;
private OrderType labelOrderType;

/*
 * getters and setters
 */
public OrderType getRegionCountryCodeOrderType() {
return this.regionCountryCodeOrderType;
}

public void setRegionCountryCodeOrderType(OrderType regionCountryCodeOrderType) {
this.regionCountryCodeOrderType = regionCountryCodeOrderType;
}

public OrderType getRegionCodeOrderType() {
return this.regionCodeOrderType;
}

public void setRegionCodeOrderType(OrderType regionCodeOrderType) {
this.regionCodeOrderType = regionCodeOrderType;
}

public OrderType getCodeOrderType() {
return this.codeOrderType;
}

public void setCodeOrderType(OrderType codeOrderType) {
this.codeOrderType = codeOrderType;
}

public OrderType getLabelOrderType() {
return this.labelOrderType;
}

public void setLabelOrderType(OrderType labelOrderType) {
this.labelOrderType = labelOrderType;
}


/* Specific Code Start */
/* Specific Code End */
}

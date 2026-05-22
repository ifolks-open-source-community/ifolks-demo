package org.ifolks.demo.api.model.dummy.sortings;

import java.io.Serializable;

import org.ifolks.commons.api.model.OrderType;

/**
 * auto generated ordering class file
 * <br/>basic representation of filter used along with jsf datatable
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class StupidSorting implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private OrderType codeOrderType;
private OrderType foolCodeOrderType;

/*
 * getters and setters
 */
public OrderType getCodeOrderType() {
return this.codeOrderType;
}

public void setCodeOrderType(OrderType codeOrderType) {
this.codeOrderType = codeOrderType;
}

public OrderType getFoolCodeOrderType() {
return this.foolCodeOrderType;
}

public void setFoolCodeOrderType(OrderType foolCodeOrderType) {
this.foolCodeOrderType = foolCodeOrderType;
}


/* Specific Code Start */
/* Specific Code End */
}

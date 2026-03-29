package org.ifolks.demo.api.model.reference.localization.sortings;

import java.io.Serializable;
import org.ifolks.commons.api.model.OrderType;

/**
 * auto generated ordering class file
 * <br/>basic representation of filter used along with jsf datatable
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class CountrySorting implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private OrderType codeOrderType;
private OrderType labelOrderType;

/*
 * getters and setters
 */
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

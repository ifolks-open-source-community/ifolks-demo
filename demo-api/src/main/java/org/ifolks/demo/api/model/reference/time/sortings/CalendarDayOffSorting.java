package org.ifolks.demo.api.model.reference.time.sortings;

import java.io.Serializable;
import org.ifolks.commons.api.model.OrderType;

/**
 * auto generated ordering class file
 * <br/>basic representation of filter used along with jsf datatable
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class CalendarDayOffSorting implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private OrderType dayOffDateOrderType;
private OrderType dayOffLabelOrderType;

/*
 * getters and setters
 */
public OrderType getDayOffDateOrderType() {
return this.dayOffDateOrderType;
}

public void setDayOffDateOrderType(OrderType dayOffDateOrderType) {
this.dayOffDateOrderType = dayOffDateOrderType;
}

public OrderType getDayOffLabelOrderType() {
return this.dayOffLabelOrderType;
}

public void setDayOffLabelOrderType(OrderType dayOffLabelOrderType) {
this.dayOffLabelOrderType = dayOffLabelOrderType;
}


/* Specific Code Start */
/* Specific Code End */
}

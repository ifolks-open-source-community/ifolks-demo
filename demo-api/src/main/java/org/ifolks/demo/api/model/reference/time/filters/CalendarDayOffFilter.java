package org.ifolks.demo.api.model.reference.time.filters;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * auto generated filter class file
 * <br/>basic representation of filter used along with jsf datatable
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class CalendarDayOffFilter implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private LocalDate dayOffDateMinValue;
private LocalDate dayOffDateMaxValue;
private String dayOffLabel;

/*
 * getters and setters
 */
public LocalDate getDayOffDateMinValue() {
return this.dayOffDateMinValue;
}
public void setDayOffDateMinValue(LocalDate dayOffDateMinValue) {
this.dayOffDateMinValue = dayOffDateMinValue;
}
public LocalDate getDayOffDateMaxValue() {
return this.dayOffDateMaxValue;
}
public void setDayOffDateMaxValue(LocalDate dayOffDateMaxValue) {
this.dayOffDateMaxValue = dayOffDateMaxValue;
}
public String getDayOffLabel() {
return this.dayOffLabel;
}
public void setDayOffLabel(String dayOffLabel) {
this.dayOffLabel = dayOffLabel;
}

/* Specific Code Start */
/* Specific Code End */
}

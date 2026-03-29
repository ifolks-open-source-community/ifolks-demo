package org.ifolks.demo.api.model.reference.time.forms;

import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

/**
 * auto generated form bean class file
 * <br/>basic representation of what is going to be considered as model in MVC patterns
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class CalendarDayOffForm implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
@NotNull
private LocalDate dayOffDate;
private String dayOffLabel;

/*
 * getters and setters
 */
public LocalDate getDayOffDate() {
return this.dayOffDate;
}
public void setDayOffDate(LocalDate dayOffDate) {
this.dayOffDate = dayOffDate;
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

package org.ifolks.demo.api.model.dummy.filters;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;

/**
 * auto generated filter class file
 * <br/>basic representation of filter used along with jsf datatable
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class FoolFilter implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private String code;
private String description;
private Boolean booleanField;
private LocalDate dateFieldMinValue;
private LocalDate dateFieldMaxValue;
private OffsetDateTime datetimeFieldMinValue;
private OffsetDateTime datetimeFieldMaxValue;

/*
 * getters and setters
 */
public String getCode() {
return this.code;
}
public void setCode(String code) {
this.code = code;
}
public String getDescription() {
return this.description;
}
public void setDescription(String description) {
this.description = description;
}
public Boolean getBooleanField() {
return this.booleanField;
}
public void setBooleanField(Boolean booleanField) {
this.booleanField = booleanField;
}
public LocalDate getDateFieldMinValue() {
return this.dateFieldMinValue;
}
public void setDateFieldMinValue(LocalDate dateFieldMinValue) {
this.dateFieldMinValue = dateFieldMinValue;
}
public LocalDate getDateFieldMaxValue() {
return this.dateFieldMaxValue;
}
public void setDateFieldMaxValue(LocalDate dateFieldMaxValue) {
this.dateFieldMaxValue = dateFieldMaxValue;
}
public OffsetDateTime getDatetimeFieldMinValue() {
return this.datetimeFieldMinValue;
}
public void setDatetimeFieldMinValue(OffsetDateTime datetimeFieldMinValue) {
this.datetimeFieldMinValue = datetimeFieldMinValue;
}
public OffsetDateTime getDatetimeFieldMaxValue() {
return this.datetimeFieldMaxValue;
}
public void setDatetimeFieldMaxValue(OffsetDateTime datetimeFieldMaxValue) {
this.datetimeFieldMaxValue = datetimeFieldMaxValue;
}

/* Specific Code Start */
/* Specific Code End */
}

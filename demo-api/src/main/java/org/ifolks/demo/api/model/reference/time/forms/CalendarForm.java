package org.ifolks.demo.api.model.reference.time.forms;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 * auto generated form bean class file
 * <br/>basic representation of what is going to be considered as model in MVC patterns
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class CalendarForm implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
@NotNull
private String code;
@NotNull
private String label;

/*
 * getters and setters
 */
public String getCode() {
return this.code;
}
public void setCode(String code) {
this.code = code;
}
public String getLabel() {
return this.label;
}
public void setLabel(String label) {
this.label = label;
}

/* Specific Code Start */
/* Specific Code End */
}

package org.ifolks.demo.api.model.dummy.forms;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 * auto generated form bean class file
 * <br/>basic representation of what is going to be considered as model in MVC patterns
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class StupidForm implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
@NotNull
private String code;
@NotNull
private String foolCode;

/*
 * getters and setters
 */
public String getCode() {
return this.code;
}
public void setCode(String code) {
this.code = code;
}
public String getFoolCode() {
return this.foolCode;
}
public void setFoolCode(String foolCode) {
this.foolCode = foolCode;
}

/* Specific Code Start */
/* Specific Code End */
}

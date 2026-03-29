package org.ifolks.demo.api.model.organizations.forms;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 * auto generated form bean class file
 * <br/>basic representation of what is going to be considered as model in MVC patterns
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class OrganizationForm implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
@NotNull
private String code;
private String description;

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

/* Specific Code Start */
/* Specific Code End */
}

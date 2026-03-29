package org.ifolks.demo.api.model.organizations.forms;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 * auto generated form bean class file
 * <br/>basic representation of what is going to be considered as model in MVC patterns
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class OrganizationCertificationForm implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
@NotNull
private Boolean certified;

/*
 * getters and setters
 */
public Boolean getCertified() {
return this.certified;
}
public void setCertified(Boolean certified) {
this.certified = certified;
}

/* Specific Code Start */
/* Specific Code End */
}

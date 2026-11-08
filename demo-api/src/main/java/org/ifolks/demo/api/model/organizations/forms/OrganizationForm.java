package org.ifolks.demo.api.model.organizations.forms;

import jakarta.validation.constraints.NotNull;

import org.ifolks.demo.api.model.organizations.enums.OrganizationRole;

/**
 * auto generated form bean record file
 * <br/>basic representation of what is going to be considered as model in MVC patterns
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public record OrganizationForm (
@NotNull String code,
@NotNull OrganizationRole role,
String description
) {

/* Specific Code Start */
/* Specific Code End */
}

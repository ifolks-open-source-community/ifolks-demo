package org.ifolks.demo.api.model.organizations.views.basic;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import org.ifolks.demo.model.organizations.OrganizationRole;

/**
 * auto generated basic view record
 * <br/>basic representation of an entity, adapted to list screens
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public record OrganizationBasicView (

Integer id,
boolean selected,
boolean canDelete,
String code,
OrganizationRole role,
String description

) {
/* Specific Code Start */
/* Specific Code End */
}

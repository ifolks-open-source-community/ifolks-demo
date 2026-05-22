package org.ifolks.demo.api.model.dummy.forms;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;

/**
 * auto generated form bean record file
 * <br/>basic representation of what is going to be considered as model in MVC patterns
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public record FoolForm (
@NotNull String code,
String description,
Long longField,
Boolean booleanField,
Double doubleField,
BigDecimal decimalField,
LocalDate dateField,
OffsetDateTime datetimeField
) {

/* Specific Code Start */
/* Specific Code End */
}

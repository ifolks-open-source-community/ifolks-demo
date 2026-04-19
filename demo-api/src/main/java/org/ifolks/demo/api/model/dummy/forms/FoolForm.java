package org.ifolks.demo.api.model.dummy.forms;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

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
Date datetimeField
) {

/* Specific Code Start */
/* Specific Code End */
}

package org.ifolks.demo.api.model.reference.time.forms;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * auto generated form bean record file
 * <br/>basic representation of what is going to be considered as model in MVC patterns
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public record CalendarDayOffForm (
@NotNull LocalDate dayOffDate,
String dayOffLabel
) {

/* Specific Code Start */
/* Specific Code End */
}

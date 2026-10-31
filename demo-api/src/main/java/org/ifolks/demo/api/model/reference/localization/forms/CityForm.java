package org.ifolks.demo.api.model.reference.localization.forms;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

/**
 * auto generated form bean record file
 * <br/>basic representation of what is going to be considered as model in MVC patterns
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public record CityForm (
@NotNull String regionCountryCode,
@NotNull String regionCode,
@NotNull String code,
@NotNull String label
) {

/* Specific Code Start */
/* Specific Code End */
}

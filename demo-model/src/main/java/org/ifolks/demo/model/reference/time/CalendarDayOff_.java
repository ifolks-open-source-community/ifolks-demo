package org.ifolks.demo.model.reference.time;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import org.ifolks.demo.model.reference.time.Calendar;

/**
 * auto generated entity metamodel class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
@StaticMetamodel(CalendarDayOff.class)
public abstract class CalendarDayOff_ {

public static volatile SingularAttribute<CalendarDayOff, Integer> id;
public static volatile SingularAttribute<CalendarDayOff, Calendar> calendar;
public static volatile SingularAttribute<CalendarDayOff, LocalDate> dayOffDate;
public static volatile SingularAttribute<CalendarDayOff, String> dayOffLabel;

public static final String ID = "id";
public static final String CALENDAR = "calendar";
public static final String DAY_OFF_DATE = "dayOffDate";
public static final String DAY_OFF_LABEL = "dayOffLabel";

/* Specific Code Start */
/* Specific Code End */
}
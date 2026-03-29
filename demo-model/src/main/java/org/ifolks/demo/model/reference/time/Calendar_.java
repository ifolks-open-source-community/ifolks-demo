package org.ifolks.demo.model.reference.time;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

/**
 * auto generated entity metamodel class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
@StaticMetamodel(Calendar.class)
public abstract class Calendar_ {

public static volatile SingularAttribute<Calendar, Integer> id;
public static volatile SingularAttribute<Calendar, String> code;
public static volatile SingularAttribute<Calendar, String> label;
public static volatile SetAttribute<Calendar, CalendarDayOff> calendarDayOffCollection;

public static final String ID = "id";
public static final String CODE = "code";
public static final String LABEL = "label";
public static final String CALENDAR_DAY_OFF_COLLECTION = "calendarDayOffCollection";

/* Specific Code Start */
/* Specific Code End */
}
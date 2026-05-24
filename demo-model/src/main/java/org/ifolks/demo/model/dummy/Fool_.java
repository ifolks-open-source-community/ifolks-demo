package org.ifolks.demo.model.dummy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

/**
 * auto generated entity metamodel class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
@StaticMetamodel(Fool.class)
public abstract class Fool_ {

public static volatile SingularAttribute<Fool, String> id;
public static volatile SingularAttribute<Fool, String> code;
public static volatile SingularAttribute<Fool, String> description;
public static volatile SingularAttribute<Fool, Long> longField;
public static volatile SingularAttribute<Fool, Boolean> booleanField;
public static volatile SingularAttribute<Fool, Double> doubleField;
public static volatile SingularAttribute<Fool, BigDecimal> decimalField;
public static volatile SingularAttribute<Fool, LocalDate> dateField;
public static volatile SingularAttribute<Fool, OffsetDateTime> datetimeField;
public static volatile SingularAttribute<Fool, Stupid> stupid;

public static final String ID = "id";
public static final String CODE = "code";
public static final String DESCRIPTION = "description";
public static final String LONG_FIELD = "longField";
public static final String BOOLEAN_FIELD = "booleanField";
public static final String DOUBLE_FIELD = "doubleField";
public static final String DECIMAL_FIELD = "decimalField";
public static final String DATE_FIELD = "dateField";
public static final String DATETIME_FIELD = "datetimeField";
public static final String STUPID = "Stupid";

/* Specific Code Start */
/* Specific Code End */
}
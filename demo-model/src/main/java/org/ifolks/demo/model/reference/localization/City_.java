package org.ifolks.demo.model.reference.localization;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

/**
 * auto generated entity metamodel class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
@StaticMetamodel(City.class)
public abstract class City_ {

public static volatile SingularAttribute<City, Long> id;
public static volatile SingularAttribute<City, Region> region;
public static volatile SingularAttribute<City, String> code;
public static volatile SingularAttribute<City, String> label;

public static final String ID = "id";
public static final String REGION = "region";
public static final String CODE = "code";
public static final String LABEL = "label";

/* Specific Code Start */
/* Specific Code End */
}
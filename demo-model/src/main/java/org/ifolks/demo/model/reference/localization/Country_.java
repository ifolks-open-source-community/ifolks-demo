package org.ifolks.demo.model.reference.localization;

import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

/**
 * auto generated entity metamodel class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
@StaticMetamodel(Country.class)
public abstract class Country_ {

public static volatile SingularAttribute<Country, Short> id;
public static volatile SingularAttribute<Country, String> code;
public static volatile SingularAttribute<Country, String> label;
public static volatile SetAttribute<Country, Region> regionCollection;

public static final String ID = "id";
public static final String CODE = "code";
public static final String LABEL = "label";
public static final String REGION_COLLECTION = "regionCollection";

/* Specific Code Start */
/* Specific Code End */
}
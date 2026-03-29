package org.ifolks.demo.model.organizations;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

/**
 * auto generated entity metamodel class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
@StaticMetamodel(OrganizationCertification.class)
public abstract class OrganizationCertification_ {

public static volatile SingularAttribute<OrganizationCertification, String> id;
public static volatile SingularAttribute<OrganizationCertification, Organization> organization;
public static volatile SingularAttribute<OrganizationCertification, Boolean> certified;

public static final String ID = "id";
public static final String ORGANIZATION = "organization";
public static final String CERTIFIED = "certified";

/* Specific Code Start */
/* Specific Code End */
}
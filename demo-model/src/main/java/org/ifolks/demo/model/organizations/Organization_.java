package org.ifolks.demo.model.organizations;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

/**
 * auto generated entity metamodel class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
@StaticMetamodel(Organization.class)
public abstract class Organization_ {

public static volatile SingularAttribute<Organization, Integer> id;
public static volatile SingularAttribute<Organization, String> code;
public static volatile SingularAttribute<Organization, OrganizationDescription> organizationDescription;
public static volatile SingularAttribute<Organization, OrganizationCertification> organizationCertification;

public static final String ID = "id";
public static final String CODE = "code";
public static final String ORGANIZATION_DESCRIPTION = "organizationDescription";
public static final String ORGANIZATION_CERTIFICATION = "OrganizationCertification";

/* Specific Code Start */
/* Specific Code End */
}
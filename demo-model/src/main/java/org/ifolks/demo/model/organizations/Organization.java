package org.ifolks.demo.model.organizations;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
@Entity
@Table(name="ORGANIZATION"
, uniqueConstraints = {
@UniqueConstraint(name = "UC_ORGANIZATION", columnNames = {"CODE"})
, @UniqueConstraint(name = "UC_ORGANIZATION_C1", columnNames = {"ORGANIZATION_DESCRIPTION_ID"})
}
, indexes = {
@Index(name = "IDX_ORGANIZATION_UC", columnList = "CODE")
, @Index(name = "IDX_ORGANIZATION_C1", columnList = "ORGANIZATION_DESCRIPTION_ID")
})
public class Organization implements java.io.Serializable {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public Organization(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@SequenceGenerator(name = "organizationIdGenerator", sequenceName = "ORGANIZATION_SEQ", allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizationIdGenerator")
private Integer id;

@Column(name = "CODE", nullable = false)
private String code;

@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name = "ORGANIZATION_DESCRIPTION_ID", nullable = false)
private OrganizationDescription organizationDescription;

@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "organization")
@Fetch(FetchMode.JOIN)
private OrganizationCertification organizationCertification;


/*
 * getters and setters
 */
public Integer getId() {
return this.id;
}

public void setId(Integer id) {
this.id = id;
}

public String getCode() {
return this.code;
}

public void setCode(String code) {
this.code = code;
}

public OrganizationDescription getOrganizationDescription() {
return this.organizationDescription;
}

public void setOrganizationDescription(OrganizationDescription organizationDescription) {
this.organizationDescription = organizationDescription;
}

public OrganizationCertification getOrganizationCertification () {
return this.organizationCertification;
}

public void setOrganizationCertification (OrganizationCertification organizationCertification) {
this.organizationCertification = organizationCertification;
}


/* Specific Code Start */
/* Specific Code End */
}
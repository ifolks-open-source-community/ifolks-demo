package org.ifolks.demo.model.organizations;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
@Entity
@Table(name="ORGANIZATION_CERTIFICATION"
, uniqueConstraints = {
@UniqueConstraint(name = "UC_ORGANIZATION_CERTIFICATION_C0", columnNames = {"ORGANIZATION_ID"})
}
, indexes = {
@Index(name = "IDX_ORGANIZATION_CERTIFICATION_C0", columnList = "ORGANIZATION_ID")
})
public class OrganizationCertification implements org.ifolks.commons.model.interfaces.Entity<String> {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public OrganizationCertification(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@GeneratedValue(generator="uuid")
@GenericGenerator(name="uuid", strategy = "uuid2")
private String id;

@ManyToOne(fetch = FetchType.LAZY)
@Fetch(FetchMode.JOIN)
@JoinColumn(name = "ORGANIZATION_ID")
private Organization organization;

@Column(name = "CERTIFIED", nullable = false)
private Boolean certified;


/*
 * getters and setters
 */
public String getId() {
return this.id;
}

public void setId(String id) {
this.id = id;
}

public Organization getOrganization() {
return this.organization;
}

public void setOrganization(Organization organization) {
this.organization = organization;
}

public Boolean getCertified() {
return this.certified;
}

public void setCertified(Boolean certified) {
this.certified = certified;
}


/* Specific Code Start */
/* Specific Code End */
}
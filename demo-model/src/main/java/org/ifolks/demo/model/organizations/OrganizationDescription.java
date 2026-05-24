package org.ifolks.demo.model.organizations;

import org.hibernate.Length;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
@Entity
@Table(name="ORGANIZATION_DESCRIPTION"
, uniqueConstraints = {
}
, indexes = {
})
public class OrganizationDescription implements java.io.Serializable {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public OrganizationDescription(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@SequenceGenerator(name = "organizationDescriptionIdGenerator", sequenceName = "ORGANIZATION_DESCRIPTION_SEQ", allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizationDescriptionIdGenerator")
private Long id;

@Lob
@JdbcTypeCode(SqlTypes.LONGVARCHAR)
@Column(name = "DESCRIPTION", length = Length.LOB_DEFAULT)
private String description;


/*
 * getters and setters
 */
public Long getId() {
return this.id;
}

public void setId(Long id) {
this.id = id;
}

public String getDescription() {
return this.description;
}

public void setDescription(String description) {
this.description = description;
}


/* Specific Code Start */
/* Specific Code End */
}
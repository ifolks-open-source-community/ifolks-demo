package org.ifolks.demo.model.organizations;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;

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
@Column(name = "DESCRIPTION")
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
package org.ifolks.demo.model.reference.localization;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
@Entity
@Table(name="CITY"
, uniqueConstraints = {
@UniqueConstraint(name = "UC_CITY", columnNames = {"REGION_ID", "CODE"})
}
, indexes = {
@Index(name = "IDX_CITY_UC", columnList = "REGION_ID, CODE")
, @Index(name = "IDX_CITY_C0", columnList = "REGION_ID")
})
public class City implements java.io.Serializable {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public City(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@SequenceGenerator(name = "cityIdGenerator", sequenceName = "CITY_SEQ", allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cityIdGenerator")
private Long id;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "REGION_ID", nullable = false)
private Region region;

@Column(name = "CODE", nullable = false)
private String code;

@Column(name = "LABEL", nullable = false)
private String label;


/*
 * getters and setters
 */
public Long getId() {
return this.id;
}

public void setId(Long id) {
this.id = id;
}

public Region getRegion() {
return this.region;
}

public void setRegion(Region region) {
this.region = region;
}

public String getCode() {
return this.code;
}

public void setCode(String code) {
this.code = code;
}

public String getLabel() {
return this.label;
}

public void setLabel(String label) {
this.label = label;
}


/* Specific Code Start */
/* Specific Code End */
}
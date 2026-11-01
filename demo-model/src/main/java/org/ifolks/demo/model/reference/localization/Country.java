package org.ifolks.demo.model.reference.localization;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
@Entity
@Table(name="COUNTRY"
, uniqueConstraints = {
@UniqueConstraint(name = "UC_COUNTRY", columnNames = {"CODE"})
, @UniqueConstraint(name = "UC_COUNTRY_C1", columnNames = {"LABEL"})
}
, indexes = {
@Index(name = "IDX_COUNTRY_UC", columnList = "CODE")
, @Index(name = "IDX_COUNTRY_C1", columnList = "LABEL")
})
public class Country implements java.io.Serializable {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public Country(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@SequenceGenerator(name = "countryIdGenerator", sequenceName = "COUNTRY_SEQ", allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countryIdGenerator")
private Short id;

@Column(name = "CODE", nullable = false)
private String code;

@Column(name = "LABEL", nullable = false)
private String label;

@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
private Set <Region> regionCollection;


/*
 * getters and setters
 */
public Short getId() {
return this.id;
}

public void setId(Short id) {
this.id = id;
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

public Set <Region> getRegionCollection () {
return this.regionCollection;
}

public void setRegionCollection(Set <Region> regionCollection) {
this.regionCollection = regionCollection;
}


/* Specific Code Start */
/* Specific Code End */
}
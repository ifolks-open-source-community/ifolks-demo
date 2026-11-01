package org.ifolks.demo.model.reference.localization;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="REGION"
, uniqueConstraints = {
@UniqueConstraint(name = "UC_REGION", columnNames = {"COUNTRY_ID", "CODE"})
}
, indexes = {
@Index(name = "IDX_REGION_UC", columnList = "COUNTRY_ID, CODE")
, @Index(name = "IDX_REGION_C0", columnList = "COUNTRY_ID")
})
public class Region implements java.io.Serializable {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public Region(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@SequenceGenerator(name = "regionIdGenerator", sequenceName = "REGION_SEQ", allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regionIdGenerator")
private Integer id;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "COUNTRY_ID", nullable = false)
private Country country;

@Column(name = "CODE", nullable = false)
private String code;

@Column(name = "LABEL", nullable = false)
private String label;

@OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
private Set <City> cityCollection;


/*
 * getters and setters
 */
public Integer getId() {
return this.id;
}

public void setId(Integer id) {
this.id = id;
}

public Country getCountry() {
return this.country;
}

public void setCountry(Country country) {
this.country = country;
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

public Set <City> getCityCollection () {
return this.cityCollection;
}

public void setCityCollection(Set <City> cityCollection) {
this.cityCollection = cityCollection;
}


/* Specific Code Start */
/* Specific Code End */
}
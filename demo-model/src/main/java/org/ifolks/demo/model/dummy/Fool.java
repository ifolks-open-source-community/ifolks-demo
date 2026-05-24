package org.ifolks.demo.model.dummy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import org.hibernate.Length;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
@Entity
@Table(name="FOOL"
, uniqueConstraints = {
@UniqueConstraint(name = "UC_FOOL", columnNames = {"CODE"})
}
, indexes = {
@Index(name = "IDX_FOOL_UC", columnList = "CODE")
})
public class Fool implements java.io.Serializable {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public Fool(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@GeneratedValue(strategy = GenerationType.UUID)
private String id;

@Column(name = "CODE", nullable = false)
private String code;

@Lob
@JdbcTypeCode(SqlTypes.LONGVARCHAR)
@Column(name = "DESCRIPTION", length = Length.LOB_DEFAULT)
private String description;

@Column(name = "LONG_FIELD")
private Long longField;

@Column(name = "BOOLEAN_FIELD")
private Boolean booleanField;

@Column(name = "DOUBLE_FIELD")
private Double doubleField;

@Column(name = "DECIMAL_FIELD")
private BigDecimal decimalField;

@Column(name = "DATE_FIELD")
private LocalDate dateField;

@Column(name = "DATETIME_FIELD")
private OffsetDateTime datetimeField;

@OneToOne(fetch = FetchType.LAZY, mappedBy = "fool")
@Fetch(FetchMode.JOIN)
private Stupid stupid;


/*
 * getters and setters
 */
public String getId() {
return this.id;
}

public void setId(String id) {
this.id = id;
}

public String getCode() {
return this.code;
}

public void setCode(String code) {
this.code = code;
}

public String getDescription() {
return this.description;
}

public void setDescription(String description) {
this.description = description;
}

public Long getLongField() {
return this.longField;
}

public void setLongField(Long longField) {
this.longField = longField;
}

public Boolean getBooleanField() {
return this.booleanField;
}

public void setBooleanField(Boolean booleanField) {
this.booleanField = booleanField;
}

public Double getDoubleField() {
return this.doubleField;
}

public void setDoubleField(Double doubleField) {
this.doubleField = doubleField;
}

public BigDecimal getDecimalField() {
return this.decimalField;
}

public void setDecimalField(BigDecimal decimalField) {
this.decimalField = decimalField;
}

public LocalDate getDateField() {
return this.dateField;
}

public void setDateField(LocalDate dateField) {
this.dateField = dateField;
}

public OffsetDateTime getDatetimeField() {
return this.datetimeField;
}

public void setDatetimeField(OffsetDateTime datetimeField) {
this.datetimeField = datetimeField;
}

public Stupid getStupid () {
return this.stupid;
}

public void setStupid (Stupid stupid) {
this.stupid = stupid;
}


/* Specific Code Start */
/* Specific Code End */
}
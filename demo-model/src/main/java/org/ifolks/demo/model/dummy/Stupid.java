package org.ifolks.demo.model.dummy;

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
@Table(name="STUPID"
, uniqueConstraints = {
@UniqueConstraint(name = "UC_STUPID", columnNames = {"CODE"})
}
, indexes = {
@Index(name = "IDX_STUPID_UC", columnList = "CODE")
, @Index(name = "IDX_STUPID_C1", columnList = "FOOL_ID")
})
public class Stupid implements org.ifolks.commons.model.interfaces.Entity<Long> {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public Stupid(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@SequenceGenerator(name = "stupidIdGenerator", sequenceName = "STUPID_SEQ", allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stupidIdGenerator")
private Long id;

@Column(name = "CODE", nullable = false)
private String code;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "FOOL_ID", nullable = false)
private Fool fool;


/*
 * getters and setters
 */
public Long getId() {
return this.id;
}

public void setId(Long id) {
this.id = id;
}

public String getCode() {
return this.code;
}

public void setCode(String code) {
this.code = code;
}

public Fool getFool() {
return this.fool;
}

public void setFool(Fool fool) {
this.fool = fool;
}


/* Specific Code Start */
/* Specific Code End */
}
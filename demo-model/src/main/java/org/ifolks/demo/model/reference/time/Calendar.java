package org.ifolks.demo.model.reference.time;

import jakarta.persistence.CascadeType;
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
import java.util.Set;

/**
 * auto generated entity class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
@Entity
@Table(name="CALENDAR"
, uniqueConstraints = {
@UniqueConstraint(name = "UC_CALENDAR", columnNames = {"CODE"})
}
, indexes = {
@Index(name = "IDX_CALENDAR_UC", columnList = "CODE")
})
public class Calendar implements org.ifolks.commons.model.interfaces.Entity<Integer> {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public Calendar(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@SequenceGenerator(name = "calendarIdGenerator", sequenceName = "CALENDAR_SEQ", allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendarIdGenerator")
private Integer id;

@Column(name = "CODE", nullable = false)
private String code;

@Column(name = "LABEL", nullable = false)
private String label;

@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "calendar")
private Set <CalendarDayOff> calendarDayOffCollection;


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

public String getLabel() {
return this.label;
}

public void setLabel(String label) {
this.label = label;
}

public Set <CalendarDayOff> getCalendarDayOffCollection () {
return this.calendarDayOffCollection;
}

public void setCalendarDayOffCollection(Set <CalendarDayOff> calendarDayOffCollection) {
this.calendarDayOffCollection = calendarDayOffCollection;
}


/* Specific Code Start */
/* Specific Code End */
}
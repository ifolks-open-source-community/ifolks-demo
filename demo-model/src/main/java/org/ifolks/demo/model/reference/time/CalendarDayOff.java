package org.ifolks.demo.model.reference.time;

import java.time.LocalDate;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
@Table(name="CALENDAR_DAY_OFF"
, uniqueConstraints = {
@UniqueConstraint(name = "UC_CALENDAR_DAY_OFF", columnNames = {"CALENDAR_ID", "DAY_OFF_DATE"})
}
, indexes = {
@Index(name = "IDX_CALENDAR_DAY_OFF_UC", columnList = "CALENDAR_ID, DAY_OFF_DATE")
, @Index(name = "IDX_CALENDAR_DAY_OFF_C0", columnList = "CALENDAR_ID")
})
public class CalendarDayOff implements org.ifolks.commons.model.interfaces.Entity<Integer> {

private static final long serialVersionUID = 1L;

/*
 * no argument constructor
 */
public CalendarDayOff(){
}

/*
 * properties
 */
@Id
@Column(name = "id", nullable = false)
@SequenceGenerator(name = "calendarDayOffIdGenerator", sequenceName = "CALENDAR_DAY_OFF_SEQ", allocationSize=1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendarDayOffIdGenerator")
private Integer id;

@ManyToOne(fetch = FetchType.LAZY)
@Fetch(FetchMode.JOIN)
@JoinColumn(name = "CALENDAR_ID", nullable = false)
private Calendar calendar;

@Column(name = "DAY_OFF_DATE", nullable = false)
private LocalDate dayOffDate;

@Column(name = "DAY_OFF_LABEL")
private String dayOffLabel;


/*
 * getters and setters
 */
public Integer getId() {
return this.id;
}

public void setId(Integer id) {
this.id = id;
}

public Calendar getCalendar() {
return this.calendar;
}

public void setCalendar(Calendar calendar) {
this.calendar = calendar;
}

public LocalDate getDayOffDate() {
return this.dayOffDate;
}

public void setDayOffDate(LocalDate dayOffDate) {
this.dayOffDate = dayOffDate;
}

public String getDayOffLabel() {
return this.dayOffLabel;
}

public void setDayOffLabel(String dayOffLabel) {
this.dayOffLabel = dayOffLabel;
}


/* Specific Code Start */
/* Specific Code End */
}
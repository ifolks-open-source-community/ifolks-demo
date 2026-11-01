package org.ifolks.demo.api.model.organizations.sortings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import org.ifolks.commons.api.model.OrderType;

/**
 * auto generated ordering class file
 * <br/>basic representation of filter used along with jsf datatable
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */
public class OrganizationSorting implements Serializable {

private static final long serialVersionUID = 1L;

/*
 * properties
 */
private OrderType codeOrderType;
private OrderType roleOrderType;
private OrderType descriptionOrderType;

/*
 * getters and setters
 */
public OrderType getCodeOrderType() {
return this.codeOrderType;
}

public void setCodeOrderType(OrderType codeOrderType) {
this.codeOrderType = codeOrderType;
}

public OrderType getRoleOrderType() {
return this.roleOrderType;
}

public void setRoleOrderType(OrderType roleOrderType) {
this.roleOrderType = roleOrderType;
}

public OrderType getDescriptionOrderType() {
return this.descriptionOrderType;
}

public void setDescriptionOrderType(OrderType descriptionOrderType) {
this.descriptionOrderType = descriptionOrderType;
}


/* Specific Code Start */
/* Specific Code End */
}

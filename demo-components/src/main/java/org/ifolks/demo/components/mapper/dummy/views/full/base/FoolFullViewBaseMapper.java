package org.ifolks.demo.components.mapper.dummy.views.full.base;

import org.ifolks.demo.api.model.dummy.forms.FoolForm;
import org.ifolks.demo.api.model.dummy.views.full.FoolFullView;
import org.ifolks.demo.components.mapper.dummy.forms.FoolFormMapper;
import org.ifolks.demo.components.rightsmanager.dummy.FoolRightsManager;
import org.ifolks.demo.components.statemanager.dummy.FoolStateManager;
import org.ifolks.demo.model.dummy.Fool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated mapper class file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component
public class FoolFullViewBaseMapper {

@Autowired
protected FoolRightsManager foolRightsManager;
@Autowired
protected FoolStateManager foolStateManager;

@Autowired
protected FoolFormMapper formMapper;

/**
 * mapping entity to view
 */
public FoolFullView toView(Fool fool) {
String id = fool.getId();
FoolForm form = formMapper.toForm(fool);
boolean canUpdate = foolRightsManager.canUpdate(fool) && foolStateManager.canUpdate(fool);
boolean canDelete = foolRightsManager.canDelete(fool) && foolStateManager.canDelete(fool);
return new FoolFullView(id, canUpdate, canDelete, form);
}

}

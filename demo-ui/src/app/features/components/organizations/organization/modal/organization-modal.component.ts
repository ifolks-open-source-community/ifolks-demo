import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { Observable } from 'rxjs';
import { OrganizationFullView } from 'src/app/features/models/organizations/views/full/OrganizationFullView';
import { OrganizationRestClient } from 'src/app/features/services/organizations/OrganizationRestClient';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { StringUtils } from 'src/app/core/services/StringUtils';
/**
 * auto generated modal component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-organization-modal',
templateUrl: './organization-modal.component.html',
styleUrls: ['./organization-modal.component.scss']
})
export class OrganizationModalComponent implements OnInit {

view: OrganizationFullView;
form: FormGroup;

constructor(private service:OrganizationRestClient, private formBuilder: FormBuilder, private notifications: NotificationService, private dialogRef: MatDialogRef<OrganizationModalComponent>) {}

ngOnInit(): void {
this.form = this.formBuilder.group({
code:[{value:null}, Validators.required],
description:[{value:null}]});
this.restoreForm();
}
restoreForm(): void {
this.form.patchValue({
code: this.view.form.code,
description: this.view.form.description
})
}

applyForm(): void {
this.view.form.code = StringUtils.emptyToNull(this.form.get('code').value);
this.view.form.description = StringUtils.emptyToNull(this.form.get('description').value);
}

save(): void {
this.applyForm();
this.service.save(this.view.form).subscribe(success => {this.notifications.info("Operation completed");this.dialogRef.close();}, error => {this.notifications.error("Operation failed")});
}

update(): void {
this.applyForm();
this.service.update(this.view.id, this.view.form).subscribe(success => {this.notifications.info("Operation completed");this.dialogRef.close();}, error => {this.notifications.error("Operation failed")});
}

saveOrUpdate(): void {
if (this.view.id == null) {this.save()} else {this.update()}
}

/* Specific Code Start */
/* Specific Code End */
}

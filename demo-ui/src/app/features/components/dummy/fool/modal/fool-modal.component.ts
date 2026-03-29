import { Component, OnInit, ViewChild } from '@angular/core';
import { FoolFullView } from 'src/app/features/models/dummy/views/full/FoolFullView';
import { FoolRestClient } from 'src/app/features/services/dummy/FoolRestClient';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { Observable } from 'rxjs';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { StringUtils } from 'src/app/core/services/StringUtils';
/**
 * auto generated modal component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-fool-modal',
templateUrl: './fool-modal.component.html',
styleUrls: ['./fool-modal.component.scss']
})
export class FoolModalComponent implements OnInit {

view: FoolFullView;
form: FormGroup;

constructor(private service:FoolRestClient, private formBuilder: FormBuilder, private notifications: NotificationService, private dialogRef: MatDialogRef<FoolModalComponent>) {}

ngOnInit(): void {
this.form = this.formBuilder.group({
code:[{value:null}, Validators.required],
description:[{value:null}],
longField:[{value:null}],
booleanField:[{value:null}],
doubleField:[{value:null}],
decimalField:[{value:null}],
dateField:[{value:null}],
datetimeField:[{value:null}]});
this.restoreForm();
}
restoreForm(): void {
this.form.patchValue({
code: this.view.form.code,
description: this.view.form.description,
longField: this.view.form.longField,
booleanField: this.view.form.booleanField,
doubleField: this.view.form.doubleField,
decimalField: this.view.form.decimalField,
dateField: this.view.form.dateField,
datetimeField: this.view.form.datetimeField
})
}

applyForm(): void {
this.view.form.code = StringUtils.emptyToNull(this.form.get('code').value);
this.view.form.description = StringUtils.emptyToNull(this.form.get('description').value);
this.view.form.longField = StringUtils.emptyToNull(this.form.get('longField').value);
this.view.form.booleanField = StringUtils.stringToNullableBoolean(this.form.get('booleanField').value);
this.view.form.doubleField = StringUtils.emptyToNull(this.form.get('doubleField').value);
this.view.form.decimalField = StringUtils.emptyToNull(this.form.get('decimalField').value);
this.view.form.dateField = StringUtils.emptyToNull(this.form.get('dateField').value);
this.view.form.datetimeField = StringUtils.emptyToNull(this.form.get('datetimeField').value);
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

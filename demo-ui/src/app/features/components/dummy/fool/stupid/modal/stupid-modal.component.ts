import { Component, OnInit, ViewChild } from '@angular/core';
import { FoolFullView } from 'src/app/features/models/dummy/views/full/FoolFullView';
import { FoolRestClient } from 'src/app/features/services/dummy/FoolRestClient';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { Observable } from 'rxjs';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { StringUtils } from 'src/app/core/services/StringUtils';
import { StupidFullView } from 'src/app/features/models/dummy/views/full/StupidFullView';
import { StupidRestClient } from 'src/app/features/services/dummy/StupidRestClient';
/**
 * auto generated one to many modal component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-stupidfrom-fool-modal',
templateUrl: './stupid-modal.component.html',
styleUrls: ['./stupid-modal.component.scss']
})
export class StupidModalComponent implements OnInit {

parentId: string;
view: StupidFullView;
form: FormGroup;

constructor(private service:StupidRestClient, private foolService:FoolRestClient, private formBuilder: FormBuilder, private notifications: NotificationService, private dialogRef: MatDialogRef<StupidModalComponent>) {}

ngOnInit(): void {
this.form = this.formBuilder.group({
code:[{value:null}, Validators.required]});
this.restoreForm();
}
restoreForm(): void {
this.form.patchValue({
code: this.view.form.code
})
}

applyForm(): void {
this.view.form.code = StringUtils.emptyToNull(this.form.get('code').value);
}

save(): void {
this.applyForm();
let foolFullView: FoolFullView;
this.foolService.load(this.parentId).subscribe((t) => {foolFullView=t;
this.view.form.foolCode = foolFullView.form.code;
this.service.save(this.view.form).subscribe(success => {this.notifications.info("Operation completed");this.dialogRef.close();}, error => {this.notifications.error("Operation failed")});
});
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

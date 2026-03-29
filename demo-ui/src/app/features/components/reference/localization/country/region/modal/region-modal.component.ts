import { Component, OnInit, ViewChild } from '@angular/core';
import { CountryFullView } from 'src/app/features/models/reference/localization/views/full/CountryFullView';
import { CountryRestClient } from 'src/app/features/services/reference/localization/CountryRestClient';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { Observable } from 'rxjs';
import { RegionFullView } from 'src/app/features/models/reference/localization/views/full/RegionFullView';
import { RegionRestClient } from 'src/app/features/services/reference/localization/RegionRestClient';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { StringUtils } from 'src/app/core/services/StringUtils';
/**
 * auto generated one to many modal component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-regionfrom-country-modal',
templateUrl: './region-modal.component.html',
styleUrls: ['./region-modal.component.scss']
})
export class RegionModalComponent implements OnInit {

parentId: number;
view: RegionFullView;
form: FormGroup;

constructor(private service:RegionRestClient, private countryService:CountryRestClient, private formBuilder: FormBuilder, private notifications: NotificationService, private dialogRef: MatDialogRef<RegionModalComponent>) {}

ngOnInit(): void {
this.form = this.formBuilder.group({
code:[{value:null}, Validators.required],
label:[{value:null}, Validators.required]});
this.restoreForm();
}
restoreForm(): void {
this.form.patchValue({
code: this.view.form.code,
label: this.view.form.label
})
}

applyForm(): void {
this.view.form.code = StringUtils.emptyToNull(this.form.get('code').value);
this.view.form.label = StringUtils.emptyToNull(this.form.get('label').value);
}

save(): void {
this.applyForm();
let countryFullView: CountryFullView;
this.countryService.load(this.parentId).subscribe((t) => {countryFullView=t;
this.view.form.countryCode = countryFullView.form.code;
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

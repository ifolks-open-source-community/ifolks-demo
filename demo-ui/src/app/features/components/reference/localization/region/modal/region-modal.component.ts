import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { CountryRestClient } from 'src/app/features/services/reference/localization/CountryRestClient';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { Observable } from 'rxjs';
import { RegionFullView } from 'src/app/features/models/reference/localization/views/full/RegionFullView';
import { RegionRestClient } from 'src/app/features/services/reference/localization/RegionRestClient';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { SharedModule } from 'src/app/shared/shared.module';
import { StringUtils } from 'src/app/core/services/StringUtils';
/**
 * auto generated modal component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-region-modal',
standalone: true,
imports: [CommonModule, SharedModule],
templateUrl: './region-modal.component.html',
styleUrl: './region-modal.component.scss'
})
export class RegionModalComponent implements OnInit {

view: RegionFullView;
form: FormGroup;
countryCodeOptions: SelectItem[];

constructor(private service:RegionRestClient, private countryService:CountryRestClient, private formBuilder: FormBuilder, private notifications: NotificationService, private dialogRef: MatDialogRef<RegionModalComponent>) {}

ngOnInit(): void {
this.form = this.formBuilder.group({
countryCode:[{value:null}, Validators.required],
code:[{value:null}, Validators.required],
label:[{value:null}, Validators.required]});
this.loadOptionsForCountryCode();
this.restoreForm();
}
restoreForm(): void {
this.form.patchValue({
countryCode: this.view.form.countryCode,
code: this.view.form.code,
label: this.view.form.label
})
}

applyForm(): void {
this.view.form.countryCode = StringUtils.emptyToNull(this.form.get('countryCode').value);
this.view.form.code = StringUtils.emptyToNull(this.form.get('code').value);
this.view.form.label = StringUtils.emptyToNull(this.form.get('label').value);
}

loadOptionsForCountryCode() {
this.countryService.getOptions().subscribe((t) => {this.countryCodeOptions=t;});
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

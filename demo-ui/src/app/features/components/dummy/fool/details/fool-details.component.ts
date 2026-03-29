import { ActivatedRoute } from '@angular/router';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FoolFullView } from 'src/app/features/models/dummy/views/full/FoolFullView';
import { FoolRestClient } from 'src/app/features/services/dummy/FoolRestClient';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NavLink } from 'src/app/templates/private/models/nav-link';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { Observable } from 'rxjs';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { StringUtils } from 'src/app/core/services/StringUtils';
/**
 * auto generated details component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-fool-details',
templateUrl: './fool-details.component.html',
styleUrls: ['./fool-details.component.scss']
})
export class FoolDetailsComponent implements OnInit {

id:string;
activePath:string;
view: FoolFullView = new FoolFullView();
form: FormGroup;

constructor(private service:FoolRestClient, private route: ActivatedRoute, private formBuilder: FormBuilder, private notifications: NotificationService) {
this.id = this.route.snapshot.paramMap.get('id');
this.activePath = '/fool/' + this.id.toString();
}

ngOnInit(): void {
this.form = this.formBuilder.group({
code:[{value:null}, Validators.required],
description:[{value:null}],
longField:[{value:null}],
booleanField:[{value:null}],
doubleField:[{value:null}],
decimalField:[{value:null}],
dateField:[{value:null}],
datetimeField:[{value:null}]})
this.load();
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

load(): void {
this.service.load(this.id).subscribe((t) => {this.view=t;this.restoreForm();});
}

update(): void {
this.applyForm();
this.service.update(this.id, this.view.form).subscribe(success => {this.notifications.info("Operation completed");this.load();}, error => {this.notifications.error("Operation failed")});
}
/* Specific Code Start */
/* Specific Code End */
}

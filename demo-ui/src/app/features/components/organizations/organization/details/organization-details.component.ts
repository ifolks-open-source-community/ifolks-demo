import { ActivatedRoute } from '@angular/router';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NavLink } from 'src/app/templates/private/models/nav-link';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { Observable } from 'rxjs';
import { OrganizationFullView } from 'src/app/features/models/organizations/views/full/OrganizationFullView';
import { OrganizationRestClient } from 'src/app/features/services/organizations/OrganizationRestClient';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { StringUtils } from 'src/app/core/services/StringUtils';
/**
 * auto generated details component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-organization-details',
templateUrl: './organization-details.component.html',
styleUrls: ['./organization-details.component.scss']
})
export class OrganizationDetailsComponent implements OnInit {

id:number;
activePath:string;
view: OrganizationFullView = new OrganizationFullView();
form: FormGroup;

constructor(private service:OrganizationRestClient, private route: ActivatedRoute, private formBuilder: FormBuilder, private notifications: NotificationService) {
this.id = parseInt(this.route.snapshot.paramMap.get('id'));
this.activePath = '/organization/' + this.id.toString();
}

ngOnInit(): void {
this.form = this.formBuilder.group({
code:[{value:null}, Validators.required],
description:[{value:null}]})
this.load();
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

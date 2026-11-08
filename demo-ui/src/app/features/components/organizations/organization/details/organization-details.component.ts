import { OrganizationMenuComponent } from './../menu/organization-menu.component';
import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { Observable } from 'rxjs';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { I18nPipe } from 'src/app/core/pipes/I18nPipe';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { StringUtils } from 'src/app/core/services/StringUtils';
import { ORGANIZATION_ROLE_OPTIONS, OrganizationRole } from 'src/app/features/models/organizations/enums/OrganizationRole';
import { OrganizationFullView } from 'src/app/features/models/organizations/views/full/OrganizationFullView';
import { OrganizationRestClient } from 'src/app/features/services/organizations/OrganizationRestClient';
import { SharedModule } from 'src/app/shared/shared.module';
import { NavLink } from 'src/app/templates/private/models/nav-link';
import { PrivateTemplatesModule } from 'src/app/templates/private/templates.module';
/**
 * auto generated details component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-organization-details',
standalone: true,
imports: [CommonModule, SharedModule, PrivateTemplatesModule, RouterModule, OrganizationMenuComponent, I18nPipe],
templateUrl: './organization-details.component.html',
styleUrl: './organization-details.component.scss'
})
export class OrganizationDetailsComponent implements OnInit {

id:number;
activePath:string;
view: OrganizationFullView = new OrganizationFullView();
form: FormGroup;
readonly roleOptions = ORGANIZATION_ROLE_OPTIONS;

constructor(private service:OrganizationRestClient, private route: ActivatedRoute, private formBuilder: FormBuilder, private changeDetector: ChangeDetectorRef, private notifications: NotificationService) {
this.id = parseInt(this.route.snapshot.paramMap.get('id'));
this.activePath = '/organization/' + this.id.toString();
}

ngOnInit(): void {
this.form = this.formBuilder.group({
code:[{value:null}, Validators.required],
role:[{value:null}, Validators.required],
description:[{value:null}]})
this.load();
}
restoreForm(): void {
this.form.patchValue({
code: this.view.form.code,
role: this.view.form.role,
description: this.view.form.description
})
}

applyForm(): void {
this.view.form.code = StringUtils.emptyToNull(this.form.get('code').value);
this.view.form.role = StringUtils.emptyToNull(this.form.get('role').value);
this.view.form.description = StringUtils.emptyToNull(this.form.get('description').value);
}

load(): void {
this.service.load(this.id).subscribe((t) => {this.view=t;this.restoreForm();this.changeDetector.markForCheck();});
}

update(): void {
this.applyForm();
this.service.update(this.id, this.view.form).subscribe(success => {this.notifications.info("operation.completed");this.load();});
}
/* Specific Code Start */
/* Specific Code End */
}

import { ActivatedRoute } from '@angular/router';
import { CalendarFullView } from 'src/app/features/models/reference/time/views/full/CalendarFullView';
import { CalendarMenuComponent } from './../menu/calendar-menu.component';
import { CalendarRestClient } from 'src/app/features/services/reference/time/CalendarRestClient';
import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NavLink } from 'src/app/templates/private/models/nav-link';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { Observable } from 'rxjs';
import { PrivateTemplatesModule } from 'src/app/templates/private/templates.module';
import { RouterModule } from '@angular/router';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { SharedModule } from 'src/app/shared/shared.module';
import { StringUtils } from 'src/app/core/services/StringUtils';
/**
 * auto generated details component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-calendar-details',
standalone: true,
imports: [CommonModule, SharedModule, PrivateTemplatesModule, RouterModule, CalendarMenuComponent],
templateUrl: './calendar-details.component.html',
styleUrl: './calendar-details.component.scss'
})
export class CalendarDetailsComponent implements OnInit {

id:number;
activePath:string;
view: CalendarFullView = new CalendarFullView();
form: FormGroup;

constructor(private service:CalendarRestClient, private route: ActivatedRoute, private formBuilder: FormBuilder, private notifications: NotificationService) {
this.id = parseInt(this.route.snapshot.paramMap.get('id'));
this.activePath = '/calendar/' + this.id.toString();
}

ngOnInit(): void {
this.form = this.formBuilder.group({
code:[{value:null}, Validators.required],
label:[{value:null}, Validators.required]})
this.load();
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

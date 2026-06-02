import { ActivatedRoute } from '@angular/router';
import { CityFullView } from 'src/app/features/models/reference/localization/views/full/CityFullView';
import { CityMenuComponent } from './../menu/city-menu.component';
import { CityRestClient } from 'src/app/features/services/reference/localization/CityRestClient';
import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { CountryRestClient } from 'src/app/features/services/reference/localization/CountryRestClient';
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
selector: 'app-city-details',
standalone: true,
imports: [CommonModule, SharedModule, PrivateTemplatesModule, RouterModule, CityMenuComponent],
templateUrl: './city-details.component.html',
styleUrl: './city-details.component.scss'
})
export class CityDetailsComponent implements OnInit {

id:number;
activePath:string;
view: CityFullView = new CityFullView();
form: FormGroup;
regionCountryCodeOptions: SelectItem[];

constructor(private service:CityRestClient, private countryService:CountryRestClient, private route: ActivatedRoute, private formBuilder: FormBuilder, private notifications: NotificationService) {
this.id = parseInt(this.route.snapshot.paramMap.get('id'));
this.activePath = '/city/' + this.id.toString();
}

ngOnInit(): void {
this.form = this.formBuilder.group({
regionCountryCode:[{value:null}, Validators.required],
regionCode:[{value:null}, Validators.required],
code:[{value:null}, Validators.required],
label:[{value:null}, Validators.required]})
this.load();
}
restoreForm(): void {
this.form.patchValue({
regionCountryCode: this.view.form.regionCountryCode,
regionCode: this.view.form.regionCode,
code: this.view.form.code,
label: this.view.form.label
})
}

applyForm(): void {
this.view.form.regionCountryCode = StringUtils.emptyToNull(this.form.get('regionCountryCode').value);
this.view.form.regionCode = StringUtils.emptyToNull(this.form.get('regionCode').value);
this.view.form.code = StringUtils.emptyToNull(this.form.get('code').value);
this.view.form.label = StringUtils.emptyToNull(this.form.get('label').value);
}

load(): void {
this.service.load(this.id).subscribe((t) => {this.view=t;this.restoreForm();});
this.loadOptionsForRegionCountryCode();
}

loadOptionsForRegionCountryCode() {
this.countryService.getOptions().subscribe((t) => {this.regionCountryCodeOptions=t;});
}

update(): void {
this.applyForm();
this.service.update(this.id, this.view.form).subscribe(success => {this.notifications.info("Operation completed");this.load();}, error => {this.notifications.error("Operation failed")});
}
/* Specific Code Start */
/* Specific Code End */
}

import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { I18nPipe } from 'src/app/core/pipes/I18nPipe';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { StringUtils } from 'src/app/core/services/StringUtils';
import { FOOL_STATUS_OPTIONS } from 'src/app/features/models/dummy/enums/FoolStatus';
import { FoolFullView } from 'src/app/features/models/dummy/views/full/FoolFullView';
import { FoolRestClient } from 'src/app/features/services/dummy/FoolRestClient';
import { SharedModule } from 'src/app/shared/shared.module';
import { PrivateTemplatesModule } from 'src/app/templates/private/templates.module';
import { FoolMenuComponent } from './../menu/fool-menu.component';
/**
 * auto generated details component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
  selector: 'app-fool-details',
  standalone: true,
  imports: [CommonModule, SharedModule, PrivateTemplatesModule, RouterModule, FoolMenuComponent, I18nPipe],
  templateUrl: './fool-details.component.html',
  styleUrl: './fool-details.component.scss',
})
export class FoolDetailsComponent implements OnInit {
  id: string;
  activePath: string;
  view: FoolFullView = new FoolFullView();
  form: FormGroup;
  readonly statusOptions = FOOL_STATUS_OPTIONS;

  constructor(
    private service: FoolRestClient,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private changeDetector: ChangeDetectorRef,
    private notifications: NotificationService,
  ) {
    this.id = this.route.snapshot.paramMap.get('id');
    this.activePath = '/fool/' + this.id.toString();
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      code: [{ value: null }, Validators.required],
      label: [{ value: null }, Validators.required],
      status: [{ value: null }],
      description: [{ value: null }],
      longField: [{ value: null }],
      booleanField: [{ value: null }],
      doubleField: [{ value: null }],
      decimalField: [{ value: null }],
      dateField: [{ value: null }],
      datetimeField: [{ value: null }],
    });
    this.load();
  }
  restoreForm(): void {
    this.form.patchValue({
      code: this.view.form.code,
      label: this.view.form.label,
      status: this.view.form.status,
      description: this.view.form.description,
      longField: this.view.form.longField,
      booleanField: this.view.form.booleanField,
      doubleField: this.view.form.doubleField,
      decimalField: this.view.form.decimalField,
      dateField: this.view.form.dateField,
      datetimeField: this.view.form.datetimeField,
    });
  }

  applyForm(): void {
    this.view.form.code = StringUtils.emptyToNull(this.form.get('code').value);
    this.view.form.label = StringUtils.emptyToNull(this.form.get('label').value);
    this.view.form.status = StringUtils.emptyToNull(this.form.get('status').value);
    this.view.form.description = StringUtils.emptyToNull(this.form.get('description').value);
    this.view.form.longField = StringUtils.emptyToNull(this.form.get('longField').value);
    this.view.form.booleanField = StringUtils.stringToNullableBoolean(this.form.get('booleanField').value);
    this.view.form.doubleField = StringUtils.emptyToNull(this.form.get('doubleField').value);
    this.view.form.decimalField = StringUtils.emptyToNull(this.form.get('decimalField').value);
    this.view.form.dateField = StringUtils.emptyToNull(this.form.get('dateField').value);
    this.view.form.datetimeField = StringUtils.emptyToNull(this.form.get('datetimeField').value);
  }

  load(): void {
    this.service.load(this.id).subscribe((t) => {
      this.view = t;
      this.restoreForm();
      this.changeDetector.markForCheck();
    });
  }

  update(): void {
    this.applyForm();
    this.service.update(this.id, this.view.form).subscribe((success) => {
      this.notifications.info('operation.completed');
      this.load();
    });
  }
  /* Specific Code Start */
  /* Specific Code End */
}

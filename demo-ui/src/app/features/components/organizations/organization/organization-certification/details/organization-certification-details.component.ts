import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { I18nPipe } from 'src/app/core/pipes/I18nPipe';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { StringUtils } from 'src/app/core/services/StringUtils';
import { OrganizationCertificationFullView } from 'src/app/features/models/organizations/views/full/OrganizationCertificationFullView';
import { OrganizationRestClient } from 'src/app/features/services/organizations/OrganizationRestClient';
import { SharedModule } from 'src/app/shared/shared.module';
import { PrivateTemplatesModule } from 'src/app/templates/private/templates.module';
import { OrganizationMenuComponent } from './../../menu/organization-menu.component';
/**
 * auto generated one to one component details component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
  selector: 'app-organization-certification-details',
  standalone: true,
  imports: [CommonModule, SharedModule, PrivateTemplatesModule, RouterModule, OrganizationMenuComponent, I18nPipe],
  templateUrl: './organization-certification-details.component.html',
  styleUrl: './organization-certification-details.component.scss',
})
export class OrganizationCertificationDetailsComponent implements OnInit {
  id: number;
  activePath: string;
  view: OrganizationCertificationFullView = new OrganizationCertificationFullView();
  form: FormGroup;

  constructor(
    private service: OrganizationRestClient,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private changeDetector: ChangeDetectorRef,
    private notifications: NotificationService,
  ) {
    this.id = parseInt(this.route.snapshot.paramMap.get('id'));
    this.activePath = '/organization/' + this.id.toString() + '/organization-certification';
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      certified: [{ value: null }],
    });
    this.load();
  }
  restoreForm(): void {
    this.form.patchValue({
      certified: this.view.form.certified,
    });
  }

  applyForm(): void {
    this.view.form.certified = StringUtils.stringToStrictBoolean(this.form.get('certified').value);
  }

  load(): void {
    this.service.loadOrganizationCertification(this.id).subscribe((t) => {
      if (t) {
        this.view = t;
      } else {
        this.view = new OrganizationCertificationFullView();
      }
      this.restoreForm();
      this.changeDetector.markForCheck();
    });
  }

  save(): void {
    this.applyForm();
    this.service.saveOrganizationCertification(this.id, this.view.form).subscribe((success) => {
      this.notifications.info('operation.completed');
      this.load();
    });
  }

  update(): void {
    this.applyForm();
    this.service.updateOrganizationCertification(this.id, this.view.form).subscribe((success) => {
      this.notifications.info('operation.completed');
      this.load();
    });
  }

  saveOrUpdate(): void {
    if (this.view.id == null) {
      this.save();
    } else {
      this.update();
    }
  }

  delete(): void {
    this.service.deleteOrganizationCertification(this.id).subscribe((success) => {
      this.notifications.info('operation.completed');
      this.load();
    });
  }

  /* Specific Code Start */
  /* Specific Code End */
}

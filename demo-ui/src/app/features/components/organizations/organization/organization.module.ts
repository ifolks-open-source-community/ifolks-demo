import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { OrganizationCertificationDetailsComponent } from './organization-certification/details/organization-certification-details.component';
import { OrganizationDetailsComponent } from './details/organization-details.component';
import { OrganizationListComponent } from './list/organization-list.component';
import { OrganizationMenuComponent } from './menu/organization-menu.component';
import { OrganizationModalComponent } from './modal/organization-modal.component';
import { OrganizationRoutingModule } from './organization-routing.module';
import { PrivateTemplatesModule } from 'src/app/templates/private/templates.module';
import { SharedModule } from 'src/app/shared/shared.module';
/**
 * auto generated list module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@NgModule({
declarations: [OrganizationListComponent,OrganizationDetailsComponent, OrganizationModalComponent, OrganizationMenuComponent, OrganizationCertificationDetailsComponent],
imports: [CommonModule, SharedModule, OrganizationRoutingModule, PrivateTemplatesModule]
})
export class OrganizationModule { }

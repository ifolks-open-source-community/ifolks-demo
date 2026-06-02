import { OrganizationCertificationDetailsComponent } from './organization-certification/details/organization-certification-details.component';
import { OrganizationDetailsComponent } from './details/organization-details.component';
import { OrganizationListComponent } from './list/organization-list.component';
import { Routes } from '@angular/router';
/**
 * auto generated list routes ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

export const routes: Routes = [
{path: 'list', component: OrganizationListComponent }
,{path: ':id', component: OrganizationDetailsComponent }
,{path: ':id/organization-certification', component: OrganizationCertificationDetailsComponent }
];

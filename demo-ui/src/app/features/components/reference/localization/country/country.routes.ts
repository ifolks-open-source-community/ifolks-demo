import { CountryDetailsComponent } from './details/country-details.component';
import { CountryListComponent } from './list/country-list.component';
import { RegionListComponent } from './region/list/region-list.component';
import { Routes } from '@angular/router';
/**
 * auto generated list routes ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

export const routes: Routes = [
{path: 'list', component: CountryListComponent }
,{path: ':id', component: CountryDetailsComponent }
,{path: ':id/region/list', component: RegionListComponent }
];

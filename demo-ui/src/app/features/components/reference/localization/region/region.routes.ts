import { CityListComponent } from './city/list/city-list.component';
import { RegionDetailsComponent } from './details/region-details.component';
import { RegionListComponent } from './list/region-list.component';
import { Routes } from '@angular/router';
/**
 * auto generated list routes ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

export const routes: Routes = [
{path: 'list', component: RegionListComponent }
,{path: ':id', component: RegionDetailsComponent }
,{path: ':id/city/list', component: CityListComponent }
];

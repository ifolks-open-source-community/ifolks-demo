import { CityDetailsComponent } from './details/city-details.component';
import { CityListComponent } from './list/city-list.component';
import { Routes } from '@angular/router';
/**
 * auto generated list routes ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

export const routes: Routes = [
{path: 'list', component: CityListComponent }
,{path: ':id', component: CityDetailsComponent }
];

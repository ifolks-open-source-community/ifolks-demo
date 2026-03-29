import { CityListComponent } from './city/list/city-list.component';
import { NgModule } from '@angular/core';
import { RegionDetailsComponent } from './details/region-details.component';
import { RegionListComponent } from './list/region-list.component';
import { RouterModule, Routes } from '@angular/router';
/**
 * auto generated list routing module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

const routes: Routes = [
{path: 'list', component: RegionListComponent }
,{path: ':id', component: RegionDetailsComponent }
,{path: ':id/city/list', component: CityListComponent }
];

@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})
export class RegionRoutingModule { }

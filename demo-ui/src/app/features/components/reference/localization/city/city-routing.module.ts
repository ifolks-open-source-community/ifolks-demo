import { CityDetailsComponent } from './details/city-details.component';
import { CityListComponent } from './list/city-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
/**
 * auto generated list routing module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

const routes: Routes = [
{path: 'list', component: CityListComponent }
,{path: ':id', component: CityDetailsComponent }
];

@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})
export class CityRoutingModule { }

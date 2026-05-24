import { FoolDetailsComponent } from './details/fool-details.component';
import { FoolListComponent } from './list/fool-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
/**
 * auto generated list routing module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

const routes: Routes = [
{path: 'list', component: FoolListComponent }
,{path: ':id', component: FoolDetailsComponent }
];

@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})
export class FoolRoutingModule { }

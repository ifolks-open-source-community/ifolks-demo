import { FoolDetailsComponent } from './details/fool-details.component';
import { FoolListComponent } from './list/fool-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StupidListComponent } from './stupid/list/stupid-list.component';
/**
 * auto generated list routing module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

const routes: Routes = [
{path: 'list', component: FoolListComponent }
,{path: ':id', component: FoolDetailsComponent }
,{path: ':id/stupid/list', component: StupidListComponent }
];

@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})
export class FoolRoutingModule { }

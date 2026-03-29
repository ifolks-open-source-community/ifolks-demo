import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StupidDetailsComponent } from './details/stupid-details.component';
import { StupidListComponent } from './list/stupid-list.component';
/**
 * auto generated list routing module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

const routes: Routes = [
{path: 'list', component: StupidListComponent }
,{path: ':id', component: StupidDetailsComponent }
];

@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})
export class StupidRoutingModule { }

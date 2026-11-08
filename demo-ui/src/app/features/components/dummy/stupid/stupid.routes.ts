import { StupidDetailsComponent } from './details/stupid-details.component';
import { StupidListComponent } from './list/stupid-list.component';
import { Routes } from '@angular/router';
/**
 * auto generated list routes ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

export const routes: Routes = [
{path: 'list', component: StupidListComponent }
,{path: ':id', component: StupidDetailsComponent }
];

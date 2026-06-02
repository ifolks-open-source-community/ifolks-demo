import { FoolDetailsComponent } from './details/fool-details.component';
import { FoolListComponent } from './list/fool-list.component';
import { Routes } from '@angular/router';
/**
 * auto generated list routes ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

export const routes: Routes = [
{path: 'list', component: FoolListComponent }
,{path: ':id', component: FoolDetailsComponent }
];

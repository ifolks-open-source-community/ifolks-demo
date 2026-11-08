import { Routes } from '@angular/router';
import { FoolDetailsComponent } from './details/fool-details.component';
import { FoolListComponent } from './list/fool-list.component';
/**
 * auto generated list routes ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

export const routes: Routes = [
  { path: 'list', component: FoolListComponent },
  { path: ':id', component: FoolDetailsComponent },
];

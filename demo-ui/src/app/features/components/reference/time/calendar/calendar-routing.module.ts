import { CalendarDayOffListComponent } from './calendar-day-off/list/calendar-day-off-list.component';
import { CalendarDetailsComponent } from './details/calendar-details.component';
import { CalendarListComponent } from './list/calendar-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
/**
 * auto generated list routing module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

const routes: Routes = [
{path: 'list', component: CalendarListComponent }
,{path: ':id', component: CalendarDetailsComponent }
,{path: ':id/calendar-day-off/list', component: CalendarDayOffListComponent }
];

@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})
export class CalendarRoutingModule { }

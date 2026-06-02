import { CalendarDayOffListComponent } from './calendar-day-off/list/calendar-day-off-list.component';
import { CalendarDetailsComponent } from './details/calendar-details.component';
import { CalendarListComponent } from './list/calendar-list.component';
import { Routes } from '@angular/router';
/**
 * auto generated list routes ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

export const routes: Routes = [
{path: 'list', component: CalendarListComponent }
,{path: ':id', component: CalendarDetailsComponent }
,{path: ':id/calendar-day-off/list', component: CalendarDayOffListComponent }
];

import { CalendarDayOffListComponent } from './calendar-day-off/list/calendar-day-off-list.component';
import { CalendarDayOffModalComponent } from './calendar-day-off/modal/calendar-day-off-modal.component';
import { CalendarDetailsComponent } from './details/calendar-details.component';
import { CalendarListComponent } from './list/calendar-list.component';
import { CalendarMenuComponent } from './menu/calendar-menu.component';
import { CalendarModalComponent } from './modal/calendar-modal.component';
import { CalendarRoutingModule } from './calendar-routing.module';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { PrivateTemplatesModule } from 'src/app/templates/private/templates.module';
import { SharedModule } from 'src/app/shared/shared.module';
/**
 * auto generated list module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@NgModule({
declarations: [CalendarListComponent,CalendarDetailsComponent, CalendarModalComponent, CalendarMenuComponent, CalendarDayOffListComponent, CalendarDayOffModalComponent],
imports: [CommonModule, SharedModule, CalendarRoutingModule, PrivateTemplatesModule]
})
export class CalendarModule { }

import { ActivatedRoute } from '@angular/router';
import { CalendarDayOffBasicView } from 'src/app/features/models/reference/time/views/basic/CalendarDayOffBasicView';
import { CalendarDayOffFilter } from 'src/app/features/models/reference/time/filters/CalendarDayOffFilter';
import { CalendarDayOffForm } from 'src/app/features/models/reference/time/forms/CalendarDayOffForm';
import { CalendarDayOffFullView } from 'src/app/features/models/reference/time/views/full/CalendarDayOffFullView';
import { CalendarDayOffModalComponent } from './../modal/calendar-day-off-modal.component';
import { CalendarDayOffSorting } from 'src/app/features/models/reference/time/sortings/CalendarDayOffSorting';
import { CalendarRestClient } from 'src/app/features/services/reference/time/CalendarRestClient';
import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { ConfirmationModalComponent } from 'src/app/core/components/confirmation-modal/confirmation-modal.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { NavLink } from 'src/app/templates/private/models/nav-link';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { ScrollForm } from "src/app/core/models/ScrollForm";
import { ScrollView } from "src/app/core/models/ScrollView";
import { SelectItem } from "src/app/core/models/SelectItem";
import { StringUtils } from 'src/app/core/services/StringUtils';
/**
 * auto generated one to many component list component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-calendar-day-off-list',
templateUrl: './calendar-day-off-list.component.html',
styleUrls: ['./calendar-day-off-list.component.scss']
})
export class CalendarDayOffListComponent implements OnInit, AfterViewInit {

id:number;
activePath:string;
scrollForm: ScrollForm<CalendarDayOffFilter, CalendarDayOffSorting> = new ScrollForm();
scrollView: ScrollView<CalendarDayOffBasicView> = new ScrollView();
dataSource:MatTableDataSource<CalendarDayOffBasicView>;
@ViewChild(MatPaginator) paginator: MatPaginator;
@ViewChild(MatSort) sort: MatSort
pageSizeOptions: number[] = [10, 20, 50, 100];
displayedColumns: string[] = ['dayOffDate','dayOffLabel','Actions'];
filter: FormGroup;

constructor(private service:CalendarRestClient, private route: ActivatedRoute, private formBuilder: FormBuilder, private dialog: MatDialog, private notifications: NotificationService) {
this.id = parseInt(this.route.snapshot.paramMap.get('id'));
this.activePath = '/calendar/' + this.id.toString() + '/calendar-day-off/list';
}
ngOnInit(): void {
this.filter = this.formBuilder.group({
dayOffDateMinValue:[null],
dayOffDateMaxValue:[null],
dayOffLabel:[null]})
this.reset();
}

ngAfterViewInit(): void {
this.paginator.page.subscribe(
(event) => {
this.scrollForm.page=event.pageIndex+1;
this.scrollForm.elementsPerPage=event.pageSize;
this.refresh();
});

this.sort.sortChange.subscribe(
(event) => {
this.scrollForm.sorting = new CalendarDayOffSorting();
switch (this.sort.active) {
case 'dayOffDate': this.scrollForm.sorting.dayOffDateOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'dayOffLabel': this.scrollForm.sorting.dayOffLabelOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
}
this.refresh();
});

this.filter.controls['dayOffDateMinValue'].valueChanges.subscribe(value=>{
this.scrollForm.filter.dayOffDateMinValue=value;
this.refresh();
});
this.filter.controls['dayOffDateMaxValue'].valueChanges.subscribe(value=>{
this.scrollForm.filter.dayOffDateMaxValue=value;
this.refresh();
});
this.filter.controls['dayOffLabel'].valueChanges.subscribe(value=>{
this.scrollForm.filter.dayOffLabel=value;
this.refresh();
});
}

refresh(): void {
this.service.scrollCalendarDayOff(this.id, this.scrollForm).subscribe((t) => {
this.scrollView=t;
this.dataSource = new MatTableDataSource(this.scrollView.elements);
});
}

reset(): void {
this.scrollForm = new ScrollForm();
this.scrollForm.filter = new CalendarDayOffFilter();
this.scrollForm.sorting = new CalendarDayOffSorting();
this.scrollForm.page=1;
this.scrollForm.elementsPerPage=10;
this.filter.patchValue({
dayOffDateMinValue: [null],
dayOffDateMaxValue: [null],
dayOffLabel: [null]
})
this.refresh();
}

create(): void {
let ref = this.dialog.open(CalendarDayOffModalComponent);
ref.componentInstance.view = new CalendarDayOffFullView();
ref.componentInstance.parentId = this.id;
ref.afterClosed().subscribe(result => {this.refresh();});
}

edit(id: number): void {
this.service.loadCalendarDayOff(id).subscribe((t) => {
let ref = this.dialog.open(CalendarDayOffModalComponent);
ref.componentInstance.view = t;
ref.afterClosed().subscribe(result => {this.refresh();});
});
}

delete(id: number): void {
this.dialog.open(ConfirmationModalComponent).afterClosed().subscribe(result => {
if (result) {
this.service.deleteCalendarDayOff(id).subscribe(success => {this.notifications.info("Operation completed");this.refresh()}, error => {this.notifications.error("Operation failed")});
}
});
}

/* Specific Code Start */
/* Specific Code End */
}

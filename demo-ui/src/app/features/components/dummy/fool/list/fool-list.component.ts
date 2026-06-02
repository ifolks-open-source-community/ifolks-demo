import { CommonModule } from '@angular/common';
import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { ConfirmationModalComponent } from 'src/app/core/components/confirmation-modal/confirmation-modal.component';
import { FoolBasicView } from 'src/app/features/models/dummy/views/basic/FoolBasicView';
import { FoolFilter } from 'src/app/features/models/dummy/filters/FoolFilter';
import { FoolForm } from 'src/app/features/models/dummy/forms/FoolForm';
import { FoolFullView } from 'src/app/features/models/dummy/views/full/FoolFullView';
import { FoolModalComponent } from './../modal/fool-modal.component';
import { FoolRestClient } from 'src/app/features/services/dummy/FoolRestClient';
import { FoolSorting } from 'src/app/features/models/dummy/sortings/FoolSorting';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { PrivateTemplatesModule } from 'src/app/templates/private/templates.module';
import { ScrollForm } from "src/app/core/models/ScrollForm";
import { ScrollView } from "src/app/core/models/ScrollView";
import { SelectItem } from "src/app/core/models/SelectItem";
import { SharedModule } from 'src/app/shared/shared.module';
import { StringUtils } from 'src/app/core/services/StringUtils';
/**
 * auto generated list component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-fool-list',
standalone: true,
imports: [CommonModule, SharedModule, PrivateTemplatesModule],
templateUrl: './fool-list.component.html',
styleUrl: './fool-list.component.scss'
})
export class FoolListComponent implements OnInit, AfterViewInit {

scrollForm: ScrollForm<FoolFilter, FoolSorting> = new ScrollForm();
scrollView: ScrollView<FoolBasicView> = new ScrollView();
dataSource:MatTableDataSource<FoolBasicView>;
@ViewChild(MatPaginator) paginator: MatPaginator;
@ViewChild(MatSort) sort: MatSort
pageSizeOptions: number[] = [10, 20, 50, 100];
displayedColumns: string[] = ['code','description','longField','booleanField','doubleField','decimalField','dateField','datetimeField','Actions'];
filter: FormGroup;

constructor(private service:FoolRestClient, private formBuilder: FormBuilder, private dialog: MatDialog, private notifications: NotificationService) { }
ngOnInit(): void {
this.filter = this.formBuilder.group({
code:[null],
description:[null],
booleanField:[null],
dateFieldMinValue:[null],
dateFieldMaxValue:[null],
datetimeFieldMinValue:[null],
datetimeFieldMaxValue:[null]})
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
this.scrollForm.sorting = new FoolSorting();
switch (this.sort.active) {
case 'code': this.scrollForm.sorting.codeOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'description': this.scrollForm.sorting.descriptionOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'longField': this.scrollForm.sorting.longFieldOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'booleanField': this.scrollForm.sorting.booleanFieldOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'doubleField': this.scrollForm.sorting.doubleFieldOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'decimalField': this.scrollForm.sorting.decimalFieldOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'dateField': this.scrollForm.sorting.dateFieldOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'datetimeField': this.scrollForm.sorting.datetimeFieldOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
}
this.refresh();
});

this.filter.controls['code'].valueChanges.subscribe(value=>{
this.scrollForm.filter.code=value;
this.refresh();
});
this.filter.controls['description'].valueChanges.subscribe(value=>{
this.scrollForm.filter.description=value;
this.refresh();
});
this.filter.controls['booleanField'].valueChanges.subscribe(value=>{
this.scrollForm.filter.booleanField=value;
this.refresh();
});
this.filter.controls['dateFieldMinValue'].valueChanges.subscribe(value=>{
this.scrollForm.filter.dateFieldMinValue=value;
this.refresh();
});
this.filter.controls['dateFieldMaxValue'].valueChanges.subscribe(value=>{
this.scrollForm.filter.dateFieldMaxValue=value;
this.refresh();
});
this.filter.controls['datetimeFieldMinValue'].valueChanges.subscribe(value=>{
this.scrollForm.filter.datetimeFieldMinValue=value;
this.refresh();
});
this.filter.controls['datetimeFieldMaxValue'].valueChanges.subscribe(value=>{
this.scrollForm.filter.datetimeFieldMaxValue=value;
this.refresh();
});
}

refresh(): void {
this.service.scroll(this.scrollForm).subscribe((t) => {
this.scrollView=t;
this.dataSource = new MatTableDataSource(this.scrollView.elements);
});
}

reset(): void {
this.scrollForm = new ScrollForm();
this.scrollForm.filter = new FoolFilter();
this.scrollForm.sorting = new FoolSorting();
this.scrollForm.page=1;
this.scrollForm.elementsPerPage=10;
this.filter.patchValue({
code: [null],
description: [null],
booleanField: [null],
dateFieldMinValue: [null],
dateFieldMaxValue: [null],
datetimeFieldMinValue: [null],
datetimeFieldMaxValue: [null]
})
this.refresh();
}

create(): void {
let ref = this.dialog.open(FoolModalComponent);
ref.componentInstance.view = new FoolFullView();
ref.afterClosed().subscribe(result => {this.refresh();});
}

edit(id: string): void {
this.service.load(id).subscribe((t) => {
let ref = this.dialog.open(FoolModalComponent);
ref.componentInstance.view = t;
ref.afterClosed().subscribe(result => {this.refresh();});
});
}

delete(id: string): void {
this.dialog.open(ConfirmationModalComponent).afterClosed().subscribe(result => {
if (result) {
this.service.delete(id).subscribe(success => {this.notifications.info("Operation completed");this.refresh()}, error => {this.notifications.error("Operation failed")});
}
});
}

/* Specific Code Start */
/* Specific Code End */
}

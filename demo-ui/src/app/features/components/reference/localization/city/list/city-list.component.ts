import { CityBasicView } from 'src/app/features/models/reference/localization/views/basic/CityBasicView';
import { CityFilter } from 'src/app/features/models/reference/localization/filters/CityFilter';
import { CityForm } from 'src/app/features/models/reference/localization/forms/CityForm';
import { CityFullView } from 'src/app/features/models/reference/localization/views/full/CityFullView';
import { CityModalComponent } from './../modal/city-modal.component';
import { CityRestClient } from 'src/app/features/services/reference/localization/CityRestClient';
import { CitySorting } from 'src/app/features/models/reference/localization/sortings/CitySorting';
import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { ConfirmationModalComponent } from 'src/app/core/components/confirmation-modal/confirmation-modal.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { ScrollForm } from "src/app/core/models/ScrollForm";
import { ScrollView } from "src/app/core/models/ScrollView";
import { SelectItem } from "src/app/core/models/SelectItem";
import { StringUtils } from 'src/app/core/services/StringUtils';
/**
 * auto generated list component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-city-list',
templateUrl: './city-list.component.html',
styleUrls: ['./city-list.component.scss']
})
export class CityListComponent implements OnInit, AfterViewInit {

scrollForm: ScrollForm<CityFilter, CitySorting> = new ScrollForm();
scrollView: ScrollView<CityBasicView> = new ScrollView();
dataSource:MatTableDataSource<CityBasicView>;
@ViewChild(MatPaginator) paginator: MatPaginator;
@ViewChild(MatSort) sort: MatSort
pageSizeOptions: number[] = [10, 20, 50, 100];
displayedColumns: string[] = ['regionCountryCode','regionCode','code','label','Actions'];
filter: FormGroup;

constructor(private service:CityRestClient, private formBuilder: FormBuilder, private dialog: MatDialog, private notifications: NotificationService) { }
ngOnInit(): void {
this.filter = this.formBuilder.group({
regionCountryCode:[null],
regionCode:[null],
code:[null],
label:[null]})
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
this.scrollForm.sorting = new CitySorting();
switch (this.sort.active) {
case 'regionCountryCode': this.scrollForm.sorting.regionCountryCodeOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'regionCode': this.scrollForm.sorting.regionCodeOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'code': this.scrollForm.sorting.codeOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'label': this.scrollForm.sorting.labelOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
}
this.refresh();
});

this.filter.controls['regionCountryCode'].valueChanges.subscribe(value=>{
this.scrollForm.filter.regionCountryCode=value;
this.refresh();
});
this.filter.controls['regionCode'].valueChanges.subscribe(value=>{
this.scrollForm.filter.regionCode=value;
this.refresh();
});
this.filter.controls['code'].valueChanges.subscribe(value=>{
this.scrollForm.filter.code=value;
this.refresh();
});
this.filter.controls['label'].valueChanges.subscribe(value=>{
this.scrollForm.filter.label=value;
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
this.scrollForm.filter = new CityFilter();
this.scrollForm.sorting = new CitySorting();
this.scrollForm.page=1;
this.scrollForm.elementsPerPage=10;
this.filter.patchValue({
regionCountryCode: [null],
regionCode: [null],
code: [null],
label: [null]
})
this.refresh();
}

create(): void {
let ref = this.dialog.open(CityModalComponent);
ref.componentInstance.view = new CityFullView();
ref.afterClosed().subscribe(result => {this.refresh();});
}

edit(id: number): void {
this.service.load(id).subscribe((t) => {
let ref = this.dialog.open(CityModalComponent);
ref.componentInstance.view = t;
ref.afterClosed().subscribe(result => {this.refresh();});
});
}

delete(id: number): void {
this.dialog.open(ConfirmationModalComponent).afterClosed().subscribe(result => {
if (result) {
this.service.delete(id).subscribe(success => {this.notifications.info("Operation completed");this.refresh()}, error => {this.notifications.error("Operation failed")});
}
});
}

/* Specific Code Start */
/* Specific Code End */
}

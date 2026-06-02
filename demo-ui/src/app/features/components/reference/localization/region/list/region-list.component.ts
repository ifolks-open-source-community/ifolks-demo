import { CommonModule } from '@angular/common';
import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { ConfirmationModalComponent } from 'src/app/core/components/confirmation-modal/confirmation-modal.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { PrivateTemplatesModule } from 'src/app/templates/private/templates.module';
import { RegionBasicView } from 'src/app/features/models/reference/localization/views/basic/RegionBasicView';
import { RegionFilter } from 'src/app/features/models/reference/localization/filters/RegionFilter';
import { RegionForm } from 'src/app/features/models/reference/localization/forms/RegionForm';
import { RegionFullView } from 'src/app/features/models/reference/localization/views/full/RegionFullView';
import { RegionModalComponent } from './../modal/region-modal.component';
import { RegionRestClient } from 'src/app/features/services/reference/localization/RegionRestClient';
import { RegionSorting } from 'src/app/features/models/reference/localization/sortings/RegionSorting';
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
selector: 'app-region-list',
standalone: true,
imports: [CommonModule, SharedModule, PrivateTemplatesModule],
templateUrl: './region-list.component.html',
styleUrl: './region-list.component.scss'
})
export class RegionListComponent implements OnInit, AfterViewInit {

scrollForm: ScrollForm<RegionFilter, RegionSorting> = new ScrollForm();
scrollView: ScrollView<RegionBasicView> = new ScrollView();
dataSource:MatTableDataSource<RegionBasicView>;
@ViewChild(MatPaginator) paginator: MatPaginator;
@ViewChild(MatSort) sort: MatSort
pageSizeOptions: number[] = [10, 20, 50, 100];
displayedColumns: string[] = ['countryCode','code','label','Actions'];
filter: FormGroup;

constructor(private service:RegionRestClient, private formBuilder: FormBuilder, private dialog: MatDialog, private notifications: NotificationService) { }
ngOnInit(): void {
this.filter = this.formBuilder.group({
countryCode:[null],
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
this.scrollForm.sorting = new RegionSorting();
switch (this.sort.active) {
case 'countryCode': this.scrollForm.sorting.countryCodeOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'code': this.scrollForm.sorting.codeOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'label': this.scrollForm.sorting.labelOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
}
this.refresh();
});

this.filter.controls['countryCode'].valueChanges.subscribe(value=>{
this.scrollForm.filter.countryCode=value;
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
this.scrollForm.filter = new RegionFilter();
this.scrollForm.sorting = new RegionSorting();
this.scrollForm.page=1;
this.scrollForm.elementsPerPage=10;
this.filter.patchValue({
countryCode: [null],
code: [null],
label: [null]
})
this.refresh();
}

create(): void {
let ref = this.dialog.open(RegionModalComponent);
ref.componentInstance.view = new RegionFullView();
ref.afterClosed().subscribe(result => {this.refresh();});
}

edit(id: number): void {
this.service.load(id).subscribe((t) => {
let ref = this.dialog.open(RegionModalComponent);
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

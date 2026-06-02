import { CommonModule } from '@angular/common';
import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { ConfirmationModalComponent } from 'src/app/core/components/confirmation-modal/confirmation-modal.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { OrganizationBasicView } from 'src/app/features/models/organizations/views/basic/OrganizationBasicView';
import { OrganizationFilter } from 'src/app/features/models/organizations/filters/OrganizationFilter';
import { OrganizationForm } from 'src/app/features/models/organizations/forms/OrganizationForm';
import { OrganizationFullView } from 'src/app/features/models/organizations/views/full/OrganizationFullView';
import { OrganizationModalComponent } from './../modal/organization-modal.component';
import { OrganizationRestClient } from 'src/app/features/services/organizations/OrganizationRestClient';
import { OrganizationSorting } from 'src/app/features/models/organizations/sortings/OrganizationSorting';
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
selector: 'app-organization-list',
standalone: true,
imports: [CommonModule, SharedModule, PrivateTemplatesModule],
templateUrl: './organization-list.component.html',
styleUrl: './organization-list.component.scss'
})
export class OrganizationListComponent implements OnInit, AfterViewInit {

scrollForm: ScrollForm<OrganizationFilter, OrganizationSorting> = new ScrollForm();
scrollView: ScrollView<OrganizationBasicView> = new ScrollView();
dataSource:MatTableDataSource<OrganizationBasicView>;
@ViewChild(MatPaginator) paginator: MatPaginator;
@ViewChild(MatSort) sort: MatSort
pageSizeOptions: number[] = [10, 20, 50, 100];
displayedColumns: string[] = ['code','description','Actions'];
filter: FormGroup;

constructor(private service:OrganizationRestClient, private formBuilder: FormBuilder, private dialog: MatDialog, private notifications: NotificationService) { }
ngOnInit(): void {
this.filter = this.formBuilder.group({
code:[null],
description:[null]})
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
this.scrollForm.sorting = new OrganizationSorting();
switch (this.sort.active) {
case 'code': this.scrollForm.sorting.codeOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'description': this.scrollForm.sorting.descriptionOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
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
}

refresh(): void {
this.service.scroll(this.scrollForm).subscribe((t) => {
this.scrollView=t;
this.dataSource = new MatTableDataSource(this.scrollView.elements);
});
}

reset(): void {
this.scrollForm = new ScrollForm();
this.scrollForm.filter = new OrganizationFilter();
this.scrollForm.sorting = new OrganizationSorting();
this.scrollForm.page=1;
this.scrollForm.elementsPerPage=10;
this.filter.patchValue({
code: [null],
description: [null]
})
this.refresh();
}

create(): void {
let ref = this.dialog.open(OrganizationModalComponent);
ref.componentInstance.view = new OrganizationFullView();
ref.afterClosed().subscribe(result => {this.refresh();});
}

edit(id: number): void {
this.service.load(id).subscribe((t) => {
let ref = this.dialog.open(OrganizationModalComponent);
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

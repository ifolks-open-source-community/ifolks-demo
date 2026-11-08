import { OrganizationModalComponent } from './../modal/organization-modal.component';
import { CommonModule } from '@angular/common';
import { AfterViewInit, ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { ConfirmationModalComponent } from 'src/app/core/components/confirmation-modal/confirmation-modal.component';
import { ScrollForm } from 'src/app/core/models/ScrollForm';
import { ScrollView } from 'src/app/core/models/ScrollView';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { I18nPipe } from 'src/app/core/pipes/I18nPipe';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { StringUtils } from 'src/app/core/services/StringUtils';
import { ORGANIZATION_ROLE_OPTIONS, OrganizationRole } from 'src/app/features/models/organizations/enums/OrganizationRole';
import { OrganizationFilter } from 'src/app/features/models/organizations/filters/OrganizationFilter';
import { OrganizationForm } from 'src/app/features/models/organizations/forms/OrganizationForm';
import { OrganizationSorting } from 'src/app/features/models/organizations/sortings/OrganizationSorting';
import { OrganizationBasicView } from 'src/app/features/models/organizations/views/basic/OrganizationBasicView';
import { OrganizationFullView } from 'src/app/features/models/organizations/views/full/OrganizationFullView';
import { OrganizationRestClient } from 'src/app/features/services/organizations/OrganizationRestClient';
import { SharedModule } from 'src/app/shared/shared.module';
import { PrivateTemplatesModule } from 'src/app/templates/private/templates.module';
/**
 * auto generated list component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-organization-list',
standalone: true,
imports: [CommonModule, SharedModule, PrivateTemplatesModule, I18nPipe],
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
displayedColumns: string[] = ['code','role','description','Actions'];
filter: FormGroup;
readonly roleOptions = ORGANIZATION_ROLE_OPTIONS;
private refreshSubscription: Subscription;

constructor(private service:OrganizationRestClient, private formBuilder: FormBuilder, private dialog: MatDialog, private notifications: NotificationService, private changeDetector: ChangeDetectorRef) { }
ngOnInit(): void {
this.filter = this.formBuilder.group({
code:[null],
role:[null],
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
case 'role': this.scrollForm.sorting.roleOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
case 'description': this.scrollForm.sorting.descriptionOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());break;
}
this.refresh();
});

this.filter.controls['code'].valueChanges.subscribe(value=>{
this.scrollForm.filter.code=value;
this.refresh();
});
this.filter.controls['role'].valueChanges.subscribe(value=>{
this.scrollForm.filter.role=value;
this.refresh();
});
this.filter.controls['description'].valueChanges.subscribe(value=>{
this.scrollForm.filter.description=value;
this.refresh();
});
}

refresh(): void {
this.refreshSubscription?.unsubscribe();
this.refreshSubscription = this.service.scroll(this.scrollForm).subscribe((t) => {
this.scrollView=t;
this.dataSource = new MatTableDataSource(this.scrollView.elements);
this.changeDetector.markForCheck();
});
}

reset(): void {
this.scrollForm = new ScrollForm();
this.scrollForm.filter = new OrganizationFilter();
this.scrollForm.sorting = new OrganizationSorting();
this.scrollForm.page=1;
this.scrollForm.elementsPerPage=10;
this.filter.patchValue({
code: null,
role: null,
description: null
}, {emitEvent: false});
this.refresh();
}

create(): void {
let ref = this.dialog.open(OrganizationModalComponent);
ref.componentInstance.view = new OrganizationFullView();
ref.beforeClosed().subscribe(result => {if (result) {this.refresh();}});
}

edit(id: number): void {
this.service.load(id).subscribe((t) => {
let ref = this.dialog.open(OrganizationModalComponent);
ref.componentInstance.view = t;
ref.beforeClosed().subscribe(result => {if (result) {this.refresh();}});
});
}

delete(id: number): void {
this.dialog.open(ConfirmationModalComponent).beforeClosed().subscribe(result => {
if (result) {
this.service.delete(id).subscribe(success => {this.notifications.info("operation.completed");this.refresh();});
}
});
}

/* Specific Code Start */
/* Specific Code End */
}

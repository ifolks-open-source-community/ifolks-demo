import { CommonModule } from '@angular/common';
import { AfterViewInit, ChangeDetectorRef, Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { Subscription } from 'rxjs';
import { ConfirmationModalComponent } from 'src/app/core/components/confirmation-modal/confirmation-modal.component';
import { ScrollForm } from 'src/app/core/models/ScrollForm';
import { ScrollView } from 'src/app/core/models/ScrollView';
import { I18nPipe } from 'src/app/core/pipes/I18nPipe';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { StringUtils } from 'src/app/core/services/StringUtils';
import { CityFilter } from 'src/app/features/models/reference/localization/filters/CityFilter';
import { CitySorting } from 'src/app/features/models/reference/localization/sortings/CitySorting';
import { CityBasicView } from 'src/app/features/models/reference/localization/views/basic/CityBasicView';
import { CityFullView } from 'src/app/features/models/reference/localization/views/full/CityFullView';
import { CityRestClient } from 'src/app/features/services/reference/localization/CityRestClient';
import { SharedModule } from 'src/app/shared/shared.module';
import { PrivateTemplatesModule } from 'src/app/templates/private/templates.module';
import { RegionMenuComponent } from './../../menu/region-menu.component';
import { CityModalComponent } from './../modal/city-modal.component';
/**
 * auto generated one to many list component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
  selector: 'app-city-list',
  standalone: true,
  imports: [CommonModule, SharedModule, PrivateTemplatesModule, RouterModule, RegionMenuComponent, I18nPipe],
  templateUrl: './city-list.component.html',
  styleUrl: './city-list.component.scss',
})
export class CityListComponent implements OnInit, AfterViewInit {
  id: number;
  activePath: string;
  scrollForm: ScrollForm<CityFilter, CitySorting> = new ScrollForm();
  scrollView: ScrollView<CityBasicView> = new ScrollView();
  dataSource: MatTableDataSource<CityBasicView>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  pageSizeOptions: number[] = [10, 20, 50, 100];
  displayedColumns: string[] = ['code', 'label', 'Actions'];
  filter: FormGroup;
  private refreshSubscription: Subscription;

  constructor(
    private service: CityRestClient,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private dialog: MatDialog,
    private notifications: NotificationService,
    private changeDetector: ChangeDetectorRef,
  ) {
    this.id = parseInt(this.route.snapshot.paramMap.get('id'));
    this.activePath = '/region/' + this.id.toString() + '/city/list';
  }
  ngOnInit(): void {
    this.filter = this.formBuilder.group({
      code: [null],
      label: [null],
    });
    this.reset();
  }

  ngAfterViewInit(): void {
    this.paginator.page.subscribe((event) => {
      this.scrollForm.page = event.pageIndex + 1;
      this.scrollForm.elementsPerPage = event.pageSize;
      this.refresh();
    });

    this.sort.sortChange.subscribe((event) => {
      this.scrollForm.sorting = new CitySorting();
      switch (this.sort.active) {
        case 'code':
          this.scrollForm.sorting.codeOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());
          break;
        case 'label':
          this.scrollForm.sorting.labelOrderType = StringUtils.emptyToNull(this.sort.direction.toUpperCase());
          break;
      }
      this.refresh();
    });

    this.filter.controls['code'].valueChanges.subscribe((value) => {
      this.scrollForm.filter.code = value;
      this.refresh();
    });
    this.filter.controls['label'].valueChanges.subscribe((value) => {
      this.scrollForm.filter.label = value;
      this.refresh();
    });
  }

  refresh(): void {
    this.refreshSubscription?.unsubscribe();
    this.refreshSubscription = this.service.scrollFromRegion(this.id, this.scrollForm).subscribe((t) => {
      this.scrollView = t;
      this.dataSource = new MatTableDataSource(this.scrollView.elements);
      this.changeDetector.markForCheck();
    });
  }

  reset(): void {
    this.scrollForm = new ScrollForm();
    this.scrollForm.filter = new CityFilter();
    this.scrollForm.sorting = new CitySorting();
    this.scrollForm.page = 1;
    this.scrollForm.elementsPerPage = 10;
    this.filter.patchValue(
      {
        code: null,
        label: null,
      },
      { emitEvent: false },
    );
    this.refresh();
  }

  create(): void {
    let ref = this.dialog.open(CityModalComponent);
    ref.componentInstance.view = new CityFullView();
    ref.componentInstance.parentId = this.id;
    ref.beforeClosed().subscribe((result) => {
      if (result) {
        this.refresh();
      }
    });
  }

  edit(id: number): void {
    this.service.load(id).subscribe((t) => {
      let ref = this.dialog.open(CityModalComponent);
      ref.componentInstance.view = t;
      ref.beforeClosed().subscribe((result) => {
        if (result) {
          this.refresh();
        }
      });
    });
  }

  delete(id: number): void {
    this.dialog
      .open(ConfirmationModalComponent)
      .beforeClosed()
      .subscribe((result) => {
        if (result) {
          this.service.delete(id).subscribe((success) => {
            this.notifications.info('operation.completed');
            this.refresh();
          });
        }
      });
  }

  /* Specific Code Start */
  /* Specific Code End */
}

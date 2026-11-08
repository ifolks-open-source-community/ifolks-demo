import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Observable } from 'rxjs';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { I18nPipe } from 'src/app/core/pipes/I18nPipe';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { StringUtils } from 'src/app/core/services/StringUtils';
import { StupidFullView } from 'src/app/features/models/dummy/views/full/StupidFullView';
import { FoolRestClient } from 'src/app/features/services/dummy/FoolRestClient';
import { StupidRestClient } from 'src/app/features/services/dummy/StupidRestClient';
import { SharedModule } from 'src/app/shared/shared.module';
/**
 * auto generated modal component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
  selector: 'app-stupid-modal',
  standalone: true,
  imports: [CommonModule, SharedModule, I18nPipe],
  templateUrl: './stupid-modal.component.html',
  styleUrl: './stupid-modal.component.scss',
})
export class StupidModalComponent implements OnInit {
  view: StupidFullView;
  form: FormGroup;
  foolCodeOptions: Observable<SelectItem[]>;

  constructor(
    private service: StupidRestClient,
    private foolService: FoolRestClient,
    private formBuilder: FormBuilder,
    private changeDetector: ChangeDetectorRef,
    private notifications: NotificationService,
    private dialogRef: MatDialogRef<StupidModalComponent>,
  ) {}

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      code: [{ value: null }, Validators.required],
      foolCode: [{ value: null }, Validators.required],
    });
    this.form.controls['foolCode'].valueChanges.subscribe((value) => {
      this.searchOptionsForFoolCode(value);
    });
    this.restoreForm();
  }
  restoreForm(): void {
    this.form.patchValue({
      code: this.view.form.code,
      foolCode: this.view.form.foolCode,
    });
  }

  applyForm(): void {
    this.view.form.code = StringUtils.emptyToNull(this.form.get('code').value);
    this.view.form.foolCode = StringUtils.emptyToNull(this.form.get('foolCode').value);
  }

  searchOptionsForFoolCode(value: string) {
    if (value) {
      this.foolCodeOptions = this.foolService.searchOptions(value);
    }
  }

  save(): void {
    this.applyForm();
    this.service.save(this.view.form).subscribe((success) => {
      this.notifications.info('operation.completed');
      this.dialogRef.close(true);
    });
  }

  update(): void {
    this.applyForm();
    this.service.update(this.view.id, this.view.form).subscribe((success) => {
      this.notifications.info('operation.completed');
      this.dialogRef.close(true);
    });
  }

  saveOrUpdate(): void {
    if (this.view.id == null) {
      this.save();
    } else {
      this.update();
    }
  }

  /* Specific Code Start */
  /* Specific Code End */
}

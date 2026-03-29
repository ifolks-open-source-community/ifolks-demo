import { CalendarDayOffFullView } from 'src/app/features/models/reference/time/views/full/CalendarDayOffFullView';
import { CalendarRestClient } from 'src/app/features/services/reference/time/CalendarRestClient';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { NotificationService } from 'src/app/core/services/NotificationService';
import { Observable } from 'rxjs';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { StringUtils } from 'src/app/core/services/StringUtils';
/**
 * auto generated one to many component modal component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-calendar-day-off-modal',
templateUrl: './calendar-day-off-modal.component.html',
styleUrls: ['./calendar-day-off-modal.component.scss']
})
export class CalendarDayOffModalComponent implements OnInit {

parentId: number;
view: CalendarDayOffFullView;
form: FormGroup;

constructor(private service:CalendarRestClient, private formBuilder: FormBuilder, private notifications: NotificationService, private dialogRef: MatDialogRef<CalendarDayOffModalComponent>) {}

ngOnInit(): void {
this.form = this.formBuilder.group({
dayOffDate:[{value:null}, Validators.required],
dayOffLabel:[{value:null}]});
this.restoreForm();
}
restoreForm(): void {
this.form.patchValue({
dayOffDate: this.view.form.dayOffDate,
dayOffLabel: this.view.form.dayOffLabel
})
}

applyForm(): void {
this.view.form.dayOffDate = StringUtils.emptyToNull(this.form.get('dayOffDate').value);
this.view.form.dayOffLabel = StringUtils.emptyToNull(this.form.get('dayOffLabel').value);
}

save(): void {
this.applyForm();
this.service.saveCalendarDayOff(this.parentId, this.view.form).subscribe(success => {this.notifications.info("Operation completed");this.dialogRef.close();}, error => {this.notifications.error("Operation failed")});
}

update(): void {
this.applyForm();
this.service.updateCalendarDayOff(this.view.id, this.view.form).subscribe(success => {this.notifications.info("Operation completed");this.dialogRef.close();}, error => {this.notifications.error("Operation failed")});
}

saveOrUpdate(): void {
if (this.view.id == null) {this.save()} else {this.update()}
}

/* Specific Code Start */
/* Specific Code End */
}

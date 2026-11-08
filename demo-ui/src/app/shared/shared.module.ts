import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';
import { RouterModule } from '@angular/router';
import { ISO_LOCAL_DATE_FORMAT, IsoLocalDateNativeDateAdapter } from '../core/adapters/IsoLocalDateAdapter';
import { MaterialModule } from './material.module';

@NgModule({
  imports: [CommonModule, MaterialModule, RouterModule, ReactiveFormsModule, FormsModule],
  exports: [CommonModule, MaterialModule, RouterModule, ReactiveFormsModule, FormsModule],
  declarations: [],
  providers: [
    { provide: MAT_DATE_LOCALE, useValue: 'en-US' },
    { provide: DateAdapter, useClass: IsoLocalDateNativeDateAdapter },
    { provide: MAT_DATE_FORMATS, useValue: ISO_LOCAL_DATE_FORMAT },
  ],
})
export class SharedModule {}

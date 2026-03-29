import { CommonModule } from '@angular/common';
import { CountryDetailsComponent } from './details/country-details.component';
import { CountryListComponent } from './list/country-list.component';
import { CountryMenuComponent } from './menu/country-menu.component';
import { CountryModalComponent } from './modal/country-modal.component';
import { CountryRoutingModule } from './country-routing.module';
import { NgModule } from '@angular/core';
import { PrivateTemplatesModule } from 'src/app/templates/private/templates.module';
import { RegionListComponent } from './region/list/region-list.component';
import { RegionModalComponent } from './region/modal/region-modal.component';
import { SharedModule } from 'src/app/shared/shared.module';
/**
 * auto generated list module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@NgModule({
declarations: [CountryListComponent,CountryDetailsComponent, CountryModalComponent, CountryMenuComponent, RegionListComponent, RegionModalComponent],
imports: [CommonModule, SharedModule, CountryRoutingModule, PrivateTemplatesModule]
})
export class CountryModule { }

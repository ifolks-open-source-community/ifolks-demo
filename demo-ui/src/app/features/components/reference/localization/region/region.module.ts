import { CityListComponent } from './city/list/city-list.component';
import { CityModalComponent } from './city/modal/city-modal.component';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { PrivateTemplatesModule } from 'src/app/templates/private/templates.module';
import { RegionDetailsComponent } from './details/region-details.component';
import { RegionListComponent } from './list/region-list.component';
import { RegionMenuComponent } from './menu/region-menu.component';
import { RegionModalComponent } from './modal/region-modal.component';
import { RegionRoutingModule } from './region-routing.module';
import { SharedModule } from 'src/app/shared/shared.module';
/**
 * auto generated list module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@NgModule({
declarations: [RegionListComponent,RegionDetailsComponent, RegionModalComponent, RegionMenuComponent, CityListComponent, CityModalComponent],
imports: [CommonModule, SharedModule, RegionRoutingModule, PrivateTemplatesModule]
})
export class RegionModule { }

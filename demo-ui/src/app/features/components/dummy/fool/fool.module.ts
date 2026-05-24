import { CommonModule } from '@angular/common';
import { FoolDetailsComponent } from './details/fool-details.component';
import { FoolListComponent } from './list/fool-list.component';
import { FoolMenuComponent } from './menu/fool-menu.component';
import { FoolModalComponent } from './modal/fool-modal.component';
import { FoolRoutingModule } from './fool-routing.module';
import { NgModule } from '@angular/core';
import { PrivateTemplatesModule } from 'src/app/templates/private/templates.module';
import { SharedModule } from 'src/app/shared/shared.module';
/**
 * auto generated list module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@NgModule({
declarations: [FoolListComponent,FoolDetailsComponent, FoolModalComponent, FoolMenuComponent],
imports: [CommonModule, SharedModule, FoolRoutingModule, PrivateTemplatesModule]
})
export class FoolModule { }

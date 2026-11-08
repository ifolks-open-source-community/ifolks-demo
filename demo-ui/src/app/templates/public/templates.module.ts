import { NgModule } from '@angular/core';

import { CommonModule } from '@angular/common';
import { I18nPipe } from 'src/app/core/pipes/I18nPipe';
import { SharedModule } from 'src/app/shared/shared.module';
import { BodyComponent } from './components/body/body.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { TemplateComponent } from './components/template/template.component';

@NgModule({
  imports: [CommonModule, SharedModule, I18nPipe],
  declarations: [HeaderComponent, BodyComponent, FooterComponent, TemplateComponent],
  exports: [TemplateComponent],
})
export class PublicTemplatesModule {}

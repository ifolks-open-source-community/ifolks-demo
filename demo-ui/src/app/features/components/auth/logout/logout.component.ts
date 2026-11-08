import { Component, OnInit } from '@angular/core';
import { I18nPipe } from 'src/app/core/pipes/I18nPipe';
import { PublicTemplatesModule } from 'src/app/templates/public/templates.module';

@Component({
  selector: 'app-logout',
  standalone: true,
  imports: [PublicTemplatesModule, I18nPipe],
  templateUrl: './logout.component.html',
  styleUrl: './logout.component.scss',
})
export class LogoutComponent implements OnInit {
  ngOnInit(): void {}
}

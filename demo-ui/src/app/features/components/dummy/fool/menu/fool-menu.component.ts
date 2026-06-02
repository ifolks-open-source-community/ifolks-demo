import { CommonModule } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { NavLink } from 'src/app/templates/private/models/nav-link';
import { SharedModule } from 'src/app/shared/shared.module';
/**
 * auto generated menu component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-fool-menu',
standalone: true,
imports: [CommonModule, SharedModule],
templateUrl: './fool-menu.component.html',
styleUrl: './fool-menu.component.scss'
})
export class FoolMenuComponent implements OnInit {

links:NavLink[];
@Input() id:string;
@Input() activePath:string;

ngOnInit(): void {
this.links=[{text:'Details',path:'/fool/' + this.id.toString()}];
}
}

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
selector: 'app-stupid-menu',
standalone: true,
imports: [CommonModule, SharedModule],
templateUrl: './stupid-menu.component.html',
styleUrl: './stupid-menu.component.scss'
})
export class StupidMenuComponent implements OnInit {

links:NavLink[];
@Input() id:number;
@Input() activePath:string;

ngOnInit(): void {
this.links=[{text:'Details',path:'/stupid/' + this.id.toString()}];
}
}

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
selector: 'app-organization-menu',
standalone: true,
imports: [CommonModule, SharedModule],
templateUrl: './organization-menu.component.html',
styleUrl: './organization-menu.component.scss'
})
export class OrganizationMenuComponent implements OnInit {

links:NavLink[];
@Input() id:number;
@Input() activePath:string;

ngOnInit(): void {
this.links=[{text:'Details',path:'/organization/' + this.id.toString()},{text:'Certification',path:'/organization/' + this.id.toString() + '/organization-certification'}];
}
}

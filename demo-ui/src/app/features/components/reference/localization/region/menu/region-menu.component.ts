import { Component, Input, OnInit } from '@angular/core';
import { NavLink } from 'src/app/templates/private/models/nav-link';
/**
 * auto generated menu component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-region-menu',
templateUrl: './region-menu.component.html',
styleUrls: ['./region-menu.component.scss']
})
export class RegionMenuComponent implements OnInit {

links:NavLink[];
@Input() id:number;
@Input() activePath:string;

ngOnInit(): void {
this.links=[{text:'Details',path:'/region/' + this.id.toString()},{text:'Cities',path:'/region/' + this.id.toString() + '/city/list'}];
}
}

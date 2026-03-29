import { Component, Input, OnInit } from '@angular/core';
import { NavLink } from 'src/app/templates/private/models/nav-link';
/**
 * auto generated menu component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-city-menu',
templateUrl: './city-menu.component.html',
styleUrls: ['./city-menu.component.scss']
})
export class CityMenuComponent implements OnInit {

links:NavLink[];
@Input() id:number;
@Input() activePath:string;

ngOnInit(): void {
this.links=[{text:'Details',path:'/city/' + this.id.toString()}];
}
}

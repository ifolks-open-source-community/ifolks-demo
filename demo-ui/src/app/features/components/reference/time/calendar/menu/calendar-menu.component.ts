import { Component, Input, OnInit } from '@angular/core';
import { NavLink } from 'src/app/templates/private/models/nav-link';
/**
 * auto generated menu component ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

@Component({
selector: 'app-calendar-menu',
templateUrl: './calendar-menu.component.html',
styleUrls: ['./calendar-menu.component.scss']
})
export class CalendarMenuComponent implements OnInit {

links:NavLink[];
@Input() id:number;
@Input() activePath:string;

ngOnInit(): void {
this.links=[{text:'Details',path:'/calendar/' + this.id.toString()},{text:'Days off',path:'/calendar/' + this.id.toString() + '/calendar-day-off/list'}];
}
}

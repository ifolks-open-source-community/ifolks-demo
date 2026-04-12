import { CalendarBasicView } from 'src/app/features/models/reference/time/views/basic/CalendarBasicView';
import { CalendarDayOffBasicView } from 'src/app/features/models/reference/time/views/basic/CalendarDayOffBasicView';
import { CalendarDayOffFilter } from 'src/app/features/models/reference/time/filters/CalendarDayOffFilter';
import { CalendarDayOffForm } from 'src/app/features/models/reference/time/forms/CalendarDayOffForm';
import { CalendarDayOffFullView } from 'src/app/features/models/reference/time/views/full/CalendarDayOffFullView';
import { CalendarDayOffSorting } from 'src/app/features/models/reference/time/sortings/CalendarDayOffSorting';
import { CalendarFilter } from 'src/app/features/models/reference/time/filters/CalendarFilter';
import { CalendarForm } from 'src/app/features/models/reference/time/forms/CalendarForm';
import { CalendarFullView } from 'src/app/features/models/reference/time/views/full/CalendarFullView';
import { CalendarSorting } from 'src/app/features/models/reference/time/sortings/CalendarSorting';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ScrollForm } from 'src/app/core/models/ScrollForm';
import { ScrollView } from 'src/app/core/models/ScrollView';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { environment } from 'src/environments/environment';

/**
 * auto generated rest client ts file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
@Injectable({providedIn:'root'})
export class CalendarRestClient {

private httpOptions = {headers:new HttpHeaders({'Content-Type':'application/json'})};

constructor(private http: HttpClient) { }
/**
 * get options
 */
public getOptions() {
return this.http.get<SelectItem[]>(environment.restApiUrl + '/calendar/options');
}

/**
 * load object list
 */
public loadList() {
return this.http.get<CalendarBasicView[]>(environment.restApiUrl + '/calendar/list');
}

/**
 * scroll object list
 */
public scroll(form: ScrollForm<CalendarFilter, CalendarSorting>) {
return this.http.post<ScrollView<CalendarBasicView>>(environment.restApiUrl + '/calendar/scroll', form, this.httpOptions);
}

/**
 * load object
 */
public load(id:number) {
return this.http.get<CalendarFullView>(environment.restApiUrl + '/calendar/' + id);
}

/**
 * load one to many component calendarDayOff list
 */
public loadCalendarDayOffList(id:number) {
return this.http.get<CalendarDayOffBasicView[]>(environment.restApiUrl + '/calendar/' + id + '/calendar-day-off/list', this.httpOptions);
}

/**
 * scroll one to many component calendarDayOff
 */
public scrollCalendarDayOff (id: number, form: ScrollForm<CalendarDayOffFilter, CalendarDayOffSorting>) {
return this.http.post<ScrollView<CalendarDayOffBasicView>>(environment.restApiUrl + '/calendar/' + id + '/calendar-day-off/scroll', form, this.httpOptions);
}

/**
 * load one to many component calendarDayOff
 */
public loadCalendarDayOff(id: number) {
return this.http.get<CalendarDayOffFullView>(environment.restApiUrl + '/calendar-day-off/' + id, this.httpOptions);
}

/**
 * save object
 */
public save(form: CalendarForm) {
return this.http.post<number>(environment.restApiUrl + '/calendar', form, this.httpOptions);
}

/**
 * save one to many component calendarDayOff
 */
public saveCalendarDayOff(id:number, form: CalendarDayOffForm) {
return this.http.post<number>(environment.restApiUrl + '/calendar/' + id + '/calendar-day-off', form, this.httpOptions);
}

/**
 * update object
 */
public update(id: number, form: CalendarForm) {
return this.http.put(environment.restApiUrl + '/calendar/' + id, form, this.httpOptions);
}

/**
 * update one to many component calendarDayOff
 */
public updateCalendarDayOff(id: number, form: CalendarDayOffForm) {
return this.http.put(environment.restApiUrl + '/calendar-day-off/' + id, form, this.httpOptions);
}

/**
 * delete object
 */
public delete(id: number) {
return this.http.delete(environment.restApiUrl + '/calendar/' + id);
}

/**
 * delete one to many component calendarDayOff
 */
public deleteCalendarDayOff(id: number) {
return this.http.delete(environment.restApiUrl + '/calendar-day-off/' + id);
}


/* Specific Code Start */
/* Specific Code End */

}

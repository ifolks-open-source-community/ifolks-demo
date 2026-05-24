import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ScrollForm } from 'src/app/core/models/ScrollForm';
import { ScrollView } from 'src/app/core/models/ScrollView';
import { SelectItem } from 'src/app/core/models/SelectItem';
import { StupidBasicView } from 'src/app/features/models/dummy/views/basic/StupidBasicView';
import { StupidFilter } from 'src/app/features/models/dummy/filters/StupidFilter';
import { StupidForm } from 'src/app/features/models/dummy/forms/StupidForm';
import { StupidFullView } from 'src/app/features/models/dummy/views/full/StupidFullView';
import { StupidSorting } from 'src/app/features/models/dummy/sortings/StupidSorting';
import { environment } from 'src/environments/environment';

/**
 * auto generated rest client ts file
 * <br/>no modification should be done to this file
 * <br/>processed by ifolks-generator
 */
@Injectable({providedIn:'root'})
export class StupidRestClient {

private httpOptions = {headers:new HttpHeaders({'Content-Type':'application/json'})};

constructor(private http: HttpClient) { }
/**
 * load object list
 */
public loadList() {
return this.http.get<StupidBasicView[]>(environment.restApiUrl + '/stupid/list');
}

/**
 * scroll object list
 */
public scroll(form: ScrollForm<StupidFilter, StupidSorting>) {
return this.http.post<ScrollView<StupidBasicView>>(environment.restApiUrl + '/stupid/scroll', form, this.httpOptions);
}

/**
 * load object
 */
public load(id:number) {
return this.http.get<StupidFullView>(environment.restApiUrl + '/stupid/' + id);
}

/**
 * save object
 */
public save(form: StupidForm) {
return this.http.post<number>(environment.restApiUrl + '/stupid', form, this.httpOptions);
}

/**
 * update object
 */
public update(id: number, form: StupidForm) {
return this.http.put(environment.restApiUrl + '/stupid/' + id, form, this.httpOptions);
}

/**
 * delete object
 */
public delete(id: number) {
return this.http.delete(environment.restApiUrl + '/stupid/' + id);
}


/* Specific Code Start */
/* Specific Code End */

}

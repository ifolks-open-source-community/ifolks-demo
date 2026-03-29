import { CityBasicView } from 'src/app/features/models/reference/localization/views/basic/CityBasicView';
import { CityFilter } from 'src/app/features/models/reference/localization/filters/CityFilter';
import { CityForm } from 'src/app/features/models/reference/localization/forms/CityForm';
import { CityFullView } from 'src/app/features/models/reference/localization/views/full/CityFullView';
import { CitySorting } from 'src/app/features/models/reference/localization/sortings/CitySorting';
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
export class CityRestClient {

private httpOptions = {headers:new HttpHeaders({'Content-Type':'application/json'})};

constructor(private http: HttpClient) { }
/**
 * load object list
 */
public loadList() {
return this.http.get<CityBasicView[]>(environment.restApiUrl + '/city/list');
}

/**
 * load object list from region
 */
public loadListFromRegion (regionId: number) {
return this.http.get<CityBasicView[]>(environment.restApiUrl + '/region/' + regionId + '/city/list');
}

/**
 * scroll object list
 */
public scroll(form: ScrollForm<CityFilter, CitySorting>) {
return this.http.post<ScrollView<CityBasicView>>(environment.restApiUrl + '/city/scroll', form, this.httpOptions);
}

/**
 * scroll object list from region
 */
public scrollFromRegion (regionId: number, form: ScrollForm<CityFilter, CitySorting>) {
return this.http.post<ScrollView<CityBasicView>>(environment.restApiUrl + '/region/' + regionId + '/city/scroll', form, this.httpOptions);
}

/**
 * load object
 */
public load(id:number) {
return this.http.get<CityFullView>(environment.restApiUrl + '/city/' + id);
}

/**
 * create object
 */
public create() {
return this.http.get<CityFullView>(environment.restApiUrl + '/city/new');
}

/**
 * save object
 */
public save(form: CityForm) {
return this.http.post<number>(environment.restApiUrl + '/city', form, this.httpOptions);
}

/**
 * update object
 */
public update(id: number, form: CityForm) {
return this.http.put(environment.restApiUrl + '/city/' + id, form, this.httpOptions);
}

/**
 * delete object
 */
public delete(id: number) {
return this.http.delete(environment.restApiUrl + '/city/' + id);
}


/* Specific Code Start */
/* Specific Code End */

}

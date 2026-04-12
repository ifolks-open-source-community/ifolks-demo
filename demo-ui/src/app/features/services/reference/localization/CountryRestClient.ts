import { CountryBasicView } from 'src/app/features/models/reference/localization/views/basic/CountryBasicView';
import { CountryFilter } from 'src/app/features/models/reference/localization/filters/CountryFilter';
import { CountryForm } from 'src/app/features/models/reference/localization/forms/CountryForm';
import { CountryFullView } from 'src/app/features/models/reference/localization/views/full/CountryFullView';
import { CountrySorting } from 'src/app/features/models/reference/localization/sortings/CountrySorting';
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
export class CountryRestClient {

private httpOptions = {headers:new HttpHeaders({'Content-Type':'application/json'})};

constructor(private http: HttpClient) { }
/**
 * get options
 */
public getOptions() {
return this.http.get<SelectItem[]>(environment.restApiUrl + '/country/options');
}

/**
 * load object list
 */
public loadList() {
return this.http.get<CountryBasicView[]>(environment.restApiUrl + '/country/list');
}

/**
 * scroll object list
 */
public scroll(form: ScrollForm<CountryFilter, CountrySorting>) {
return this.http.post<ScrollView<CountryBasicView>>(environment.restApiUrl + '/country/scroll', form, this.httpOptions);
}

/**
 * load object
 */
public load(id:number) {
return this.http.get<CountryFullView>(environment.restApiUrl + '/country/' + id);
}

/**
 * save object
 */
public save(form: CountryForm) {
return this.http.post<number>(environment.restApiUrl + '/country', form, this.httpOptions);
}

/**
 * update object
 */
public update(id: number, form: CountryForm) {
return this.http.put(environment.restApiUrl + '/country/' + id, form, this.httpOptions);
}

/**
 * delete object
 */
public delete(id: number) {
return this.http.delete(environment.restApiUrl + '/country/' + id);
}


/* Specific Code Start */
/* Specific Code End */

}

import { FoolBasicView } from 'src/app/features/models/dummy/views/basic/FoolBasicView';
import { FoolFilter } from 'src/app/features/models/dummy/filters/FoolFilter';
import { FoolForm } from 'src/app/features/models/dummy/forms/FoolForm';
import { FoolFullView } from 'src/app/features/models/dummy/views/full/FoolFullView';
import { FoolSorting } from 'src/app/features/models/dummy/sortings/FoolSorting';
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
export class FoolRestClient {

private httpOptions = {headers:new HttpHeaders({'Content-Type':'application/json'})};

constructor(private http: HttpClient) { }
/**
 * get options
 */
public searchOptions(arg:string) {
return this.http.get<SelectItem[]>(environment.restApiUrl + '/fool/options/search', {params:{'arg':arg}});
}

/**
 * load object list
 */
public loadList() {
return this.http.get<FoolBasicView[]>(environment.restApiUrl + '/fool/list');
}

/**
 * scroll object list
 */
public scroll(form: ScrollForm<FoolFilter, FoolSorting>) {
return this.http.post<ScrollView<FoolBasicView>>(environment.restApiUrl + '/fool/scroll', form, this.httpOptions);
}

/**
 * load object
 */
public load(id:string) {
return this.http.get<FoolFullView>(environment.restApiUrl + '/fool/' + id);
}

/**
 * save object
 */
public save(form: FoolForm) {
return this.http.post<string>(environment.restApiUrl + '/fool', form, this.httpOptions);
}

/**
 * update object
 */
public update(id: string, form: FoolForm) {
return this.http.put(environment.restApiUrl + '/fool/' + id, form, this.httpOptions);
}

/**
 * delete object
 */
public delete(id: string) {
return this.http.delete(environment.restApiUrl + '/fool/' + id);
}


/* Specific Code Start */
/* Specific Code End */

}

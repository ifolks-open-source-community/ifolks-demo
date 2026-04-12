import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OrganizationBasicView } from 'src/app/features/models/organizations/views/basic/OrganizationBasicView';
import { OrganizationCertificationForm } from 'src/app/features/models/organizations/forms/OrganizationCertificationForm';
import { OrganizationCertificationFullView } from 'src/app/features/models/organizations/views/full/OrganizationCertificationFullView';
import { OrganizationFilter } from 'src/app/features/models/organizations/filters/OrganizationFilter';
import { OrganizationForm } from 'src/app/features/models/organizations/forms/OrganizationForm';
import { OrganizationFullView } from 'src/app/features/models/organizations/views/full/OrganizationFullView';
import { OrganizationSorting } from 'src/app/features/models/organizations/sortings/OrganizationSorting';
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
export class OrganizationRestClient {

private httpOptions = {headers:new HttpHeaders({'Content-Type':'application/json'})};

constructor(private http: HttpClient) { }
/**
 * get options
 */
public searchOptions(arg:string) {
return this.http.get<SelectItem[]>(environment.restApiUrl + '/organization/options/search', {params:{'arg':arg}});
}

/**
 * load object list
 */
public loadList() {
return this.http.get<OrganizationBasicView[]>(environment.restApiUrl + '/organization/list');
}

/**
 * scroll object list
 */
public scroll(form: ScrollForm<OrganizationFilter, OrganizationSorting>) {
return this.http.post<ScrollView<OrganizationBasicView>>(environment.restApiUrl + '/organization/scroll', form, this.httpOptions);
}

/**
 * load object
 */
public load(id:number) {
return this.http.get<OrganizationFullView>(environment.restApiUrl + '/organization/' + id);
}

/**
 * load one to one component organizationCertification
 */
public loadOrganizationCertification(id: number) {
return this.http.get<OrganizationCertificationFullView>(environment.restApiUrl + '/organization/' + id + '/organization-certification', this.httpOptions);
}

/**
 * save object
 */
public save(form: OrganizationForm) {
return this.http.post<number>(environment.restApiUrl + '/organization', form, this.httpOptions);
}

/**
 * save one to one component organizationCertification
 */
public saveOrganizationCertification(id:number, form: OrganizationCertificationForm) {
return this.http.post<string>(environment.restApiUrl + '/organization/' + id + '/organization-certification', form, this.httpOptions);
}

/**
 * update object
 */
public update(id: number, form: OrganizationForm) {
return this.http.put(environment.restApiUrl + '/organization/' + id, form, this.httpOptions);
}

/**
 * update one to one component organizationCertification
 */
public updateOrganizationCertification(id: number, form: OrganizationCertificationForm) {
return this.http.put(environment.restApiUrl + '/organization/' + id + '/organization-certification', form, this.httpOptions);
}

/**
 * delete object
 */
public delete(id: number) {
return this.http.delete(environment.restApiUrl + '/organization/' + id);
}

/**
 * delete one to one component organizationCertification
 */
public deleteOrganizationCertification(id: number) {
return this.http.delete(environment.restApiUrl + '/organization/' + id + '/organization-certification');
}


/* Specific Code Start */
/* Specific Code End */

}

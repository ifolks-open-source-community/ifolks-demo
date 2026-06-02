import { AuthGuard } from './core/services/AuthGuard';
import { Routes } from '@angular/router';
/**
 * auto generated app routes ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

export const routes: Routes = [
{path:'country', loadChildren:()=>import('src/app/features/components/reference/localization/country/country.routes').then(m=>m.routes), canActivate: [AuthGuard] }
,{path:'region', loadChildren:()=>import('src/app/features/components/reference/localization/region/region.routes').then(m=>m.routes), canActivate: [AuthGuard] }
,{path:'city', loadChildren:()=>import('src/app/features/components/reference/localization/city/city.routes').then(m=>m.routes), canActivate: [AuthGuard] }
,{path:'calendar', loadChildren:()=>import('src/app/features/components/reference/time/calendar/calendar.routes').then(m=>m.routes), canActivate: [AuthGuard] }
,{path:'organization', loadChildren:()=>import('src/app/features/components/organizations/organization/organization.routes').then(m=>m.routes), canActivate: [AuthGuard] }
,{path:'fool', loadChildren:()=>import('src/app/features/components/dummy/fool/fool.routes').then(m=>m.routes), canActivate: [AuthGuard] }
,{path:'stupid', loadChildren:()=>import('src/app/features/components/dummy/stupid/stupid.routes').then(m=>m.routes), canActivate: [AuthGuard] }
/* Specific Code Start */
,{path: '', redirectTo: '/index', pathMatch:'full'}
,{path:'', loadChildren:()=>import('src/app/features/components/index/index.routes').then(m=>m.routes), canActivate: [AuthGuard]}
,{path:'', loadChildren:()=>import('src/app/features/components/auth/auth.routes').then(m=>m.routes)}
,{path:'**', redirectTo: '/index'}
/* Specific Code End */
];

import { AuthGuard } from './core/services/AuthGuard';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
/**
 * auto generated app routing module ts file
 * <br/>write modifications between specific code marks
 * <br/>processed by ifolks-generator
 */

const routes: Routes = [
{path:'country', loadChildren:()=>import('src/app/features/components/reference/localization/country/country.module').then(m=>m.CountryModule), canActivate: [AuthGuard] }
,{path:'region', loadChildren:()=>import('src/app/features/components/reference/localization/region/region.module').then(m=>m.RegionModule), canActivate: [AuthGuard] }
,{path:'city', loadChildren:()=>import('src/app/features/components/reference/localization/city/city.module').then(m=>m.CityModule), canActivate: [AuthGuard] }
,{path:'calendar', loadChildren:()=>import('src/app/features/components/reference/time/calendar/calendar.module').then(m=>m.CalendarModule), canActivate: [AuthGuard] }
,{path:'organization', loadChildren:()=>import('src/app/features/components/organizations/organization/organization.module').then(m=>m.OrganizationModule), canActivate: [AuthGuard] }
,{path:'fool', loadChildren:()=>import('src/app/features/components/dummy/fool/fool.module').then(m=>m.FoolModule), canActivate: [AuthGuard] }
,{path:'stupid', loadChildren:()=>import('src/app/features/components/dummy/stupid/stupid.module').then(m=>m.StupidModule), canActivate: [AuthGuard] }
/* Specific Code Start */
,{path: '', redirectTo: '/index', pathMatch:'full'}
,{path:'', loadChildren:()=>import('src/app/features/components/index/index.module').then(m=>m.IndexModule), canActivate: [AuthGuard]}
,{path:'', loadChildren:()=>import('src/app/features/components/auth/auth.module').then(m=>m.AuthModule)}
,{path:'**', redirectTo: '/index'}
/* Specific Code End */
];

@NgModule({
imports: [RouterModule.forRoot(routes)],
exports: [RouterModule]
})
export class AppRoutingModule { }

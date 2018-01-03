import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './cmpts/dashboard/dashboard.component';
import { ReportsComponent } from './cmpts/reports/reports.component';
import { ReportsRootComponent } from './cmpts/reports-root/reports-root.component';
import { ReportDetailComponent } from './cmpts/report-detail/report-detail.component';
import { SettingsComponent } from './cmpts/settings/settings.component';
import { ServiceDetailComponent } from './cmpts/service-detail/service-detail.component';


const routes: Routes = [
  // Default route
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  // TODO: Remove before production
  // { path: '', redirectTo: '/under-construction', pathMatch: 'full' },

  // Main routes
  { path: 'dashboard', component: DashboardComponent },
  {
    path: 'reports',
    component: ReportsRootComponent,
    children: [
      { path: '', component: ReportsComponent },
      { path: ':id', component: ReportDetailComponent }
    ]
  },
  { path: 'settings', component: SettingsComponent },
  // Place whatever cmpt your working on here for easy access
  // { path: 'under-construction', component: ServiceDetailComponent }

];

@NgModule({
  // TODO: remove enableTracing: true before production
  imports: [ RouterModule.forRoot(routes, { enableTracing: false }) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}

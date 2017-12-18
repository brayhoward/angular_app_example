import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './cmpts/dashboard/dashboard.component';
import { ReportsComponent } from './cmpts/reports/reports.component';

const routes: Routes = [
  // Default route
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },

  // Main routes
  { path: 'dashboard', component: DashboardComponent },
  { path: 'reports', component: ReportsComponent }

];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}

import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ReportFormComponent } from '../report-form/report-form.component';

@Component({
  selector: 'dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {
  constructor(
    private dialog: MatDialog,
    private router: Router
  ) { }

  onNewReport() {
    this.onViewReports();

    this.dialog.open(ReportFormComponent);
  }

  onViewReports() {
    this.router.navigateByUrl('/reports');
  }
}

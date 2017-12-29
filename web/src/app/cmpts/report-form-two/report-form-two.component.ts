import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Report } from '../../shared-interfaces/report';

@Component({
  selector: 'report-form-two',
  templateUrl: './report-form-two.component.html',
  styleUrls: ['./report-form-two.component.scss']
})
export class ReportFormTwoComponent implements OnInit {
  report: Report;
  edit: boolean;

  constructor(
    public dialogRef: MatDialogRef<ReportFormTwoComponent>,
    private dialog: MatDialog,
    private router: Router,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit() {
    const { report, edit } = this.data;

    this.report = report;
    this.edit = edit;
  }

  onSubmit(report) {
    const { id } = reportService.post(report);
    console.log('report submit', JSON.stringify(report))

    this.router.navigateByUrl(`reports/${id}`);
    this.dialog.closeAll();
  }
}

// service mock
const reportService = {
  post: (report) => ({ id: Math.floor(Math.random() * 66) + 1 })
}

import { Component, OnInit, Inject, Input } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ReportFormTwoComponent } from '../report-form-two/report-form-two.component';
import { Report } from '../../shared-interfaces/report';

@Component({
  selector: 'app-report-form',
  templateUrl: './report-form.component.html',
  styleUrls: ['./report-form.component.scss']
})
export class ReportFormComponent implements OnInit {
  @Input()
  report?: Report;

  @Input()
  heading?: String;

  constructor(
    public dialogRef: MatDialogRef<ReportFormComponent>,
    private dialog: MatDialog,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit() {
    // defaults
    const { report = {}, heading = "New Report" } = this;
    const data = this.data || {};

    // Pass a heading key value in the data obj
    // or via heading property in the template to override default
    this.heading = data.heading || heading;

    // Pass the report in the data obj
    // or via report property in the template.
    this.report = data.report || report;
  }

  onSubmit(report: Report = {}) {
    let dialogRef = this.dialog.open(
      ReportFormTwoComponent,
      {
        data: { report }
      }
    );

    dialogRef.afterClosed().subscribe(result => {
      // console.log('The dialog was closed');
    });
  }

  // TODO: Remove after done developing
  jsonify = node => JSON.stringify(node);

  log = (node, name = 'node') => {
    console.log(name, 'LOGGED BELLOW');
    console.log(node);
  }
}

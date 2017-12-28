import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ReportFormTwoComponent } from '../report-form-two/report-form-two.component';
import { Report } from '../../shared-interfaces/report';

@Component({
  selector: 'app-report-form',
  templateUrl: './report-form.component.html',
  styleUrls: ['./report-form.component.scss']
})
export class ReportFormComponent implements OnInit {
  report?: Report = {};

  constructor(
    public dialogRef: MatDialogRef<ReportFormComponent>,
    private dialog: MatDialog,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit() {
    const defaults = { heading: 'New Report' };

    this.report = { ...defaults, ...this.data.report };
  }

  onContinue(report = {}) {
    let dialogRef = this.dialog.open(
      ReportFormTwoComponent,
      {
        data: { ...this.report }
      }
    );

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  // TODO: Remove after done developing
  jsonify = node => JSON.stringify(node);

  log = (node, name = 'node') => {
    console.log(name, 'LOGGED BELLOW');
    console.log(node);
  }
}

import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-report-form',
  templateUrl: './report-form.component.html',
  styleUrls: ['./report-form.component.scss']
})
export class ReportFormComponent implements OnInit {
  report?: Report = {};

  constructor(
    public dialogRef: MatDialogRef<ReportFormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit() {
    const defaults = { heading: 'New Report' };

    this.report = { ...defaults, ...this.data.report };
  }

  // TODO: Remove after done developing
  jsonify = node => JSON.stringify(node);

  log = (node, name = 'node') => {
    console.log(name, 'LOGGED BELLOW');
    console.log(node);
  }

}


interface Report {
  heading?: String;
  engineModel?: String;
  name?: String;
  contactName?: String;
  company?: String;
}

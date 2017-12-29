import { Component, OnInit, Inject, Input } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ReportFormTwoComponent } from '../report-form-two/report-form-two.component';
import { Report, ReportTemplate } from '../../shared-interfaces/report';

@Component({
  selector: 'app-report-form',
  templateUrl: './report-form.component.html',
  styleUrls: ['./report-form.component.scss']
})
export class ReportFormComponent implements OnInit {
  @Input()
  report?: Report;

  @Input()
  edit?: String;

  constructor(
    public dialogRef: MatDialogRef<ReportFormComponent>,
    private dialog: MatDialog,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit() {
    // defaults
    const {
      report = new ReportTemplate(),
      edit = false
    } = this;

    const data = this.data || {};

    // Pass a edit key value in the data obj
    // or via edit property in the template to override default
    this.edit = data.edit || edit;

    // Pass the report in the data obj
    // or via report property in the template.
    this.report = data.report || report;
  }

  onSubmit(report: Report) {
    const { dialog, edit } = this;

    let dialogRef = dialog.open(
      ReportFormTwoComponent,
      {
        data: { report, edit }
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

import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'report-form-two',
  templateUrl: './report-form-two.component.html',
  styleUrls: ['./report-form-two.component.scss']
})
export class ReportFormTwoComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<ReportFormTwoComponent>,
    private dialog: MatDialog,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit() {
  }
}

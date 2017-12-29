import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-report-share',
  templateUrl: './report-share.component.html',
  styleUrls: ['./report-share.component.scss']
})
export class ReportShareComponent {
  reportUrl: String = "https://lifecycle-waukesha.gepower.com?report=123456"

  constructor(
    private dialog: MatDialog
  ) { }

  onDownloadExcel() {
    console.log('onDownloadExcel Clicked')
    this.closeDialog();
  }

  onDownloadPDF() {
    console.log('onDownloadPDF Clicked')
    this.closeDialog();
  }

  onCopy() {
    console.log('onCopy Clicked')
    this.closeDialog();
  }

  closeDialog() {
    this.dialog.closeAll();
  }
}

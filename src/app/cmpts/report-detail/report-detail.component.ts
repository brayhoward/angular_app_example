import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

import { Report} from '../../shared-interfaces/report';
import { ReportFormComponent } from '../report-form/report-form.component';
import { ReportShareComponent } from '../report-share/report-share.component';

@Component({
  selector: 'report-detail',
  templateUrl: './report-detail.component.html',
  styleUrls: ['./report-detail.component.scss']
})
export class ReportDetailComponent implements OnInit {
  showLubrication: boolean = true;
  showFuel: boolean = true;
  showLabor: boolean = true;
  selected: String = '';
  report: Report = reportMock;

  constructor(
    private dialog: MatDialog
  ) { }

  ngOnInit() {
  }

  onEdit(report: Report) {
    // Open modal with Report Form
    let dialogRef = this.dialog.open(
      ReportFormComponent,
      { data: { edit: true, report } }
    );

    dialogRef.afterClosed().subscribe(result => {
      // console.log('The dialog was closed');
    });
  }

  onShare(report: Report) {
    this.dialog.open(
      ReportShareComponent,
      { data: { report } }
    );
  }

  toggleLubrication = (event) => {
    // this.showLubrication = event.detail.value;
    this.toggleProperty('showLubrication')(event)
  }

  toggleFuel = (event) => {
    this.toggleProperty('showFuel')(event)
  }

  toggleLabor = (event) => {
    this.toggleProperty('showLabor')(event)
  }

  toggleProperty = (prop) => (event) => {
    this[prop] = event.detail.value;
    //TODO: remove console.log
    console.log(prop + ':', this[prop])
  }
}


const reportMock = {
  id: 6,
  engineModel: "L7044GSI",
  name: "L7044GSI Report Forecast #1",
  contactName: "Sam Williams",
  company: "Cinco",
  includeFuel: false,
  commissioningParts: false,
  spareParts: true,
  tools: false,
  lubeOilChange: true,
  plannedServiceA: true,
  plannedServiceB: true,
  plannedServiceC: true,
  topEndOverhaul: true,
  bottomEndOverhaul: true,
  date: "08-19-2018"
};

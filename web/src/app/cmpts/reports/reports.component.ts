import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material';
import { MatDialog } from '@angular/material/dialog';
import { ReportFormComponent } from '../../cmpts/report-form/report-form.component';
import { Report } from '../../shared-interfaces/report';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.scss']
})
export class ReportsComponent {
  dataSource: any;
  selectedRows: number[] = [];
  availableRows: number[] = [];
  displayedColumns = ['engineModel', 'name', 'contactName', 'company', 'date', 'edit'];
  masterSelected: boolean = false;
  dataPool: Report[]
  readonly menuItems: any[] = [
    { "key": "1", "val": "Edit" },
    { "key": "2", "val": "Duplicate" },
    { "key": "3", "val": "Delete" },
    { "key": "4", "val": "Share" }
  ];

  constructor(private router: Router, private dialog: MatDialog) {
    this.dataPool = ELEMENT_DATA;
    this.dataSource = new MatTableDataSource(ELEMENT_DATA);
    this.availableRows = ELEMENT_DATA.map(row => ( row.id ));
  }

  toggleRow(row) {
    const { isSelected, selectedRows, } = this;

    this.selectedRows = isSelected(row) ? selectedRows.filter(id => id !== row.id) : [...this.selectedRows, row.id]
  }

  isSelected = ({ id }) => this.selectedRows.includes(id);

  viewDetailPage() {
    this.router.navigateByUrl("/report-detail")
  }

  toggleMaster() {
    const allSelected = !this.masterSelected;

    this.masterSelected = allSelected;
    this.selectedRows = allSelected ? this.availableRows : []
  }

  onSearchResultsCallback = (searchResults) => {
    this.dataSource = new MatTableDataSource(searchResults);
  }

  // Report edit functions //
  menuItemSelected({ detail: { value } }, row) {
    switch (value) {
      case "Edit":
        return this.editReport(row);

      case "Delete":
        return this.deleteReport(row);

      case "Share":
        return this.shareReport(row);

      case "Duplicate":
        return this.duplicateReport(row);

      default:
        throw `
        The menu item selected failed to find a action match Check ReportComponent.menuItems
        and make sure there's a matching case for each one in ReportComponent.menuItemSelected() switch statement
      `;
    }
  }

  editReport(report: Report) {
    // Open modal with Report Form
    let dialogRef = this.dialog.open(
      ReportFormComponent,
      { data: { edit: true, report } }
    );

    dialogRef.afterClosed().subscribe(result => {
      // console.log('The dialog was closed');
    });
  }

  deleteReport({ id }) {
    console.log('deleteReport', id);
  }

  shareReport({ id }) {
    console.log('shareReport', id);
  }

  duplicateReport({ id }) {
    console.log('duplicateReport', id);
  }
  ////////////////////////

  onNewReport() {
    // Open modal with Report Form
    let dialogRef = this.dialog.open(ReportFormComponent);

    dialogRef.afterClosed().subscribe(result => {
      // console.log('The dialog was closed');
    });
  }

  jsonify = node => JSON.stringify(node);

  log = (node, name = 'node') => {
    console.log('node', 'LOGGED BELLOW');
    console.log(node);
  }

}

const ELEMENT_DATA = [
  {
    id: 1,
    engineModel:"L7044GSI",
    name:"L7044GSI Report Forecast #1",
    contactName:"Jay Williams",
    company:"ACME Corporation",
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
    date:"08-18-2018"
  },
  {
    id: 2,
    engineModel:"L7044GSI",
    name:"L7044GSI Report Forecast #1",
    contactName:"Tim Williams",
    company:"Cinco",
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
    date:"08-18-2018"
  },
  {
    id: 3,
    engineModel:"L7044GSI",
    name:"L7044GSI Report Forecast #1",
    contactName:"James Williams",
    company:"Globo Chem",
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
    date:"08-12-2018"
  },
  {
    id: 4,
    engineModel:"L7044GSI",
    name:"L7044GSI Report Forecast #1",
    contactName:"Cindy Williams",
    company:"ACME Corporation",
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
    date:"08-18-2018"
  },
  {
    id: 5,
    engineModel:"L7044GSI",
    name:"L7044GSI Report Forecast #1",
    contactName:"Jay Williams",
    company:"ACME Corporation",
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
    date:"08-12-2018"
  },
  {
    id: 6,
    engineModel:"L7044GSI",
    name:"L7044GSI Report Forecast #1",
    contactName:"Sam Williams",
    company:"Cinco",
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
    date:"08-19-2018"
  }
]

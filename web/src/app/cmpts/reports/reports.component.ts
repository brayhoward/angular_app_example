import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material';
import { MatDialog } from '@angular/material/dialog';
import { ReportFormComponent } from '../../cmpts/report-form/report-form.component';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.scss']
})
export class ReportsComponent {
  dataSource: any;
  selectedRows: number[] = [];
  availableRows: number[] = [];
  displayedColumns: String[] = ['engine', 'reportName', 'contact', 'company', 'date', 'edit'];
  masterSelected: boolean = false;
  dataPool: any[]
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

  menuItemSelected({ detail: { value } }, { id }) {
    switch (value) {
      case "Edit":
        return this.editReportDialog(id);

      case "Delete":
        return this.deleteReport(id);

      case "Share":
        return this.shareReport(id);

      case "Duplicate":
        return this.duplicateReport(id);

      default:
        throw `
        The menu item selected failed to find a action match Check ReportComponent.menuItems
        and make sure there's a matching case for each one in ReportComponent.menuItemSelected() switch statement
      `;
    }
  }

  onSearchResultsCallback = (searchResults) => {
    this.dataSource = new MatTableDataSource(searchResults);
  }

  editReportDialog(id) {
    console.log('editReport', id);
  }

  deleteReport(id) {
    console.log('deleteReport', id);
  }

  shareReport(id) {
    console.log('shareReport', id);
  }

  duplicateReport(id) {
    console.log('duplicateReport', id);
  }

  onNewReport(report = {}) {
    let dialogRef = this.dialog.open(
      ReportFormComponent,
      {
        data: { report }
      }
    );

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
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
    engine:"L7044GSI",
    reportName:"L7044GSI Report Forecast #1",
    contact:"Jay Williams",
    company:"ACME Corporation",
    date:"08-18-2018"
  },
  {
    id: 2,
    engine:"L7044GSI",
    reportName:"L7044GSI Report Forecast #1",
    contact:"Tim Williams",
    company:"Cinco",
    date:"08-18-2018"
  },
  {
    id: 3,
    engine:"L7044GSI",
    reportName:"L7044GSI Report Forecast #1",
    contact:"James Williams",
    company:"Globo Chem",
    date:"08-12-2018"
  },
  {
    id: 4,
    engine:"L7044GSI",
    reportName:"L7044GSI Report Forecast #1",
    contact:"Cindy Williams",
    company:"ACME Corporation",
    date:"08-18-2018"
  },
  {
    id: 5,
    engine:"L7044GSI",
    reportName:"L7044GSI Report Forecast #1",
    contact:"Jay Williams",
    company:"ACME Corporation",
    date:"08-12-2018"
  },
  {
    id: 6,
    engine:"L7044GSI",
    reportName:"L7044GSI Report Forecast #1",
    contact:"Sam Williams",
    company:"Cinco",
    date:"08-19-2018"
  }
]

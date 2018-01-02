import { Component, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material';
import { PartFormComponent } from '../part-form/part-form.component';
import Service from '../../shared-interfaces/service';

@Component({
  selector: 'service-detail',
  templateUrl: './service-detail.component.html'
})
export class ServiceDetailComponent {
  service: Service = SERVICE_DATA;
  partsDataSource: any;
  laborDataSource: any;
  selectedPartRowId: number | String;
  selectedLaborRowId: number | String;
  displayedPartsColumns = ['description', 'number', 'price', 'quantity', 'extendedPrice', 'more'];
  displayedLaborColumns = ['laborDescription', 'laborPrice', 'more'];
  menuItems = [
    { "key": "1", "val": "Edit" },
    { "key": "2", "val": "Delete" }
  ];


  constructor(
    private dialog: MatDialog
    // public dialogRef: MatDialogRef<ServiceDetailComponent>,
    // @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    const { parts, labor } = SERVICE_DATA;
    this.partsDataSource = new MatTableDataSource(parts);
    this.laborDataSource = new MatTableDataSource(labor);
  }

  onPartClick({ id }) {
    this.selectedLaborRowId = null;
    this.selectedPartRowId = id;
  }
  onLaborClick({ id }) {
    this.selectedPartRowId = null;
    this.selectedLaborRowId = id;
  }

  isPartSelected = ({ id }) => this.selectedPartRowId === id;
  isLaborSelected = ({ id }) => this.selectedLaborRowId === id;

  // Report edit functions //
  partMenuItemSelected({ detail: { value } }, part) {
    switch (value) {
      case "Edit":
        this.editPart(part);
        break;

      case "Delete":
        this.deletePart(part);
        break;

      default:
        throw `
        The menu item selected failed to find a action match. Check ServiceDetailComponent.menuItems
        and make sure there's a matching case for each one in ServiceDetailComponent.partMenuItemSelected() switch statement
      `;
    }
  }

  editPart(part) {
    // Open modal with Report Form
    let dialogRef = this.dialog.open(
      PartFormComponent,
      { data: { edit: true, part } }
    );

    dialogRef.afterClosed().subscribe(result => {
      // console.log('The dialog was closed');
    });
  }

  deletePart({ id }) {
    console.log('deleteReport', id);
  }

  laborMenuItemSelected({ detail: { value } }, part) {
    switch (value) {
      case "Edit":
        this.editLabor(part);
        break;

      case "Delete":
        this.deleteLabor(part);
        break;

      default:
        throw `
        The menu item selected failed to find a action match. Check ServiceDetailComponent.menuItems
        and make sure there's a matching case for each one in ServiceDetailComponent.laborMenuItemSelected() switch statement
      `;
    }
  }

  editLabor(labor) {
    console.log(labor);
  }

  deleteLabor({ id }) {
    console.log(id)
  }
}

const SERVICE_DATA: Service = {
  name: 'Planned Service A',
  total: 1235.75,
  totalParts: 635.25,
  totalLabor: 600.60,
  parts: [
    {
      description: 'Kit, Admission Valve Repair',
      id: 9876,
      number: '21665D',
      price: 25.78,
      quantity: 6,
      extendedPrice: 25.78
    },
    {
      description: 'Kit, Admission Valve Repair',
      id: 9875,
      number: '21665D',
      price: 25.78,
      quantity: 6,
      extendedPrice: 25.78
    },
    {
      description: 'Kit, Admission Valve Repair',
      id: 9874,
      number: '21665D',
      price: 25.78,
      quantity: 6,
      extendedPrice: 25.78
    },{
      description: 'Kit, Admission Valve Repair',
      id: 9873,
      number: '21665D',
      price: 25.78,
      quantity: 6,
      extendedPrice: 25.78
    }
  ],
  labor: [
    {
      id: 44,
      description: 'Standard hours (3 hours @ $150 per hour)',
      price: 450.25
    },
    {
      id: 92,
      description: 'Expense (Lodging, Travel, Supplies, Food)',
      price: 150.25
    }
  ]
}

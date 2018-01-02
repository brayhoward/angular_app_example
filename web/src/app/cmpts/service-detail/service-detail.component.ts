import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material';

@Component({
  selector: 'service-detail',
  templateUrl: './service-detail.component.html'
})
export class ServiceDetailComponent {
  service: Service = SERVICE_DATA;
  partsDataSource: any;
  laborDataSource: any;
  selectedRowId: number | String;
  displayedColumns = ['description', 'number', 'price', 'quantity', 'extendedPrice'];


  constructor(
    // public dialogRef: MatDialogRef<ServiceDetailComponent>,
    // @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    const { parts, labor } = SERVICE_DATA;
    this.partsDataSource = new MatTableDataSource(parts);
    this.laborDataSource = new MatTableDataSource(labor);
  }

  onClick({id}) {
    console.log('row clicked');
    this.selectedRowId = id;
  }

  isSelected = ({ id }) => this.selectedRowId === id;
}

// Data models
interface Service {
  name: String,
  total: number,
  parts: Part[],
  labor: Labor[]
}
interface Part {
  description: String,
  number: String,
  id: number | String
  price: number,
  quantity: number,
  extendedPrice: number
}
interface Labor {
  description: String,
  price: number
}

const SERVICE_DATA: Service = {
  name: 'Planned Service A',
  total: 1235.75,
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
      description: 'Standard hours (3 hours @ $150 per hour)',
      price: 450.25
    },
    {
      description: 'Expense (Lodging, Travel, Supplies, Food)',
      price: 150.25
    }
  ]
}

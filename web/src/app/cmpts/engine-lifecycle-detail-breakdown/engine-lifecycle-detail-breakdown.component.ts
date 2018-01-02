import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material';

@Component({
  selector: 'engine-lifecycle-detail-breakdown',
  templateUrl: './engine-lifecycle-detail-breakdown.component.html'
})
export class EngineLifecycleDetailBreakdownComponent {
  partsDataSource: any;
  laborDataSource: any;
  displayedColumns = ['description', 'number', 'price', 'quantity', 'extendedPrice'];


  constructor(
    public dialogRef: MatDialogRef<EngineLifecycleDetailBreakdownComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    const { parts, labor } = SERVICE_DATA;
    this.partsDataSource = new MatTableDataSource(parts);
    this.laborDataSource = new MatTableDataSource(labor);
  }

  onClick(row) {
    console.log('row clicked');
  }
}

// Data models
interface Service {
  parts: Part[],
  labor: Labor[]
}
interface Part {
  description: String,
  number: String,
  price: number,
  quantity: number,
  extendedPrice: number
}
interface Labor {
  description: String,
  price: number
}

const SERVICE_DATA: Service = {
  parts: [
    {
      description: 'Kit, Admission Valve Repair',
      number: '21665D',
      price: 25.78,
      quantity: 6,
      extendedPrice: 25.78
    },
    {
      description: 'Kit, Admission Valve Repair',
      number: '21665D',
      price: 25.78,
      quantity: 6,
      extendedPrice: 25.78
    },
    {
      description: 'Kit, Admission Valve Repair',
      number: '21665D',
      price: 25.78,
      quantity: 6,
      extendedPrice: 25.78
    },{
      description: 'Kit, Admission Valve Repair',
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

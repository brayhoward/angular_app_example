import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { Part } from '../../shared-interfaces/service';
import { PartFormComponent } from '../part-form/part-form.component';

@Component({
  selector: 'parts',
  templateUrl: './parts.component.html',
  styleUrls: ['./parts.component.scss']
})
export class PartsComponent implements OnInit {
  partsList;
  searchPool: any[];
  // Order maters
  displayedColumns = ['description', 'number', 'category', 'type', 'price', 'more'];
  availableRows: number[];
  selectedPartId: number | String;

  constructor(
    private dialog: MatDialog
  ) { }

  ngOnInit() {
    const parts = PARTS_LIST;

    this.partsList = new MatTableDataSource(parts);
    this.searchPool = parts;
    this.availableRows = parts.map(row => (row.id));
  }

   onAddPart() {
    // Open modal with Report Form
    this.dialog.open(
      PartFormComponent,
      { data: {} }
    )
    .afterClosed()
    .subscribe(result => {
      console.log('The dialog was closed');
    });
  };

  editPart(part) {
    // Open modal with Report Form
    this.dialog.open(
      PartFormComponent,
      {
        data: { edit: true, part }
      }
    ).afterClosed().subscribe(result => {
      console.log('The dialog was closed. parts.component.ts');
    });
  }

  deletePart({ id }) {
    console.log('delete part id: ', id);
  }

  searchCallback = results => {
    this.partsList = new MatTableDataSource(results);
  }

  onPartClick = ({ id }) => this.selectedPartId = id;

  isPartSelected = ({ id }) => this.selectedPartId === id;

  menuItemSelected({ detail: { value } }, part) {
    switch (value) {
      case "Edit":
        this.editPart(part);
        break;

      case "Delete":
        this.deletePart(part);
        break;

      default:
        throw `
        The menu item selected failed to find a action match. Check PartsComponent.menuItems
        and make sure there's a matching case for each one in PartsComponent.menuItemSelected() switch statement
      `;
    }
  }
}

const PARTS_LIST = [
  {
    description: 'Kit, Admission Valve Repair',
    id: 1,
    number: '21665D',
    price: 25.78,
    category: 'repair kits',
    type: 'Waukesha'
  },
  {
    description: 'Head Gasket',
    id: 2,
    number: '298237D',
    price: 225.78,
    category: 'gaskets',
    type: 'Waukesha'
  },
  {
    description: 'Oil pan gasket',
    id: 3,
    number: '98345F',
    price: 25.78,
    category: 'gaskets',
    type: 'Waukesha'
  },{
    description: 'Oil pump',
    id: 4,
    number: '8234D',
    price: 2025.78,
    category: 'pumps',
    type: 'Waukesha'
  },
  {
    description: 'Kit, Admission Valve Repair',
    id: 5,
    number: '21665D',
    price: 25.78,
    category: 'repair kits',
    type: 'Waukesha'
  },
  {
    description: 'Head Gasket',
    id: 6,
    number: '298237D',
    price: 225.78,
    category: 'gaskets',
    type: 'Waukesha'
  },
  {
    description: 'Oil pan gasket',
    id: 7,
    number: '98345F',
    price: 25.78,
    category: 'gaskets',
    type: 'Waukesha'
  },{
    description: 'Oil pump',
    id: 8,
    number: '8234D',
    price: 2025.78,
    category: 'pumps',
    type: 'Waukesha'
  },
  {
    description: 'Kit, Admission Valve Repair',
    id: 9,
    number: '21665D',
    price: 25.78,
    category: 'repair kits',
    type: 'Waukesha'
  },
  {
    description: 'Head Gasket',
    id: 10,
    number: '298237D',
    price: 225.78,
    category: 'gaskets',
    type: 'Waukesha'
  },
  {
    description: 'Oil pan gasket',
    id: 11,
    number: '98345F',
    price: 25.78,
    category: 'gaskets',
    type: 'Waukesha'
  },{
    description: 'Oil pump',
    id: 12,
    number: '8234D',
    price: 2025.78,
    category: 'pumps',
    type: 'Waukesha'
  }
  // Shuffle array
].sort(() => Math.random() - 0.5)
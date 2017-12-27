import {Component, Inject} from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { MatDialog } from '@angular/material/dialog';
import { SelectionModel } from '@angular/cdk/collections';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { flatten } from 'lodash';
import { EngineLifecycleDetailBreakdownComponent } from '../engine-lifecycle-detail-breakdown/engine-lifecycle-detail-breakdown.component';

/**
 * @title Table with selection
 */
@Component({
  selector: 'lifecycle-table',
  templateUrl: './lifecycle-table.component.html',
  styleUrls: ['./lifecycle-table.component.scss'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0', visibility: 'hidden' })),
      state('expanded', style({ height: '*', visibility: 'visible' })),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ]
})
export class LifecycleTableComponent {
  displayedColumns: Array<String> = [
    'hours', 'parts', 'labor', 'fuel', 'lubrication', 'total'
  ];
  displayedDetailColumns: Array<String> = [
    'service', 'serviceParts', 'serviceLabor', 'serviceFuel', 'serviceLube', 'serviceTotal'
  ];
  selectedRows: Array<number> = [];
  formatedData: Element;
  dataSource: any;
  expandedElement: any;

  constructor(public dialog: MatDialog) {
    const formatedData = formatData(ELEMENT_DATA);

    this.dataSource = new MatTableDataSource<Element>(formatedData)
  }

  openDetailsDialog(meta): void {
    let dialogRef = this.dialog.open(EngineLifecycleDetailBreakdownComponent, {
      width: '90%',
      data: { ...meta }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }


  isExpansionDetailRow = (i, row) => row.hasOwnProperty('detailRow');

  toggleRow(row) {
    const { isExpanded, selectedRows, } = this;

    this.selectedRows = isExpanded(row) ? selectedRows.filter(id => id !== row.id) : [...this.selectedRows, row.id]
  }

  isExpanded({ id }) {
    return this.selectedRows.includes(id)
  }

  jsonify = node => JSON.stringify(node);

  log = (node, name = 'node') => {
    console.log(name, 'LOGGED BELLOW');
    console.log(node);
  }

  getDetailValues = row => Object.keys(row).map(key => row[key]);

  // TODO: move this to a component for reuse elsewhere
  noCost = () => "$-"
}

const ELEMENT_DATA = [
  {
    id: 0, hours: 0, parts: 62686, labor: 0, fuel: 56880, lubrication: 4140, total: 1521, details: [
      { service: 'Planned Service A', parts: 635, labor: 600, fuel: null, lubrication: null, total: 1255 ,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Lube oil change', parts: null, labor: 450, fuel: null, lubrication: 581, total: 4100 ,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Planned Service B', parts: 1756, labor: 1155, fuel: null, lubrication: null, total: 2911,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Fuel Cost (8,000-12,000 Hours)', parts: null, labor: null, fuel: 56880, lubrication: null, total: 56880,
        meta: {
          foo: 'bar'
        }
      }
    ]
  },
  {
    id: 2, hours: 4000, parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686, details: [
      { service: 'Planned Service A', parts: 635, labor: 600, fuel: null, lubrication: null, total: 1255 ,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Lube oil change', parts: null, labor: 450, fuel: null, lubrication: 581, total: 4100 ,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Planned Service B', parts: 1756, labor: 1155, fuel: null, lubrication: null, total: 2911,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Fuel Cost (8,000-12,000 Hours)', parts: null, labor: null, fuel: 56880, lubrication: null, total: 56880,
        meta: {
          foo: 'bar'
        }
      }
    ]
  },
  {
    id: 3, hours: 8000, parts: 2973, labor: 1050, fuel: 56880, lubrication: 4140, total: 65043, details: [
      { service: 'Planned Service A', parts: 635, labor: 600, fuel: null, lubrication: null, total: 1255 ,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Lube oil change', parts: null, labor: 450, fuel: null, lubrication: 581, total: 4100 ,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Planned Service B', parts: 1756, labor: 1155, fuel: null, lubrication: null, total: 2911,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Fuel Cost (8,000-12,000 Hours)', parts: null, labor: null, fuel: 56880, lubrication: null, total: 56880,
        meta: {
          foo: 'bar'
        }
      }
    ]
  },
  {
    id: 4, hours: 12000, parts: 1226, labor: 450, fuel: 56880, lubrication: 4140, total: 62686, details: [
      { service: 'Planned Service A', parts: 635, labor: 600, fuel: null, lubrication: null, total: 1255 ,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Lube oil change', parts: null, labor: 450, fuel: null, lubrication: 581, total: 4100 ,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Planned Service B', parts: 1756, labor: 1155, fuel: null, lubrication: null, total: 2911,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Fuel Cost (8,000-12,000 Hours)', parts: null, labor: null, fuel: 56880, lubrication: null, total: 56880,
        meta: {
          foo: 'bar'
        }
      }
    ]
  },
  {
    id: 5, hours: 16000, parts: 6800, labor: 1800, fuel: 56880, lubrication: 4140, total: 69620, details: [
      { service: 'Planned Service A', parts: 635, labor: 600, fuel: null, lubrication: null, total: 1255 ,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Lube oil change', parts: null, labor: 450, fuel: null, lubrication: 581, total: 4100 ,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Planned Service B', parts: 1756, labor: 1155, fuel: null, lubrication: null, total: 2911,
        meta: {
          foo: 'bar'
        }
      },
      { service: 'Fuel Cost (8,000-12,000 Hours)', parts: null, labor: null, fuel: 56880, lubrication: null, total: 56880,
        meta: {
          foo: 'bar'
        }
      }
    ]
  }
];

// move details to it own item in the array with the same id directly after its parent array item
// example:
// [{ id: 1, hours: 1000, parts: null, details: [...] }] ->
// [{ id: 1, hours: 1000, parts: null, details: [...] }, { id: 1, details: [...] }]
function formatData(data) {
  return flatten (
    data.map(row => [row, ...row.details.map( detailRow => ({ detailRow: true, id: row.id, ...detailRow }) )])
  )
}

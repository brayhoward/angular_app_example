import {Component} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import { SelectionModel } from '@angular/cdk/collections';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { flatten } from 'lodash';

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
  private displayedColumns: Array<String> = ['expand', 'hours', 'parts', 'labor', 'fuel', 'lubrication', 'total'];
  private selectedRows: Array<number> = [];
  private formatedData: Element;
  private dataSource: any;
  private expandedElement: any;

  constructor() {
    const formatedData = formatData(ELEMENT_DATA);

    this.dataSource = new MatTableDataSource<Element>(formatedData)
  }

  isExpansionDetailRow = (i, row) => row.hasOwnProperty('detailRow');

  toggleRow(row) {
    this.selectedRows = this.isExpanded(row) ?
      this.selectedRows.filter(id => id !== row.id)
      :
      [...this.selectedRows, row.id]
  }

  isExpanded({ id }) {
    return this.selectedRows.includes(id)
  }

  jsonify = node => JSON.stringify(node);

  getDetailValues = row => Object.keys(row).map(key => row[key]);

  // TODO: move this to a component for reuse elsewhere
  noCost = () => "$-"
}

const ELEMENT_DATA = [
  {
    id: 0, hours: 0, parts: 62686, labor: 0, fuel: 56880, lubrication: 4140, total: 1521, details: [
      { service: 'Planned Service A', parts: 635, labor: 600, fuel: null, lubrication: null, total: 1255 },
      { service: 'Lube oil change', parts: null, labor: 450, fuel: null, lubrication: 581, total: 4100 }
    ]
  },
  {
    id: 2, hours: 4000, parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686, details: [
      { service: 'Planned Service A', parts: 635, labor: 600, fuel: null, lubrication: null, total: 1255 },
      { service: 'Lube oil change', parts: null, labor: 450, fuel: null, lubrication: 581, total: 4100 }
    ]
  },
  {
    id: 3, hours: 8000, parts: 2973, labor: 1050, fuel: 56880, lubrication: 4140, total: 65043, details: [
      { service: 'Planned Service A', parts: 635, labor: 600, fuel: null, lubrication: null, total: 1255 },
      { service: 'Lube oil change', parts: null, labor: 450, fuel: null, lubrication: 581, total: 4100 }
    ]
  }
];


// move details to it own item in the array with the same id directly after its parent array item
// example:
// [{ id: 1, hours: 1000, parts: null, details: [...] }] ->
// [{ id: 1, hours: 1000, parts: null, details: [...] }, { id: 1, details: [...] }]
function formatData(data) {
  return flatten (
    data.map(row => [row, { detailRow: true, id: row.id, details: row.details }])
  )
}

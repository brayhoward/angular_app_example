import { Element } from './../../../../.history/src/app/cmpts/lifecycle-table/lifecycle-table.component_20171221114813';
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
}

interface Element {
  id: number
  hours: number;
  parts: number;
  labor: number;
  fuel: number;
  lubrication: number;
  total: number,
  detailRow?: boolean
}

const ELEMENT_DATA: Element[] = [
  {id: 0, hours: 0, parts: 62686, labor: 0, fuel: 56880, lubrication: 4140, total: 1521},
  {id: 2, hours: 4000, parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686},
  {id: 3, hours: 8000, parts: 2973, labor: 1050, fuel: 56880, lubrication: 4140, total: 65043}//,
  // {hours: 12000, parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686, details: 'detail datas'},
  // {hours: 16000, parts: 6800, labor: 1800, fuel: 56880, lubrication: 4140, total: 69620, details: 'detail datas'},
  // {hours: 20000, parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686, details: 'detail datas'},
  // {hours: 24000, parts: 23440, labor: 17310, fuel: 56880, lubrication: 4140, total: 10177, details: 'detail datas'0},
  // {hours: 28000, parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686, details: 'detail datas'},
  // {hours: 32000, parts: 6800, labor: 1800, fuel: 56880, lubrication: 4140, total: 62686, details: 'detail datas'},
  // {hours: 36000, parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686, details: 'detail datas'},
  // {hours: 40000, parts: 2973, labor: 1050, fuel: 56880, lubrication: 4140, total: 62686, details: 'detail datas'},
  // {hours: 44000, parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686, details: 'detail datas'},
  // {hours: 48000, parts: 83976, labor: 44895, fuel: 56880, lubrication: 4140, total: 18989, details: 'detail datas'1},
  // {hours: 52000, parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686, details: 'detail datas'}
]

function formatData(data) {
  return flatten (
    data.map(row => [row, { detailRow: true, ...row }])
  )
}

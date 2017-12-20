import {Component} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import { SelectionModel } from '@angular/cdk/collections';

/**
 * @title Table with selection
 */
@Component({
  selector: 'lifecycle-table',
  templateUrl: './lifecycle-table.component.html',
  styleUrls: ['./lifecycle-table.component.scss']
})
export class LifecycleTableComponent {
  displayedColumns = ['select', 'hours', 'parts', 'labor', 'fuel', 'lubrication', 'total'];
  dataSource = new MatTableDataSource<Element>(ELEMENT_DATA);
  selection = new SelectionModel<Element>(true, []);

  toggle(row){
    this.selection.toggle(row)

    console.log('toggle(row)', 'LOGGED BELLOW');
    console.log(row);
  }

  iconClick(row) {
    console.log('iconClick(row)', 'LOGGED BELLOW');
    console.log(row);
  }
  /** Whether the number of selected elements matches the total number of rows. */
  // isAllSelected() {
  //   const numSelected = this.selection.selected.length;
  //   const numRows = this.dataSource.data.length;
  //   return numSelected === numRows;
  // }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  // masterToggle() {
  //   this.isAllSelected() ?
  //       this.selection.clear() :
  //       this.dataSource.data.forEach(row => this.selection.select(row));
  // }
}

export interface Element {
  hours: number;
  parts: number;
  labor: number;
  fuel: number;
  lubrication: number;
  total: number;
}

const ELEMENT_DATA: Element[] = [
  {hours: '0', parts: 62686, labor: 0, fuel: 56880, lubrication: 4140, total: 1521},
  {hours: '4000', parts: 1216, labor: 450, fuel: 56880, lubrication: 4140 total: 62686},
  {hours: '8000', parts: 2973, labor: 1050, fuel: 56880, lubrication: 4140, total: 65043},
  {hours: '12000', parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686},
  {hours: '16000', parts: 6800, labor: 1800, fuel: 56880, lubrication: 4140 total: 69620},
  {hours: '20000', parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686},
  {hours: '24000', parts: 23440, labor: 17310, fuel: 56880, lubrication: 4140 total: 101770},
  {hours: '28000', parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686},
  {hours: '32000', parts: 6800, labor: 1800, fuel: 56880, lubrication: 4140 total: 62686},
  {hours: '36000', parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686},
  {hours: '40000', parts: 2973, labor: 1050, fuel: 56880, lubrication: 4140 total: 62686},
  {hours: '44000', parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686},
  {hours: '48000', parts: 83976, labor: 44895, fuel: 56880, lubrication: 4140 total: 189891},
  {hours: '52000', parts: 1216, labor: 450, fuel: 56880, lubrication: 4140, total: 62686}
]4881252
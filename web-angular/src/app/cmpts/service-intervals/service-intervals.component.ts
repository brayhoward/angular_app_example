import {Component} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {SelectionModel} from '@angular/cdk/collections';

/**
 * @title Table with selection
 */
@Component({
  selector: 'service-intervals',
  styleUrls: ['./service-intervals.component.scss'],
  templateUrl: './service-intervals.component.html',
})
export class ServiceIntervalsComponent {
  displayedColumns = ['select', 'service', 'interval', 'parts', 'labor', 'price'];
  dataSource = new MatTableDataSource<Element>(ELEMENT_DATA);
  selection = new SelectionModel<Element>(true, []);

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    this.isAllSelected() ?
        this.selection.clear() :
        this.dataSource.data.forEach(row => this.selection.select(row));
  }
}

export interface Element {
  service: string;
  interval: number;
  parts: number;
  labor: number;
  price:number;
}

const ELEMENT_DATA: Array<Element> = [
  {service: 'Commissioning Parts', interval: 0, parts: 1521, labor: 0, price: 1521},
  {service: 'Emergency Spare Parts', interval: 0, parts: 21758, labor: 0, price: 21758},
  {service: 'Lube Oil Change', interval: 6000, parts: 581, labor: 200, price: 1031},
  {service: 'Planned Service A', interval: 4000, parts: 635, labor: 600, price: 1235},
  {service: 'Planned Service B', interval: 8000, parts: 1756, labor: 1155, price: 2911},
  {service: 'Planned Service C', interval: 16000, parts: 1521, labor: 750, price: 4577},
  {service: 'Top End Overhaul', interval: 24000, parts: 20468, labor: 16260, price: 36728},
  {service: 'Bottom End Overhaul', interval: 48000, parts: 56708, labor: 26835, price: 83543}
];

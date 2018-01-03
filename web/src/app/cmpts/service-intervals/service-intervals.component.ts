import { Component, AfterViewChecked } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { SelectionModel } from '@angular/cdk/collections';

// Make typescript stop complaining
declare var Morris: any;

/**
 * @title Table with selection
 */
@Component({
  selector: 'service-intervals',
  styleUrls: ['./service-intervals.component.scss'],
  templateUrl: './service-intervals.component.html',
})
export class ServiceIntervalsComponent implements AfterViewChecked {
  displayedColumns = ['select', 'service', 'interval', 'parts', 'labor', 'price'];
  dataSource = new MatTableDataSource<Element>(ELEMENT_DATA);
  selection = new SelectionModel<Element>(true, []);
  chartNotInitialized = true;

  ngAfterViewChecked() {
    isElementRendered('intervals-chart') && this.chartNotInitialized && this.initChart();
  }

  initChart() {
    this.chartNotInitialized = false;

    Morris.Bar({
      element: 'intervals-chart',
      data: [
        { y: '2006', a: 100, b: 90 },
        { y: '2007', a: 75,  b: 65 },
        { y: '2008', a: 50,  b: 40 },
        { y: '2009', a: 75,  b: 65 },
        { y: '2010', a: 50,  b: 40 },
        { y: '2011', a: 75,  b: 65 },
        { y: '2012', a: 100, b: 90 }
      ],
      xkey: 'y',
      ykeys: ['a', 'b'],
      labels: ['Series A', 'Series B'],
      stacked: true
    });
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

// Hack because angular lifecycle methods are seriously lacking
const isElementRendered = id => !!document.getElementById(id);

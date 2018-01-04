import { Component, AfterViewChecked } from '@angular/core';
import { CurrencyPipe } from '@angular/common';
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
  providers: [ CurrencyPipe ]
})
export class ServiceIntervalsComponent implements AfterViewChecked {
  displayedColumns = ['select', 'service', 'interval', 'parts', 'labor', 'price'];
  dataSource = new MatTableDataSource<Element>(ELEMENT_DATA);
  selection = new SelectionModel<Element>(true, []);
  chartNotInitialized = true;

  constructor(
    private currency: CurrencyPipe
  ) { }

  ngAfterViewChecked() {
    isElementRendered('intervals-chart') && this.chartNotInitialized && this.initChart();
  }

  initChart() {
    // Prevent initalizing chart thousands of times
    this.chartNotInitialized = false;

    Morris.Bar({
      element: 'intervals-chart',
      data: [
        { name: 'Commissioning...', parts: 1521, labor: 0 },
        { name: 'Emergency Spare Parts', parts: 21758,  labor: 0 },
        { name: 'Lube Oil Change', parts: 581,  labor: 200 },
        { name: 'Planned Service A', parts: 635,  labor: 600 },
        { name: 'Planned Service B', parts: 1756, labor: 1155 },
        { name: 'Planned Service C', parts: 1521,  labor: 750 },
        { name: 'Top End Overhaul', parts: 20468,  labor: 16260 },
        { name: 'Bottom End Overhaul', parts: 56708,  labor: 26835 }
      ],
      xkey: 'name',
      ykeys: ['parts', 'labor'],
      labels: ['Parts', 'Labor'],
      barColors: ['cyan', 'orange'],
      hideHover: false,
      stacked: true,
      hoverCallback: (index, options, content, row) => `
        <strong>${this.cashOut(row.parts)}</strong>
      `,
      axes: true,
      grid: true,
      gridTextColor: "#2F3133",
      gridTextSize: 12,
      gridTextFamily: 'inherit',
      gridTextWeight: 'normal',
      resize: true,
      barSizeRatio: 0.25,
      barGap: 1
    });
  }

  cashOut = (num) => this.currency.transform(num);
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

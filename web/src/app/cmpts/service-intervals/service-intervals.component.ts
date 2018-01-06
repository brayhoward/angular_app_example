import { Component, AfterViewChecked. OnInit } from '@angular/core';
import { CurrencyPipe } from '@angular/common';
import { MatTableDataSource } from '@angular/material';
import { SelectionModel } from '@angular/cdk/collections';
import { blue, orange, black } from '../../constants/graph-color-pallet';

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
export class ServiceIntervalsComponent implements AfterViewChecked, OnInit {
  displayedColumns = ['select', 'service', 'interval', 'parts', 'labor', 'price'];
  dataSource: any;
  chartNotInitialized = true;
  selectedRows: number[]

  constructor(
    private currency: CurrencyPipe
  ) { }

  ngOnInit() {
    const services = ELEMENT_DATA;

    this.selectedRows = services.map( service => service.id )
    this.dataSource = new MatTableDataSource(services);
  }

  ngAfterViewChecked() {
    isElementRendered('intervals-chart') && this.chartNotInitialized && this.initChart();
  }

  initChart() {
    // Prevent initalizing chart thousands of times
    this.chartNotInitialized = false;

    Morris.Bar({
      element: 'intervals-chart',
      data: [
        { name: 'Commis...', parts: 1521, labor: 0 },
        { name: 'Emergency', parts: 21758,  labor: 0 },
        { name: 'Lube Oil', parts: 581,  labor: 200 },
        { name: 'Planned A', parts: 635,  labor: 600 },
        { name: 'Planned B', parts: 1756, labor: 1155 },
        { name: 'Planned C', parts: 1521,  labor: 750 },
        { name: 'Top End', parts: 20468,  labor: 16260 },
        { name: 'Bottom End', parts: 56708,  labor: 26835 }
      ],
      xkey: 'name',
      ykeys: ['parts', 'labor'],
      labels: ['Parts', 'Labor'],
      barColors: [blue, orange],
      hideHover: false,
      stacked: true,
      hoverCallback: (index, options, content, { labor, parts }) => `
        <div style="color: ${black};" class="txt-left">
          <div>
            <strong>parts: </strong> ${this.cashOut(parts)}
          </div>

          <div>
            <strong>labor: </strong>${this.cashOut(labor)}
          </div>

          <div class="hr u-mt-- u-mb--"></div>

          <strong>total: ${this.cashOut(parts + labor)}</strong>
        <div>
      `,
      axes: true,
      grid: true,
      gridTextColor: black,
      gridTextSize: 12,
      gridTextFamily: 'inherit',
      gridTextWeight: 'normal',
      resize: true,
      barSizeRatio: 0.50
    });
  }

  cashOut = (num) => this.currency.transform(num);

  toggleRow({ detail: { value }}, row) {
    const { isSelected, selectedRows, } = this;

    this.selectedRows = value ? [...this.selectedRows, row.id] : selectedRows.filter(id => id !== row.id)
  }

  isSelected = ({ id }) => this.selectedRows.includes(id);
}

const ELEMENT_DATA = [
  {service: 'Commissioning Parts', interval: 0, parts: 1521, labor: 0, price: 1521, id: 1},
  {service: 'Emergency Spare Parts', interval: 0, parts: 21758, labor: 0, price: 21758, id: 2},
  {service: 'Lube Oil Change', interval: 6000, parts: 581, labor: 200, price: 1031, id: 3},
  {service: 'Planned Service A', interval: 4000, parts: 635, labor: 600, price: 1235, id: 4},
  {service: 'Planned Service B', interval: 8000, parts: 1756, labor: 1155, price: 2911, id: 5},
  {service: 'Planned Service C', interval: 16000, parts: 1521, labor: 750, price: 4577, id: 6},
  {service: 'Top End Overhaul', interval: 24000, parts: 20468, labor: 16260, price: 36728, id: 7},
  {service: 'Bottom End Overhaul', interval: 48000, parts: 56708, labor: 26835, price: 8354, id: 4}
];

// Hack because angular lifecycle methods are seriously lacking
const isElementRendered = id => !!document.getElementById(id);

import { Component, OnInit, AfterViewChecked } from '@angular/core';
import { DecimalPipe, CurrencyPipe } from '@angular/common';
import { AfterContentChecked } from '@angular/core/src/metadata/lifecycle_hooks';

// Make typescript stop complaining
declare var Morris: any;

const graphTargetId = 'lifecycle-chart';

@Component({
  selector: 'engine-lifecycle',
  templateUrl: './engine-lifecycle.component.html',
  styleUrls: ['./engine-lifecycle.component.scss'],
  providers: [ DecimalPipe, CurrencyPipe ]
})
export class EngineLifecycleComponent implements OnInit, AfterContentChecked {
  chartNotInitialized = true;

  constructor(
    private numberFormatter: DecimalPipe,
    private currency: CurrencyPipe
  ) { }

  ngOnInit() {}

  ngAfterContentChecked() {
    isElementRendered(graphTargetId) && this.chartNotInitialized && this.initChart();
  }

  initChart() {
    this.chartNotInitialized = false;

    Morris.Area({
      element: graphTargetId,
      data: [
        { hours: '0', fuel: null, lubrication: null, labor: null, parts: 1521 },
        { hours: '4000', fuel: 56880,  lubrication: 4140, labor: 450, parts: 62686 },
        { hours: '8000', fuel: 56880,  lubrication: 4140, labor: 1050, parts: 65043 },
        { hours: '1200', fuel: 56880,  lubrication: 4140, labor: 450, parts: 62686 },
        { hours: '1600', fuel: 56880,  lubrication: 4140, labor: 1800, parts: 69620 },
        { hours: '2000', fuel: 56880,  lubrication: 4140, labor: 450, parts: 62686 },
        { hours: '2400', fuel: 56880, lubrication: 4140, labor: 70000, parts: 101770 }
      ],
      xkey: 'hours',
      ykeys: ['fuel', 'lubrication', 'labor', 'parts'],
      labels: ['Fuel', 'Lubrication', 'Labor', 'Parts'],
      parseTime: false,
      // xLabels: "hour",
      xLabelAngle: 0,
      xLabelFormat: ({ label }) => (
        this.numberFormatter.transform(~~label)
      ),
      ymax: 200000,
      smooth: false,
      preUnits: "$",
      goals: [],
      goalStrokeWidth: 2,
      lineColors: ['yellow', 'violet', 'cyan', 'orange'],
      lineWidth: 1,
      pointSize: 4,
      pointFillColors: ['#000', '#000', '#000', '#000'],
      hideHover: false,
      hoverCallback: (_index, _options, _content, { hours, fuel, labor, lubrication, parts }) => (
        `
        <div style="color: black;">
          <div style="text-align: center">
            <strong>${this.numberFormatter.transform(~~hours)}hrs</strong>
          </div>
          <div style="text-align: left">
            <div>
              <strong>parts: </strong>$${this.numberFormatter.transform(parts)}
            </div>
            <div>
              <strong>labor: </strong>$${this.numberFormatter.transform(labor)}
            </div>
            <div>
              <strong>lube: </strong>$${this.numberFormatter.transform(lubrication)}
            </div>
            <div>
              <strong>fuel: </strong>$${this.numberFormatter.transform(fuel)}
            </div>
          </div>
        </div>
        `
      ),
      axes: true,
      grid: true,
      gridTextColor: "#2F3133",
      gridTextSize: 12,
      gridTextFamily: 'inherit',
      gridTextWeight: 'normal',
      fillOpacity: 1.0,
      resize: true,
      barSizeRatio: 0.25,
      barGap: 1
    });
  }
}
// Hack because angular lifecycle methods are seriously lacking
const isElementRendered = id => !!document.getElementById(id);

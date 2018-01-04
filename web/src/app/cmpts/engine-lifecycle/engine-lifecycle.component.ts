import { Component, OnInit, AfterViewChecked } from '@angular/core';
import { DecimalPipe, CurrencyPipe } from '@angular/common';
import { AfterContentChecked } from '@angular/core/src/metadata/lifecycle_hooks';
import { yellow, orange, blue, violet, black } from '../../constants/graph-color-pallet';

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
        { hours: '0', fuel: 0, lubrication: 0, labor: 0, parts: 1521},
        { hours: '4000', fuel: 56880, lubrication: 4140, labor: 450, parts: 1216 },
        { hours: '8000', fuel: 56880, lubrication: 4140, labor: 1050, parts: 2973 },
        { hours: '1200', fuel: 56880, lubrication: 4140, labor: 450, parts: 1216 },
        { hours: '1600', fuel: 56880, lubrication: 4140, labor: 1800, parts: 6800 },
        { hours: '2000', fuel: 56880, lubrication: 4140, labor: 450, parts: 1216 },
        { hours: '2400', fuel: 56880, lubrication: 4140, labor: 70000, parts: 23440 },
        { hours: '2800', fuel: 56880, lubrication: 4140, labor: 450, parts: 1216 },
        { hours: '3200', fuel: 56880, lubrication: 4140, labor: 1800, parts: 6800 },
        { hours: '3600', fuel: 56880, lubrication: 4140, labor: 450, parts: 1216 },
        { hours: '40000', fuel: 56880, lubrication: 4140, labor: 1050, parts: 2973 },
        { hours: '44000', fuel: 56880, lubrication: 4140, labor: 450, parts: 1216 },
        { hours: '48000', fuel: 56880, lubrication: 4140, labor: 44895, parts: 83976 },
        { hours: '52000', fuel: 56880, lubrication: 4140, labor: 450, parts: 1216 }
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

            <div class="hr u-mt-- u-mb-- "></div>

            <div>
              <strong>total: $${this.numberFormatter.transform(
                [fuel, labor, lubrication, parts].reduce((prev, curr) => prev + curr)
              )}
              </strong>
            </div>
            <br/>
          </div>
        </div>
        `
      ),
      axes: true,
      grid: true,
      gridTextColor: black,
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

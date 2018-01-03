import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'engine-lifecycle',
  templateUrl: './engine-lifecycle.component.html',
  styleUrls: ['./engine-lifecycle.component.scss']
})
export class EngineLifecycleComponent implements OnInit {
  chartData: any;
  chartConfig = {
    "fistSeries": {
      "name": "Parts",
      "x": "x",
      "y": "y",
      "yAxisUnit": "$"
    },
    "secondSeries": {
      "name": "Labor",
      "x": "x",
      "y": "y1",
      "yAxisUnit": "$"
    },
    "thirdSeries": {
      "name": "Fuel",
      "x": "x",
      "y": "y2",
      "yAxisUnit": "$"
    },
    "fourthSeries": {
      "name": "Lube",
      "x": "x",
      "y": "y3",
      "yAxisUnit": "$"
    }
  }

  ngOnInit() {
    this.chartData = [
      {
        "x": 0,
        "y3": 0,
        "y2": 0,
        "y1": 0,
        "y": 0
      }, {
        "x": 4,
        "y3": 50,
        "y2": 45,
        "y1": 55,
        "y": 60
      }, {
        "x": 8,
        "y3": 50,
        "y2": 45,
        "y1": 55,
        "y": 60
      }, {
        "x": 12,
        "y3": 50,
        "y2": 45,
        "y1": 55,
        "y": 60
      }, {
        "x": 16,
        "y3": 50,
        "y2": 45,
        "y1": 55,
        "y": 60
      }, {
        "x": 20,
        "y2": 45,
        "y1": 75,
        "y": 70
      }, {
        "x": 24,
        "y2": 45,
        "y1": 55,
        "y": 62
      }, {
        "x": 28,
        "y3": 50,
        "y2": 45,
        "y1": 55,
        "y": 62
      }, {
        "x": 32,
        "y2": 45,
        "y1": 55,
        "y": 62
      }, {
        "x": 36,
        "y2": 45,
        "y1": 55,
        "y": 62
      }, {
        "x": 40,
        "y2": 45,
        "y1": 55,
        "y": 62
      }, {
        "x": 44,
        "y2": 45,
        "y1": 55,
        "y": 62
      }
    ]
  }
}
